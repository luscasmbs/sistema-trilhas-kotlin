package data

import enums.EnrollmentStatus

data class Enrollment(
    val student: Student,
    val trail: Trail,
    val status: EnrollmentStatus
)
