package service

import data.MemoryStorage
import enums.UserType
import java.io.File

fun exportcsv() {
    println("\n--- GERANDO RELATÓRIO EXCEL (CSV) ---")

    val alunos = MemoryStorage.registerUser.filter { it.role == UserType.ALUNO }

    if (alunos.isEmpty()) {
        println("Aviso: Não existem alunos cadastrados para gerar o relatório.")
        return
    }

    val nomeArquivo = "relatorio_excel_worldskills.csv"
    val arquivo = File(nomeArquivo)

    arquivo.printWriter().use { out ->
        out.println("ID_ALUNO;NOME;EMAIL;SITUACAO;QTD_TRILHAS_MATRICULADAS")

        for (aluno in alunos) {
            val qtdTrilhas = aluno.student?.trail?.size ?: 0
            val situacao = aluno.student?.student?.name ?: "N/A"

            out.println("${aluno.id};${aluno.name};${aluno.email};$situacao;$qtdTrilhas")
        }
    }

    println("Sucesso! Arquivo '$nomeArquivo' gerado com sucesso na raiz do projeto.")
}