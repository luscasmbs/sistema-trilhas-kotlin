package app

import main.kotlin.app.teachermoremenu
import main.kotlin.service.managestudents
import service.createtrail
import service.managecourses

fun Teacherm() {
    while (true) {
        println(
            "=================================\n " +
                    "Sistema de Alunos e Trilhas\n" +
                    "=================================\n\n" +
                    "1 - Gerenciar alunos\n" +
                    "2 - Gerenciar Cursos\n" +
                    "3 - Cadastrar trilha\n" +
                    "4 - Ver mais opções\n" +
                    "0 - Logout\n"
        )
        var op = readLine()?.toIntOrNull()
        when (op) {
            1 -> managestudents()
            2 -> managecourses()
            3 -> createtrail()
            4 -> teachermoremenu()
            0 -> {
                println("Efetuando logout...")
                return
            }
        }
    }
}