Para utilizar o .jar coloque o arquivo "Start.bat" no mesmo diretório do "unbhub.jar" e edite o bat colocando seu path do javafx nele e então crie um diretório chamado "data" e dentro dele 2 diretórios: "usuarios" e "imagens"

|_Start.bat\
|_unbhub.jar\
|_data\
  |_usuarios\
  |_imagens\


Estou estudando a possibilidade de utilarmos java with maven para deixar a distribuição do projeto completamente portatil.


> ### Frontend
- [X] Tela de Cadastro
- [X] Tela de Login
- [ ] Tela de Entrada // Daniel
- [X] Tela de CompletarCadastro
- [ ] Tela de Cliente
- [ ] Tela de Dono
- [ ] Tela da Loja
- [ ] Tela de Criar/Editar Lojas
- [ ] Tela de Editar Perfil
- [ ] FontAwesomeFX
- [ ] ControlsFX

> ### Backend
- [X] Criação de usuário
- [X] Verificação de usuário
- [ ] Formatação dos campos de entrada
- [ ] Criação de perfil de dono
- [ ] Editar perfil
- [ ] Banco de dados
- [ ] Criação de lojas
- [ ] Criação de avaliações
- [ ] Mecanismo de busca


# UnBHUB
&emsp;Programa desenvolvido por estudantes da Universidade de Brasília para a
disciplina Técnicas de Programação 1 como trabalho final, ministrada pela Professora
Roberta Barbosa. Desenvolvida em Java, utilizando a plataforma JavaFX.

## Problema
&emsp;Dentro do ambiente universitário, percebe-se a presença de lanchonetes e
estabelecimentos de forma dispersa pelo campus, tais comércios que são
essenciais durante a rotina diária estudantil, seja para se alimentar ou comprar
utensílios. Essa disposição, a falta de conhecimento dos alunos e o grande volume
de aulas dificulta a relação dos estudantes com o comércio local. Por esse fato, os
vendedores acabam tendo menor visibilidade, menor alcance de clientes e,
consequentemente, maior dificuldade para crescer seus negócios.

## Proposta
&emsp;A partir do problema descrito, surge a necessidade de algo para estreitar
essa relação cliente-loja, por isso propõe-se o “UnB HUB”, como o nome indica, é
um HUB, uma central que agrega vários produtos, serviços e lojas ao mesmo
tempo. Será implementado uma plataforma de busca para facilitar quando o
estudante precisar de qualquer produto ou serviço. Dentro da plataforma será
possível criar uma conta, criar lojas e produtos, haverá uma tela inicial que mostrará
as lojas principais e um sistema de avaliações. Esse HUB trará muita visibilidade
aos vendedores e praticidade para o cliente que deseja saber onde encontrar
produtos e serviços dentro da universidade, além de saber qual loja oferece pelo
menor preço ou melhor qualidade.


## Regras de Negócio
&emsp;Nosso projeto se aplicará somente à Universidade de Brasília, pelo fato dos
integrantes cursarem nela e o problema apresentado ser evidente no ambiente. As
lojas mais bem avaliadas serão destacadas na página principal, como uma forma de
incentivar os estabelecimentos a ter uma melhor qualidade de serviços e produtos.
Haverá um campo de cadastro, onde o usuário pode ser tanto loja como cliente.
Não terá um sistema de compras, a plataforma é somente para buscas e
avaliações

## Diagrama de Relacionamentos

![DiaHUB](https://user-images.githubusercontent.com/64702639/211954050-13451c5f-1425-41f7-a4cb-e128ec10db30.png)

