package service

import data.MemoryStorage
import data.User

fun studentviewt(alunoLogado: User) {
    println("\n--- MINHAS TRILHAS MATRICULADAS ---")

    val idsTrilhasAluno = alunoLogado.student?.trail

    if (idsTrilhasAluno == null || idsTrilhasAluno.isEmpty()) {
        println("Você ainda não está matriculado em nenhuma trilha pedagógica.")
        return
    }

    for (idTrilha in idsTrilhasAluno) {
        val trilha = MemoryStorage.trail.find { it.id == idTrilha }

        if (trilha != null) {
            println("\nTrilha: [ID ${trilha.id}] - ${trilha.name}")
            println("--------------------------------------------------")

            if (trilha.course.isEmpty()) {
                println("   Esta trilha ainda não possui cursos vinculados.")
            } else {
                for (curso in trilha.course) {
                    val jaConcluiu = alunoLogado.student?.courses?.contains(curso.id) == true
                    val status = if (jaConcluiu) "Concluído" else "Em andamento"

                    println("   -> Curso: [ID ${curso.id}] ${curso.name} | Level: ${curso.courseLevel.name} | Categoria: ${curso.courseCategory.name} [${status}]")
                }
            }
        }
    }
}