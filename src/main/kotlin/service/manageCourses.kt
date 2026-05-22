package service

import data.Course
import data.MemoryStorage
import enums.CourseCategory
import enums.CourseLevel

fun managecourses(){
    while (true) { // 💡 Mantém o menu aberto até digitar 0
        println("=================================\n " +
                "Gerenciar cursos\n" +
                "=================================\n\n" +
                "1 - Cadastrar novo curso\n" +
                "2 - Listar todos os cursos\n" +
                "3 - Remover curso\n" +
                "0 - Voltar\n")
        print("> ")

        var op = readLine()?.toIntOrNull()
        when(op){
            1 -> {
                var nome = ""
                while (true) {
                    println("Qual o nome do curso")
                    print("> ")
                    nome = readLine()?: ""
                    val courseseq = MemoryStorage.courses.find { it.name == nome}
                    if (courseseq != null){
                        println("O nome do curso já existe")
                        continue
                    } else {
                        break
                    }
                }

                var time = 0
                while (true){
                    println("Qual a carga horária do curso?")
                    print("> ")
                    val inputTime = readLine()?.toIntOrNull()
                    if (inputTime == null) {
                        println("Erro: Formato de carga horária inválido, insira apenas o horário")
                        continue
                    } else {
                        time = inputTime
                        break
                    }
                }

                var level = 0
                while (true){
                    println("Qual o level do curso?\n" +
                            "1- Básico \n" +
                            "2- Intermediário \n" +
                            "3- Avançado")
                    print("> ")
                    val inputLevel = readLine()?.toIntOrNull()
                    if (inputLevel == null || inputLevel < 1 || inputLevel > 3) {
                        println("Erro: selecione um número equivalente a uma das opções")
                        continue
                    } else {
                        level = inputLevel
                        break
                    }
                }

                var category = 0
                while (true) {
                    println("Qual a categoria do curso?\n" +
                            "1- KOTLIN \n" +
                            "2- ANDROID \n" +
                            "3- ARQUITETURA \n" +
                            "4- TESTES \n" +
                            "5- DESIGN")
                    print("> ")
                    val inputCategory = readLine()?.toIntOrNull()
                    if (inputCategory == null || inputCategory < 1 || inputCategory > 5) {
                        println("Erro: selecione um número equivalente a uma das opções")
                        continue
                    } else {
                        category = inputCategory
                        break
                    }
                }

                val novoId = (MemoryStorage.courses.maxOfOrNull { it.id } ?: 0) + 1

                val levelEnum = when(level) {
                    1 -> CourseLevel.BASICO
                    2 -> CourseLevel.INTERMEDIARIO
                    else -> CourseLevel.AVANCADO
                }

                val categoryEnum = when(category) {
                    1 -> CourseCategory.KOTLIN
                    2 -> CourseCategory.ANDROID
                    3 -> CourseCategory.ARQUITETURA
                    4 -> CourseCategory.TESTES
                    else -> CourseCategory.DESIGN
                }

                val novoCurso = Course(
                    id = novoId,
                    name = nome,
                    workload = time,
                    courseLevel = levelEnum,
                    courseCategory = categoryEnum
                )

                MemoryStorage.courses.add(novoCurso)
                println("Curso '$nome' cadastrado com sucesso! ID gerado: $novoId")
            }

            2 -> {
                val listaCursos = MemoryStorage.courses

                if (listaCursos.isEmpty()) {
                    println("Nenhum curso cadastrado no sistema até o momento.")
                } else {
                    println(String.format("%-5s | %-25s | %-12s | %-12s | %-10s", "ID", "NOME", "CARGA HORÁRIA", "LEVEL", "CATEGORIA"))
                    println("---------------------------------------------------------------------------------")
                    for (curso in listaCursos) {
                        println(String.format("%-5d | %-25s | %-12d | %-12s | %-10s",
                            curso.id,
                            curso.name,
                            curso.workload,
                            curso.courseLevel.name,
                            curso.courseCategory.name
                        ))
                    }
                }
            }

            3 -> {
                println("Insira o ID do curso que deseja remover:")
                print("> ")
                val idRemover = readLine()?.toIntOrNull()

                val cursoEncontrado = MemoryStorage.courses.find { it.id == idRemover }

                if (cursoEncontrado != null) {
                    val vinculadoEmTrilha = MemoryStorage.trail.any { it.course.contains(cursoEncontrado) }
                    if (!vinculadoEmTrilha) {
                        MemoryStorage.courses.remove(cursoEncontrado)
                        println("Curso '${cursoEncontrado.name}' removido com sucesso!")
                    } else {
                        println("Erro: Não é possível remover este curso pois ele está associado a uma Trilha ativa.")
                    }
                } else {
                    println("Erro: Curso com ID $idRemover não encontrado.")
                }
            }

            0 -> {
                println("Retornando ao menu do professor...")
                return
            }

            else -> println("Opção inválida.")
        }

        println("\nPressione Enter para continuar...")
        readLine()
    }
}