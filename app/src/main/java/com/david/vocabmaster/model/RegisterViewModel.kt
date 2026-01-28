package com.david.vocabmaster.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error
    fun onNameChange(v: String) { _name.value = v }
    fun onEmailChange(v: String) { _email.value = v }
    fun onPasswordChange(v: String) { _password.value = v }
    fun onConfirmChange(v: String) { _confirmPassword.value = v }

    fun validate(): Boolean {
        if (name.value.isEmpty()) {
            _error.value = "El nombre no puede estar vacío"
            return false
        }
        if (!email.value.contains("@")) {
            _error.value = "El email no es válido"
            return false
        }
        if (password.value.length < 6) {
            _error.value = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        if (password.value != confirmPassword.value) {
            _error.value = "Las contraseñas no coinciden"
            return false
        }
        _error.value = null
        return true
    }
}