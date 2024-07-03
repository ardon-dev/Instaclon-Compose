package com.example.instagramcompose.login.domain

import com.example.instagramcompose.login.data.network.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}