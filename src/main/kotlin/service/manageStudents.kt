package main.kotlin.service

import app.Teacherm
import data.MemoryStorage
import data.Student
import data.User
import enums.StudentSituation


fun managestudents(){
    println("=================================\n " +
            "Gerenciar alunos\n" +
            "=================================\n\n" +
            "1 - Alterar situação do aluno\n" +
            "2 - Vincular aluno a uma trilha\n" +
            "3 - Cadastrar aluno\n" +
            "0 - Voltar\n")
    var op = readLine()?.toIntOrNull()
    when(op){
        1 -> {
            println("Insira o id do aluno:")
            print("> ")
            val id = readLine()?.toIntOrNull()

            val studentfind = MemoryStorage.registerUser.find { it.id == id && it.role == enums.UserType.ALUNO }

            if (studentfind != null) {
                println("Aluno encontrado: ${studentfind.name}")
                println("Situação atual: ${studentfind.student?.student}")

                println("Escolha a nova situação:\n1 - ATIVO\n2 - BLOQUEADO")
                print("> ")
                val situationOp = readLine()

                if (situationOp == "1") {
                    studentfind.student?.student = StudentSituation.ATIVO
                    println("Situação do aluno atualizada para ATIVO com sucesso!")
                } else if (situationOp == "2") {
                    studentfind.student?.student = StudentSituation.BLOQUEADO
                    println("Situação do aluno atualizada para BLOQUEADO com sucesso!")
                } else {
                    println("Opção inválida.")
                }
            } else {
                println("Aluno com ID $id não encontrado.")
            }
        }
        0 -> return

    }
}