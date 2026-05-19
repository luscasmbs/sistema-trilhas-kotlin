package service

import data.Teacher
import utils.EmailFeatures

class RegisterTeacher {
    fun RegisteredTeacher(id: Int, name: String, email: String, password: String) {
        require(name.isNotBlank()) { "O nome é obrigatório" }
        require(name.length > 2) { "O nome precisa ter pelo menos 3 caracteres" }
        require(email.isNotBlank()) { "O email é obrigatório" }
        require(Teacher.registeredTeachers.none { it.id == id }) {
            "Já existe um professor com o id $id"
        }
        Teacher.registeredTeachers.add(Teacher(id, name, email, password))
    }
    fun RegisterTeacher(){
        println("=================================\n " +
                "LOGIN\n" +
                "=================================\n\n" +
                "Digite seu nome:")
        print("> ")
        val nome = readLine()?: "Insira um nome válido"

        println("Digite seu email:")
        print("> ")
        val email = readLine()?: "Insira um email"
        EmailFeatures().emailfeat(email)
        println("Digite sua senha:")
        print("> ")
        val senha = readLine()?: "A senha é inválida"
        var id = 1
        while (Teacher.registeredTeachers.none { it.id == id }) {
            id++
        }
        RegisteredTeacher(id, nome, email, senha)
    }


}