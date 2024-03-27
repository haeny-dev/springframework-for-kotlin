package com.fastcampus.userservice.global.utils

import com.auth0.jwt.JWT
import com.fastcampus.userservice.global.config.JWTProperties
import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JWTUtilsTest {

    private val logger = KotlinLogging.logger { }

    @Test
    fun createTokenTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gmail.com",
            profileUrl = "profile.jpg",
            username = "개발자",
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret",
        )

        val token = JWTUtils.createToken(
            claim = jwtClaim,
            properties = properties,
        )

        assertNotNull(token)

        logger.info { "token: $token" }
    }

    @Test
    fun decodeTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gmail.com",
            profileUrl = "profile.jpg",
            username = "개발자",
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret",
        )

        val token = JWTUtils.createToken(
            claim = jwtClaim,
            properties = properties,
        )

        val decode = JWTUtils.decode(
            token = token,
            issuer = properties.issuer,
            secret = properties.secret,
        )

        with(decode) {
            logger.info { "claims: $claims" }

            assertEquals(jwtClaim.userId, claims["userId"]!!.asLong())
            assertEquals(jwtClaim.email, claims["email"]!!.asString())
            assertEquals(jwtClaim.profileUrl, claims["profileUrl"]!!.asString())
            assertEquals(jwtClaim.username, claims["username"]!!.asString())
        }
    }
}