package data
object MemoryStorage {
    val registerUser = mutableListOf<User>()
    val courses = mutableListOf<Course>()
    val trail = mutableListOf<Trail>()
    val enrollment = mutableListOf<Enrollment>()
    val donecourses = mutableListOf<Int>()
}