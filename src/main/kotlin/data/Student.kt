package data

import enums.StudentSituation

data class Student(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val student: StudentSituation,
)
