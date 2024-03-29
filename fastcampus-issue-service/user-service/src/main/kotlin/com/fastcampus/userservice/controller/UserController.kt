package com.fastcampus.userservice.controller

import com.fastcampus.userservice.global.annotation.AuthToken
import com.fastcampus.userservice.model.MeResponse
import com.fastcampus.userservice.model.SignInRequest
import com.fastcampus.userservice.model.SignInResponse
import com.fastcampus.userservice.model.SignUpRequest
import com.fastcampus.userservice.model.UserEditRequest
import com.fastcampus.userservice.service.UserService
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RequestMapping("/api/v1/uesrs")
@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/signup")
    suspend fun signUp(@RequestBody request: SignUpRequest) {
        userService.signUp(request)
    }

    @PostMapping("/signin")
    suspend fun signIn(@RequestBody request: SignInRequest): SignInResponse {
        return userService.signIn(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    suspend fun logout(@AuthToken token: String) {
        userService.logout(token)
    }

    @GetMapping("/me")
    suspend fun get(@AuthToken token: String): MeResponse {
        return MeResponse(userService.getByToken(token))
    }

    @GetMapping("/{userId}/username")
    suspend fun getUsername(@PathVariable userId: Long): Map<String, String> {
        return mapOf("reporter" to userService.get(userId = userId).username)
    }

    @PostMapping("/{id}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    suspend fun edit(
        @PathVariable id: Long,
        @ModelAttribute request: UserEditRequest,
        @AuthToken token: String,
        @RequestPart("profileUrl") filePart: FilePart,
    ) {
        val orgFileName = filePart.filename()
        var filename: String? = null

        if (orgFileName.isNotBlank()) {
            val ext = orgFileName.split(".").last()
            filename = "$id.$ext"

            val file = File(ClassPathResource("/images/").file, filename)
            filePart.transferTo(file).awaitSingleOrNull()
        }

        userService.edit(token, request.username, filename)
    }
}