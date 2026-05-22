package service

import app.main
import enums.UserType
fun register(){
println("Você quer se cadastrar como professor ou aluno?" +
        "\n1- como professor" +
        "\n2- como aluno" +
        "\n3- voltar")
    var op = readLine()?.toIntOrNull()
    var registerUser = RegisterUser()
    when(op) {
        1 -> registerUser.executeRegister(UserType.PROFESSOR)
        2 -> registerUser.executeRegister(UserType.ALUNO)
        3 -> return
        else -> println("Opção inválida")
    }
}