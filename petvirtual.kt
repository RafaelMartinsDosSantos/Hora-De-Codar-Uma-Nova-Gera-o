import kotlin.system.exitProcess

class petlindo (
    // atributos
    var nome: String,
    var fome: Int,
    var felicidade: Int,
    var cansaco: Int,
    var vontadebanheiro: Int,
    var sujeirapet: Int,
    var idadepet: Int,
){
    fun alimentarpet(){
        vontadebanheiro += 20
        fome -= 20
        println("Comendo...")
        println("$nome está mais alimentado!")
    }

    fun brincandopet(){
        sujeirapet = 20
        fome += 20
        cansaco += 10
        felicidade += 30
        println("Brincando.. Pulando..")
        println("$nome está queimando de felicidade!")
    }

    fun descansarpet(){
        felicidade -= 10
        cansaco -= 20
        println("Tirando um cochilo..")
        println("$nome acordou melhor do que nunca.")
    }

    fun iraobanheiro(){
        vontadebanheiro -= vontadebanheiro
        println("Fazendo as necessidades..")
        println("$nome Está Aliviado.")
    }

    fun tomarbanho(){
        sujeirapet -= sujeirapet
        println("$nome Está tomando banho nas chamas. (Torchic odeia água!)")
    }

    fun passarotempo(){
        fome += 3
        felicidade -= 3
        cansaco += 10
        idadepet += 1
        println("Passando o tempo..")
        println("$nome Está mais velho!")
    }




}
var pet = petlindo (nome = "Torchic", fome = 40, felicidade = 40, cansaco = 40, vontadebanheiro = 10, sujeirapet = 20, idadepet = 0)

fun main(){
    println("Bem vindo ao seu app de pet virtual, aqui você pode ter diversas interações e formas divertidas de jogar! Vamos la?")
    inicio()
}

fun inicio(){
    println("""==================================================================================================================
                                            [PET VIRTUAL]
                                            NOME: ${pet.nome}
         Nivel de fome: ${pet.fome}      Nivel de felicidade: ${pet.felicidade}      Nivel de cansaço: ${pet.cansaco}       Idade: ${pet.idadepet}
                        Sujeira: ${pet.sujeirapet}                    Vontade de ir ao banheiro: ${pet.vontadebanheiro}
==================================================================================================================
                   
    """.trimMargin())
    menudeopcoes()
}

fun causasdederrotaouvitoria(){
    if (pet.fome >= 100) {
        println("${pet.nome} MORREU de fome, você perdeu!")
        exitProcess(0)
    }

    if (pet.cansaco >= 100){
        println("${pet.nome} MORREU de cansaço, você perdeu!")
        exitProcess(0)
    }

    if (pet.felicidade <= 0) {
        println("${pet.nome} MORREU de tristeza, você perdeu!")
        exitProcess(0)

    }

    if (pet.sujeirapet >= 100) {
        println("${pet.nome} Ficou IMUNDO, você perdeu!")
        exitProcess(0)
    }

    if (pet.vontadebanheiro >= 100){
        println("${pet.nome} Fez as necessidades NAS PENAS, você perdeu!")
        exitProcess(0)
    }

    if (pet.idadepet == 50){
        println("PARABENS! Você cuidou bem do seu pet e ele atingiu a idade máxima, você venceu!")
        exitProcess(0)
    }
}

fun menudeopcoes(){
    println("""1. Alimentar pet
        |2. Brincar com pet
        |3. Descansar pet
        |4. Ir ao banheiro
        |5. Tomar um banho
        |6. Passar o tempo
        |7. Verificar pet
    """.trimMargin())
     print("Escolha uma opção: ")
     var escolhaopcao = readln()

    causasdederrotaouvitoria()

    when (escolhaopcao){
        "1" -> {
            if (pet.fome <= 0){
                println("${pet.nome} Já está cheio!")
                menudeopcoes()
            }
            else
            pet.alimentarpet()
            menudeopcoes()
        }
        "2" -> {
            if (pet.felicidade >= 100){
                println("${pet.nome} Já está muito feliz!")
                menudeopcoes()
            }
            else
            pet.brincandopet()
            menudeopcoes()
        }
        "3" -> {
            if (pet.cansaco <= 0){
                println("${pet.nome} Já está descansado e cheio de energia!")
                menudeopcoes()
            }
            else
            pet.descansarpet()
            menudeopcoes()
        }
        "4" -> {
            if (pet.vontadebanheiro <= 0){
                println("${pet.nome} Não está com vontade de ir ao banheiro")
            }
            else
                pet.iraobanheiro()
            menudeopcoes()
        }

        "5" -> {
            if (pet.sujeirapet < 0){
                println("${pet.nome} Já esta limpo.")
            }
            else
                pet.tomarbanho()
            menudeopcoes()
        }

        "6" -> {
            pet.passarotempo()
            menudeopcoes()
        }

        "7" -> {
            inicio()
        }

        else -> {
            println("Por favor digite uma opção válida!")
            menudeopcoes()
        }
    }
}
