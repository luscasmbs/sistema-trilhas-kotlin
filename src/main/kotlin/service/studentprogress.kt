package service

import data.MemoryStorage
import enums.UserType

fun viewStudentProgress() {
    println("\n--- VER PROGRESSO DO ALUNO ---")

    print("Insira o ID do Aluno: ")
    val idAluno = readLine()?.toIntOrNull()

    if (idAluno == null) {
        println("Erro: ID do aluno inválido.")
        return
    }

    val aluno = MemoryStorage.registerUser.find { it.id == idAluno && it.role == UserType.ALUNO }

    if (aluno == null) {
        println("Erro: Aluno com ID $idAluno não encontrado.")
        return
    }

    print("Insira o ID da Trilha: ")
    val idTrilha = readLine()?.toIntOrNull()

    if (idTrilha == null) {
        println("Erro: ID da trilha inválido.")
        return
    }

    val trilha = MemoryStorage.trail.find { it.id == idTrilha }

    if (trilha == null) {
        println("Erro: Trilha com ID $idTrilha não encontrada.")
        return
    }

    if (trilha.course.isEmpty()) {
        println("Trilha: ${trilha.name}")
        println("Progresso: 0.00% (Aviso: Esta trilha ainda não possui cursos associados).")
        return
    }

    var cursosConcluidos = 0

    for (idCurso in trilha.course) {
        if (aluno.student?.courses?.contains(idCurso.id) == true) {
            cursosConcluidos++
        }
    }

    val percentual: Double = (cursosConcluidos.toDouble() / trilha.course.size.toDouble()) * 100.0

    println("Trilha: ${trilha.name}")
    println(String.format("Progresso do Aluno '%s': %.2f%% (%d de %d cursos concluídos)",
        aluno.name, percentual, cursosConcluidos, trilha.course.size))
}