package service

import data.MemoryStorage
import data.Trail
import enums.TrailStatus

fun createtrail() {
    println("\n--- CADASTRAR NOVA TRILHA ---")

    print("Digite o nome da Trilha: ")
    val nome = readLine() ?: ""

    if (nome.isNotBlank()) {
        val trilhaDuplicada = MemoryStorage.trail.any { it.name.equals(nome, ignoreCase = true) }

        if (!trilhaDuplicada) {
            val novoId = (MemoryStorage.trail.maxOfOrNull { it.id } ?: 0) + 1

            val novaTrilha = Trail(
                id = novoId,
                name = nome,
                course = mutableListOf(),
                status = TrailStatus.ATIVA
            )
            MemoryStorage.trail.add(novaTrilha)
            println("Sucesso: Trilha '$nome' cadastrada com o ID $novoId!")
        } else {
            println("Erro: Já existe uma trilha cadastrada com o nome '$nome'.")
        }
    } else {
        println("Erro: O nome da trilha não pode estar em branco.")
    }
}