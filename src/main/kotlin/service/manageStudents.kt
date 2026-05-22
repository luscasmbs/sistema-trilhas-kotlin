package main.kotlin.service

import app.Teacherm
import data.MemoryStorage
import data.Student
import data.User
import enums.StudentSituation
import enums.UserType
import utils.EmailFeatures


fun managestudents(){
    println("=================================\n " +
            "Gerenciar alunos\n" +
            "=================================\n\n" +
            "1 - Alterar situação do aluno\n" +
            "2 - Vincular aluno a uma trilha\n" +
            "3 - Cadastrar aluno\n" +
            "4- Ver todos os alunos\n" +
            "0 - Voltar\n")
    var op = readLine()?.toIntOrNull()
    when(op){
        1 -> {
            println("Insira o id do aluno:")
            print("> ")
            val id = readLine()?.toIntOrNull()

            val studentfind = MemoryStorage.registerUser.find { it.id == id && it.role == enums.UserType.ALUNO }

            if (studentfind != null) {
                println("Aluno encontrado: ${studentfind.name}")
                println("Situação atual: ${studentfind.student?.student}")

                println("Escolha a nova situação:\n1 - ATIVO\n2 - BLOQUEADO")
                print("> ")
                val situationOp = readLine()

                if (situationOp == "1") {
                    studentfind.student?.student = StudentSituation.ATIVO
                    println("Situação do aluno atualizada para ATIVO com sucesso!")
                } else if (situationOp == "2") {
                    studentfind.student?.student = StudentSituation.BLOQUEADO
                    println("Situação do aluno atualizada para BLOQUEADO com sucesso!")
                } else {
                    println("Opção inválida.")
                }
            } else {
                println("Aluno com ID $id não encontrado.")
            }
        }
        2 -> {
            println("Insira o ID do Aluno:")
            print("> ")
            val idAluno = readLine()?.toIntOrNull()

            val aluno = MemoryStorage.registerUser.find { it.id == idAluno && it.role == UserType.ALUNO }

            if (aluno != null) {
                println("Aluno selecionado: ${aluno.name}")
                println("Insira o ID da Trilha desejada:")
                print("> ")
                val idTrilha = readLine()?.toIntOrNull()

                val trilhaExiste = MemoryStorage.trail.any { it.id == idTrilha }

                if (idTrilha != null && trilhaExiste) {
                    val jaVinculado = aluno.student?.trail?.contains(idTrilha) ?: false

                    if (!jaVinculado) {
                        aluno.student?.trail?.add(idTrilha)
                        println("Aluno '${aluno.name}' vinculado à trilha ID $idTrilha com sucesso!")
                    } else {
                        println("Erro: Este aluno já está vinculado a esta trilha!")
                    }
                } else {
                    println("Erro: Trilha com ID $idTrilha não encontrada no sistema.")
                }
            } else {
                println("Erro: Aluno com ID $idAluno não encontrado.")
            }
        }
        3 -> {
            println("Digite o Nome do Aluno:")
            print("> ")
            val nome = readLine() ?: ""
            var email = ""
            val emailUtils = EmailFeatures()
            while (true){
                println("Digite o E-mail do Aluno:")
                print("> ")
                val inputemail = readLine() ?: ""
                if (emailUtils.emailfeat(inputemail)){
                    email = inputemail
                    break
                }
            }


            println("Digite a Senha do Aluno:")
            print("> ")
            val senha = readLine() ?: ""

            val emailDuplicado = MemoryStorage.registerUser.any { it.email.equals(email, ignoreCase = true) }

            if (nome.isNotBlank() && email.isNotBlank() && senha.isNotBlank()) {
                if (!emailDuplicado) {
                    val novoId = (MemoryStorage.registerUser.maxOfOrNull { it.id } ?: 0) + 1

                    val dadosEstudante = Student(
                        student = StudentSituation.ATIVO,
                        trail = mutableListOf(),
                        courses = mutableListOf()
                    )

                    val novoUsuario = User(
                        id = novoId,
                        name = nome,
                        email = email,
                        password = senha,
                        role = UserType.ALUNO,
                        student = dadosEstudante
                    )

                    MemoryStorage.registerUser.add(novoUsuario)
                    println("Aluno '$nome' cadastrado com sucesso! ID gerado: $novoId")
                    return

                } else {
                    println("Erro: O e-mail '$email' já está cadastrado no sistema!")
                }
            } else {
                println("Erro: Todos os campos são obrigatórios!")
            }
        }
        4 -> {

            val listaAlunos = MemoryStorage.registerUser.filter { it.role == UserType.ALUNO }

            if (listaAlunos.isEmpty()) {
                println("Nenhum aluno cadastrado no sistema até o momento.")
            } else {
                println(String.format("%-5s | %-20s | %-25s | %-12s | %-10s", "ID", "NOME", "E-MAIL", "SITUAÇÃO", "TRILHAS"))
                println("---------------------------------------------------------------------------------")

                for (aluno in listaAlunos) {
                    val trilhasDoAluno = aluno.student?.trail?.joinToString(", ") ?: "Nenhuma"

                    println(String.format("%-5d | %-20s | %-25s | %-12s | Trilha(s): [%s]",
                        aluno.id,
                        aluno.name,
                        aluno.email,
                        aluno.student?.student?.name ?: "N/A",
                        trilhasDoAluno
                    ))
                }
            }
        }

        0 -> return

    }
    return

}
