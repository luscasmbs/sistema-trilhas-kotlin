package service

import data.MemoryStorage
import data.User

fun StudentC(alunoLogado: User) {
    println("\n--- CONCLUIR UM CURSO ---")

    print("Insira o ID do Curso que você terminou: ")
    val idCurso = readLine()?.toIntOrNull()

    if (idCurso == null) {
        println("Erro: ID do curso inválido.")
        return
    }

    val cursoExiste = MemoryStorage.courses.find { it.id == idCurso }

    if (cursoExiste == null) {
        println("Erro: Curso com ID $idCurso não existe no catálogo.")
        return
    }

    val jaConcluido = alunoLogado.student?.courses?.contains(idCurso) == true

    if (jaConcluido) {
        println("⚠️ Aviso: Você já marcou o curso '${cursoExiste.name}' como concluído anteriormente.")
    } else {
        alunoLogado.student?.courses?.add(idCurso)
        println("Parabéns! Curso '${cursoExiste.name}' registrado como concluído com sucesso!")
    }
}