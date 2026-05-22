package service

import data.MemoryStorage

fun manageTrail() {
    println("\n--- ASSOCIAR CURSO A UMA TRILHA ---")

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

    print("Insira o ID do Curso que deseja adicionar nesta trilha: ")
    val idCurso = readLine()?.toIntOrNull()

    if (idCurso == null) {
        println("Erro: ID do curso inválido.")
        return
    }

    val curso = MemoryStorage.courses.find { it.id == idCurso }

    if (curso == null) {
        println("Erro: Curso com ID $idCurso não encontrado no catálogo geral.")
        return
    }

    val jaAssociado = trilha.course.any { it.id == curso.id }

    if (jaAssociado) {
        println("Aviso: O curso '${curso.name}' já faz parte da trilha '${trilha.name}'.")
    } else {
        trilha.course.add(curso)
        println("Sucesso: Curso '${curso.name}' associado à trilha '${trilha.name}' com sucesso!")
    }
}