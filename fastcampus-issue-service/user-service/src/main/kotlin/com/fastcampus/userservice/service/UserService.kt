package com.fastcampus.userservice.service

import com.fastcampus.userservice.domain.entity.User
import com.fastcampus.userservice.domain.repository.UserRepository
import com.fastcampus.userservice.global.exception.UserExistsException
import com.fastcampus.userservice.global.utils.BCryptUtils
import com.fastcampus.userservice.model.SignUpRequest
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

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
}