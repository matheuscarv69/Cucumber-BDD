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

  Cenário: Deve dar condições especiais para categoria extendida
    Dado um filme com estoque de 2 unidades
    E que o preço de aluguel seja R$ 4
    E que o tipo de aluguel seja extendido
    Quando alugar por 3 dias
    Então o preço do aluguel será R$ 8
    E a data de entrega será em 3 dias
    E a pontuação recebida será de 2 pontos
    
  Cenário: Deve alugar um filme para a categoria comum
    Dado um filme com estoque de 2 unidades
    E que o preço de aluguel seja R$ 4
    E que o tipo de aluguel seja comum
    Quando alugar por 1 dias
    Então o preço do aluguel será R$ 4
    E a data de entrega será em 1 dia
    E a pontuação recebida será de 1 ponto
