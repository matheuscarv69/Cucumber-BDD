# language: pt

Funcionalidade: Cadastrar Aluguéis
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Cenário: Devo alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preço de aluguel seja R$ 3
    Quando alugar por 1 dia
    Então o preço do aluguel será R$ 3
    E a data de entrega será em 1 dia
    E o estoque do filme será 1 unidade

  Cenário: Não deve alugar um filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar por 1 dia
    Então não será possível por falta de estoque
    E o estoque do filme será 0 unidade

  Esquema do Cenário: Deve dar condições conforme tipo de aluguel
    Dado um filme com estoque de 2 unidades
    E que o preço de aluguel seja R$ <preco>
    E que o tipo de aluguel seja <tipo>
    Quando alugar por <qtdDias> dias
    Então o preço do aluguel será R$ <precoFinal>
    E a data de entrega será em <qtdDias> dias
    E a pontuação recebida será de <pontuacao> pontos

    Exemplos:
      | preco | tipo      | qtdDias | precoFinal | pontuacao |
      | 4     | extendido | 3       | 8          | 2         |
      | 4     | comum     | 1       | 4          | 1         |
      | 10    | extendido | 3       | 20         | 2         |
      | 5     | semanal   | 7       | 15         | 3         |


