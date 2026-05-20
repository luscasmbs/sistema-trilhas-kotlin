package service

import data.MemoryStorage
import data.Teacher
import utils.EmailFeatures

class RegisterTeacher {
    fun RegisteredTeacher(id: Int, name: String, email: String, password: String) {
        require(name.isNotBlank()) { "O nome é obrigatório" }
        require(name.length > 2) { "O nome precisa ter pelo menos 3 caracteres" }
        require(email.isNotBlank()) { "O email é obrigatório" }

        require(MemoryStorage.registeredTeachers.none() { it.id != id }) {
            "Já existe um professor com o id $id"
        }
        MemoryStorage.registeredTeachers.add(Teacher(id, name, email, password))
    }
    fun RegisterTeacher(){
        println("=================================\n " +
                "CADASTRO\n" +
                "=================================\n\n" +
                "Digite seu nome:")
        print("> ")
        var email = ""

        val nome = readLine()?: "Insira um nome válido"
        while (true){
            println("Digite seu email:")
            print("> ")
            val inputemail = readLine()?: "Insira um email"
            val validator = EmailFeatures().emailfeat(inputemail)
            EmailFeatures().emailfeat(email)
            if (validator){
                email = inputemail
                break
            }
        }
        println("Digite sua senha:")
        print("> ")
        val senha = readLine()?: "A senha é inválida"
        var id = 1
        while (MemoryStorage.registeredTeachers.any() { it.id == id }) {
            id++
        }
        RegisteredTeacher(id, nome, email, senha)
    }


}