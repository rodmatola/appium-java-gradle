# language: pt

Funcionalidade: Login
  Para ...
  Eu como usuário
  Preciso realizar o login no aplicativo
  
  Contexto:
  	Dado que estou na tela de login do aplicativo

  @loginComSucessoComAgendamento @android @ios
  Cenário: Login com sucesso
    Quando realizo o login
    Então devo visualizar a tela Home
    
  @loginSemInternet @android @ios @instrumentado
  Cenário: Falha no login por estar desconectado
    Quando realizo o login "sem conexão"
    Então devo visualizar uma mensagem de "sem internet"
  
  @loginSemDados @ios @instrumentado
  Cenário: Falha no login por não preenchimento dos campos
    Quando realizo o login "sem preenchimento"
    Então devo visualizar uma mensagem de "erro cpf"
    
  @loginCpfInvalido @ios @instrumentado
  Cenário: Falha no login por CPF inválido
    Quando realizo o login "com cpf inválido"
    Então devo visualizar uma mensagem de "erro cpf"
    
  @loginCpfNaoCadastrado @ios @instrumentado
  Cenário: Falha no login por CPF não cadastrado
    Quando realizo o login "com cpf não cadastrado"
    Então devo visualizar uma mensagem de "erro cpf"
    
	@loginSenhaInvalida @ios @instrumentado
  Cenário: Falha no login por senha inválida
    Quando realizo o login "com senha inválida"
    Então devo visualizar uma mensagem de "erro senha"
 