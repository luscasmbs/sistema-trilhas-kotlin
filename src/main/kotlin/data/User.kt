package data

import enums.StudentSituation
import enums.UserType

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    var role: UserType? = null,
    val student: Student? = null
    ) {
    init {
        require(name.isNotBlank()) { "O nome é obrigatório" }
        require(name.length > 2) { "O nome precisa ter pelo menos 3 caracteres" }
        require(email.isNotBlank()) { "O email é obrigatório" }
        require(password.length >= 4){"A senha deve ter pelo menos 4 caracteres" }
    }
}