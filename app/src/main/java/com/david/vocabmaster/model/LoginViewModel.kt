package com.david.vocabmaster.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun validateLogin(): Boolean {
        if (!email.value.contains("@")) {
            _error.value = "El email no es válido"
            return false
        }
        if (password.value.length < 6) {
            _error.value = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }
}