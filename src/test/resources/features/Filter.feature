Feature: Aplicar Filtro

  @Filter @Test
  Scenario: Aplicar filtro por sistema operacional em laptops
    Given que eu esteja na página de laptops
    When eu filtro por sistema operacional
    Then eu valido que o filtro foi aplicado