package com.fastcampus.userservice.service

import com.fastcampus.userservice.domain.entity.User
import com.fastcampus.userservice.domain.repository.UserRepository
import com.fastcampus.userservice.global.config.JWTProperties
import com.fastcampus.userservice.global.exception.PasswordNotMatchedException
import com.fastcampus.userservice.global.exception.UserExistsException
import com.fastcampus.userservice.global.exception.UserNotFoundException
import com.fastcampus.userservice.global.utils.BCryptUtils
import com.fastcampus.userservice.global.utils.JWTClaim
import com.fastcampus.userservice.global.utils.JWTUtils
import com.fastcampus.userservice.model.SignInRequest
import com.fastcampus.userservice.model.SignInResponse
import com.fastcampus.userservice.model.SignUpRequest
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {
    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(request: SignUpRequest) {
        with(request) {
            userRepository.findByEmail(email = email)?.let {
                throw UserExistsException()
            }

            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )

            userRepository.save(user)
        }
    }

    suspend fun signIn(request: SignInRequest): SignInResponse {
        return with(
            userRepository.findByEmail(email = request.email)
                ?: throw UserNotFoundException()
        ) {
            val verified = BCryptUtils.verify(
                password = request.password,
                hashedPassword = this.password,
            )

            if (!verified) {
                throw PasswordNotMatchedException()
            }

            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username,
            )

            val token = JWTUtils.createToken(
                claim = jwtClaim,
                properties = jwtProperties,
            )

            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)

            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token: String) {
        cacheManager.awaitEvict(token)
    }
}