// Enum para representar os níveis de formação
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe que representa um usuário
data class Usuario(val nome: String, val email: String) {
    var nivel: Nivel = Nivel.BASICO
}

// Classe que representa um conteúdo educacional
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

// Classe que representa uma formação
class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    // Lista de usuários matriculados na formação
    private val inscritos = mutableListOf<Usuario>()

    // Função para matricular um usuário na formação
    fun matricular(usuario: Usuario, nivel: Nivel) {
        // Verificar se o usuário já está matriculado
        if (!inscritos.contains(usuario)) {
            usuario.nivel = nivel
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado nesta formação.")
        }
    }

    // Função para gerar um relatório de matrículas
    fun gerarRelatorioMatriculas(): String {
        val relatorio = StringBuilder()
        relatorio.appendln("Relatório de Matrículas para $nome:")
        inscritos.forEachIndexed { index, usuario ->
            relatorio.appendln("${index + 1}. ${usuario.nome} - Nível: ${usuario.nivel}")
        }
        return relatorio.toString()
    }
}

fun main() {
    // Criar alguns conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 60)
    val kotlinAvancado = ConteudoEducacional("Recursos Avançados em Kotlin", 90)

    // Criar uma formação em Kotlin
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinAvancado))

    // Criar alguns usuários
    val aluno1 = Usuario("João", "joao@email.com")
    val aluno2 = Usuario("Maria", "maria@email.com")

    // Matricular usuários na formação
    formacaoKotlin.matricular(aluno1, Nivel.INTERMEDIARIO)
    formacaoKotlin.matricular(aluno2, Nivel.DIFICIL)

    // Gerar e imprimir relatório de matrículas
    println(formacaoKotlin.gerarRelatorioMatriculas())
}