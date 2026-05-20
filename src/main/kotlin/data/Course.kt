package data

import enums.CourseCategory
import enums.CourseLevel

data class Course(
    val id: Int,
    val name: String,
    val workload: Int,
    val courseLevel: CourseLevel,
    val courseCategory: CourseCategory
)
