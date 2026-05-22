package app


import data.User
import service.StudentC
import service.studentviewt

fun studentmenu(alunoLogado: User){
     while (true) {
          println("=================================\n " +
                  "Área do Aluno\n" +
                  "=================================\n\n" +
                  "Olá, ${alunoLogado.name}!\n" +
                  "1 - Ver minhas Trilhas e Cursos\n" +
                  "2 - Concluir um Curso\n" +
                  "0 - Logout\n")
          print("> ")

          val op = readLine()?.toIntOrNull()
          when (op) {
               1 -> studentviewt(alunoLogado)
               2 -> StudentC(alunoLogado)
               0 -> {
                    println("Efetuando logout do aluno...")
                    return
               }
               else -> println("Opção inválida.")
          }

          println("\nPressione Enter para continuar...")
          readLine()
     }
     }

