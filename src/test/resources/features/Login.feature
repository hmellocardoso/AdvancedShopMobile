Feature: Login no sistema

  @Login @Test
  Scenario: Realizar login com sucesso
    Given que eu esteja na página de login
    When eu insiro o usuário e senha corretos
    Then eu valido que usuário está logado