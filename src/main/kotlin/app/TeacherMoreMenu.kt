package main.kotlin.app

import app.Teacherm
import service.enrollStudent
import service.exportcsv
import service.manageTrail
import service.viewStudentProgress

fun teachermoremenu(){
    while (true) {
        println("=================================\n " +
                "Sistema de Alunos e Trilhas - Mais Opções\n" +
                "=================================\n\n" +
                "1 - Matricular aluno\n" +
                "2 - Registrar progresso\n" +
                "3 - Relatórios\n" +
                "4 - Associar Curso a uma Trilha\n" +
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
                exportcsv()
            }
            4 -> manageTrail()
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