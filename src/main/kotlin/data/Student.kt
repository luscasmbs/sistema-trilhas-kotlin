package data

import enums.CourseCategory
import enums.StudentSituation

data class Student(
    val trail: MutableList<Int> = mutableListOf(),
    val student: StudentSituation = StudentSituation.ATIVO,
    val courses: MutableList<Int> = mutableListOf(),
)
