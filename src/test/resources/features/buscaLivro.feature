#language:pt
@regressaoApi
Funcionalidade: Busca Livro
  Realizar Testes no Busca Livro

  Contexto:
    Dado que tenho um payload valido do Busca Livro

  @BuscaLivro
  Esquema do Cenario: Cenario: Valido status code do consultar Busca Livro <cenario>
    Quando realizo uma requisicao get no Busca livro com nome do livro "<nomelivro>"
    Entao valido a requisicao com sucesso <status>
    Exemplos:
    | cenario | nomelivro         | status |
    | Livro 1 | Fortaleza Digital | 200    |
    | Livro 2 | pipas             | 200    |




