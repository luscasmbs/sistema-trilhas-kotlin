package main.kotlin.app

import app.Teacherm
import service.enrollStudent
import service.viewStudentProgress

fun teachermoremenu(){
    while (true) { // 💡 ADICIONADO: Mantém o usuário aqui dentro até digitar 0
        println("=================================\n " +
                "Sistema de Alunos e Trilhas - Mais Opções\n" +
                "=================================\n\n" +
                "1 - Matricular aluno\n" +
                "2 - Registrar progresso\n" +
                "3 - Relatórios\n" +
                "0 - Voltar\n")
        print("> ")

        var op = readLine()?.toIntOrNull()
        when(op){
            1 -> {

                enrollStudent()
            }
            2 -> {
                viewStudentProgress()
            }
            3 -> {
                println("Exibindo relatórios...")
            }
            0 -> {
                println("Voltando ao menu principal...")
                return
            }
            else -> println("Opção inválida.")
        }

        println("\nPressione Enter para continuar...")
        readLine()
    }
}