package main.kotlin.app

import app.Teacherm

fun teachermoremenu(){
    println("=================================\n " +
            "Sistema de Alunos e Trilhas\n" +
            "=================================\n\n" +
            "1 - Matricular aluno\n" +
            "2 - Registrar progresso\n" +
            "3 - Relatórios\n" +
            "0 - Voltar\n")
    var op = readLine()?.toIntOrNull()
    when(op){
        0 -> Teacherm()
    }
}