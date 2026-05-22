package app

import main.kotlin.app.teachermoremenu
import main.kotlin.service.managestudents

fun Teacherm() {
    println("=================================\n " +
            "Sistema de Alunos e Trilhas\n" +
            "=================================\n\n" +
            "1 - Gerenciar alunos\n" +
            "2 - Gerenciar Cursos\n" +
            "3 - Cadastrar trilha\n" +
            "4 - Ver mais opções\n" +
            "0 - Logout\n")
    var op = readLine()?.toIntOrNull()
    when(op){
        1 -> managestudents()
        4 -> teachermoremenu()
    }

}