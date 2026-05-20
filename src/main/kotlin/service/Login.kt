package service

import utils.EmailFeatures
import data.MemoryStorage

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

    val professorEncontrado = MemoryStorage.registeredTeachers.find { it.email == email && it.password == password }
    if (professorEncontrado != null) {
        println("\nLogado com sucesso! Seja bem-vindo, ${professorEncontrado.name} :)")
    } else {
        println("\n Erro: Email ou senha incorretos! Usuário não encontrado.")
    }




}