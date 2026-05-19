package utils

import app.main
import service.register

class EmailFeatures {
    fun emailfeat(email: String){
       val vera = email.contains("@")
        if(vera == false){
            println("Erro: O email é inválido")
            return register()
        }
        val com = email.contains(".com")
        if(vera == false){
            println("Erro: o email é inválido")
            return register()
        }
        return register()
        }
}