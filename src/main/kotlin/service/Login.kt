package service

import app.Teacherm
import utils.EmailFeatures
import data.MemoryStorage
import enums.UserType

fun login(){
    var email = ""
    println("=================================\n " +
            "LOGIN\n" +
            "=================================\n\n")
    val emailUtils = EmailFeatures()
    while (true){
        println("Digite seu email:")
        print("> ")
        val inputEmail = readLine() ?: ""

        if (emailUtils.emailfeat(inputEmail)) {
            email = inputEmail
            break
        }
    }
    println("Digite sua senha:")
    print("> ")
    val password = readLine()?: "A senha é inválida"

    val Userfind = MemoryStorage.registerUser.find { it.email == email && it.password == password }
    if (Userfind != null) {
        if (Userfind.role == UserType.PROFESSOR) {
            Teacherm()
        }
    } else {
        println("\n Erro: Email ou senha incorretos! Usuário não encontrado.")
    }




}