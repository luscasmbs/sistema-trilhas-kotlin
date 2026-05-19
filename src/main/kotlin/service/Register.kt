package service

fun register(){
println("Você quer se cadastrar como professor ou aluno?" +
        "\n1- como professor" +
        "\n2- como aluno" +
        "\n3- voltar")
    var op = readLine()?.toIntOrNull()
    when(op) {
        1 -> RegisterTeacher().RegisterTeacher()

    }
}