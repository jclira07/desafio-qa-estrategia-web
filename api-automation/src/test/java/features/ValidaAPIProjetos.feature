#language: pt

@ValidaAPI
Funcionalidade: Valida API

  @ValidarAutenticacao
  Cenário: Validar criação e login pela API
    Dado que crio o usuário
    Então faço o login

  @ValidarCRUD
  Cenário: Validar CRUD pela API
    Dado que consulto todos os projetos
    Então faço um CRUD de um projeto
