package service

import data.User
import data.Student
import data.MemoryStorage
import enums.UserType
import enums.StudentSituation
import utils.EmailFeatures

class RegisterUser {
    fun executeRegister(role: UserType) {
        val label = if (role == UserType.PROFESSOR) "Professor" else "Aluno"
        println("=================================\n " +
                "CADASTRO\n" +
                "=================================\n\n" +
                "Digite seu nome:")
        print("> ")
        val nome = readLine()?: "Insira um nome válido"
        var email = ""
        val emailUtils = EmailFeatures()
        while (true){
            println("Digite seu email:")
            print("> ")
            val inputemail = readLine()?: "Insira um email"
            if (emailUtils.emailfeat(inputemail)){
                email = inputemail
                break
            }
        }
        var senha = ""

        while (true){
            println("Digite sua senha:")
            print("> ")

            val inputSenha = readLine() ?: ""

            if (inputSenha.length >= 4){
                senha = inputSenha
                break
            } else {
                println("A senha deve ter pelo menos 4 caracteres")
            }
        }
        var id = 1
        while (MemoryStorage.registerUser.any() { it.id == id }) {
            id++
        }
        val studentInfo = if (role == UserType.ALUNO) {
            Student(
                trail = mutableListOf(),
                student = StudentSituation.ATIVO,
                courses = mutableListOf()
            )
        } else null

        val user = User(
            id = id,
            name = nome,
            email = email,
            password = senha,
            role = role,
            student = studentInfo
        )

        MemoryStorage.registerUser.add(user)
    }

    }
