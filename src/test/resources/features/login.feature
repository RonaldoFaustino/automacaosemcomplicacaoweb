#language:en
  @teste
  Feature: Login

    Background: Abrir modal
      Given que a modal esteja sendo exibida

    @fecharModal
    Scenario: Fechar a modal ao clicar fora da mesma
      When for realizado um clicque fora da modal
      Then a janela modal deve ser fechada

    @fecharModalIcone
    Scenario: Fechar a modal ao clicar mo icone fechar
      When for realizado um clique icone de fechar modal
      Then a janela modal deve ser fechada

    @validarPaginaCreateAccount
    Scenario: Link Create New Account
      When que a modal estaja sendo exibida
      Then a pagina Create Account deve ser exibida


#    Scenario Outline: Realizar Login <identificacao >
#      When quando os campos de login forem preenchidos com os valores
#        | usuario  | <usuario>  |
#        | senha    | <senha>    |
#        | remember | <remember> |
#      When  for realizado o clique no botao sign in
#      Then deve ser possivel logar no sistema
#      Examples:
#        | identificacao               | usuario  | senha    | remember |
#        | com campos obrigatorios     | chronos  | senha    | false    |
#        | todos os campos obrigatorio | chronos  | senha    | true     |
#        | com senha invalido          | chronos  | invalido | true     |
#        | com usuario invalido        | invalido | senha    | true     |
#        | com usuario em branco       | chronos  | senha    | true     |
#        | com senha em branco         | chronos  | senha    | true     |
#
#
#    Scenario: Realizar Login obrigatorio
#      When quando os campos de login forem preenchidos com os valores
#        | usuario  | chronos |
#        | senha    | senha   |
#        | remember | true    |
#      When  for realizado o clique no botao sign in
#      Then deve ser possivel logar no sistema
#
#
#   Scenario Outline: Realizar login com dados <identificacao>
#      When quando os campos de login forem preenchidos com os valores
#        | usuario  | <usuario>  |
#        | senha    | <senha>    |
#        | remember | <remember> |
#     When  for realizado o clique no botao sign in
#      Then o sistema exibe uma mensagem de erro
#     Examples:
#       | identificacao    | usuario  | senha    | remember |
#       | senha invalido   | chronos  | invalido | false    |
#       | usuario invalido | invalido | senha    | false    |

    @dadosEmBranco
    Scenario Outline: Realizar login com <identificacao>
      When quando os campos de login forem preenchidos com os valores
        | usuario  | <usuario>        |
        | senha    | <senha>    |
        | remember | <remember> |
      When  for realizado o clique no botao sign in
      Then o botao sign in deve permanecer desabilitado
      Examples:
        | identificacao   | usuario | senha | remember |
        | login em branco |         | senha | false    |
        | senha em branco | chronos |       | false    |
