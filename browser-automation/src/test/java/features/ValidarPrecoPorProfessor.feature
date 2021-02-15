#language: pt

@ValidarPrecos
Funcionalidade: Validar preços

  @ValidarPrecosPorProfessor
  Esquema do Cenário: Validar preços por professor
    Dado que nego o popup de notificações
    E que abro o menu Por Professor
    E que eu filtro por "<professor>"
    Então valido os preços dos cursos

    Exemplos:
      | professor  |
      | Ena Loiola |