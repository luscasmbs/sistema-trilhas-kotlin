package service

import data.MemoryStorage
import enums.UserType

fun enrollStudent() {
    println("\n--- MATRICULAR ALUNO EM TRILHA ---")

    print("Insira o ID do Aluno: ")
    val idAluno = readLine()?.toIntOrNull()

    if (idAluno == null) {
        println("Erro: O ID do aluno deve ser um número válido.")
        return
    }

    val aluno = MemoryStorage.registerUser.find { it.id == idAluno && it.role == UserType.ALUNO }

    if (aluno == null) {
        println("Erro: Aluno com ID $idAluno não foi encontrado.")
        return
    }

    print("Insira o ID da Trilha: ")
    val idTrilha = readLine()?.toIntOrNull()

    if (idTrilha == null) {
        println("Erro: O ID da trilha deve ser um número válido.")
        return
    }

    val trilhaExiste = MemoryStorage.trail.any { it.id == idTrilha }

    if (!trilhaExiste) {
        println("Erro: Trilha com ID $idTrilha não existe no sistema.")
        return
    }

    val jaMatriculado = aluno.student?.trail?.contains(idTrilha) ?: false

    if (jaMatriculado) {
        println("Erro: O aluno '${aluno.name}' já está matriculado nesta trilha.")
    } else {
        aluno.student?.trail?.add(idTrilha)
        println("Sucesso: Aluno '${aluno.name}' matriculado na trilha ID $idTrilha!")
    }
}