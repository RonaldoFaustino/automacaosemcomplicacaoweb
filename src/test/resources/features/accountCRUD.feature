#language:en
@CRUD
Feature: Account Crud

  @cadastroCrud
  Scenario: Cadastrar Nova Conta
    Given qua a pagina new account esteja sendo exibida
    When os campos de cadastro estiverem preenchidos com dados
      | username | chronosUser1              |
      | email    | chronosuser1@email.com.br |
      | password | Senha123                  |
      | country  | Brazil                    |
    Then deve ser possivel logar no sistema apos o cadastro

  @LoginCRUD
  Scenario: Realizar Login CRUD
    Given que a modal esteja sendo exibida
    When quando os campos de login forem preenchidos com os valores
      | usuario  | chronosUser1 |
      | senha    | Senha123     |
      | remember | true         |
    When  for realizado o clique no botao sign in
    Then deve ser possivel logar no sistema

  @alteracaoCRUD
  Scenario: Realizar alteracao CRUD
    Given que esteja loagado no sitema com dados
      | usuario  | chronosUser1 |
      | senha    | Senha123     |
      | remember | true         |
    And que esteja na pagina de alteracao de conta
    When altero os valores dos seguintes campos
      | firstname | Vivoe    |
      | lastname  | Testando |
    When for realizado o clique em salvar
    Then a alteracao foi exibida na pagina myAccount

  @exclusaoCRUD
  Scenario: Realizar exclusao CRUD
    Given que esteja loagado no sitema com dados
      | usuario  | chronosUser1 |
      | senha    | Senha123     |
      | remember | true         |
    And que esteja na pagina MyAccount
    When for efetuado a acao de deletar
    Then o usuario deve ser deletado