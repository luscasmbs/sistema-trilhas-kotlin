package utils

import app.main
import service.register

class EmailFeatures {
    fun emailfeat(email: String): Boolean {
        val TemA = email.contains("@")
        val Temcom = email.contains(".com")

        if (TemA == true && Temcom == true) {
            return true
        }
        if (TemA == false && Temcom == false) {
            println("Erro: o email é inválido")
            return false


        }
        return false

    }
}
