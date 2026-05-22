package app

import main.kotlin.app.teachermoremenu
import main.kotlin.service.managestudents

fun studentmenu(){
     println("=================================\n " +
             "Sistema de Alunos e Trilhas\n" +
             "=================================\n\n" +
             "1 - Ver minhas trilhas\n" +
             "2 - Ver meus cursos\n" +
             "3 - Ver meu progresso\n" +
             "4 - Ver minhas notas\n" +
             "0 - Logout\n")
     var op = readLine()?.toIntOrNull()
     when(op){
          1 -> managestudents()
          4 -> teachermoremenu()
     }
}
