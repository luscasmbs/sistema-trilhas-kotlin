package data
import enums.TrailStatus

data class Trail(
    val id: Int,
    val name: String,
    val course: MutableList<Course>,
    val status: TrailStatus
)