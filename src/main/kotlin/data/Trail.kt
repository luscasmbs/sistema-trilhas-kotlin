package data
import data.courses
import enums.TrailStatus

data class Trail(
    val id: Int,
    val name: String,
    val course: List<Course>,
    val status: TrailStatus
){
    private val courses = mutableListOf<Course>()
    fun addCourse(course: Course){
        courses.add(course)
    }
}
