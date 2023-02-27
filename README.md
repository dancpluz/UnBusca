![DarkUnBusca](https://user-images.githubusercontent.com/64702639/221646701-66a33e4f-07b9-4e4f-b1c0-b686697b5080.png)

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
&emsp;A partir do problema descrito, surge a necessidade de algo para estreitar essa relação cliente-loja, por isso propõe-se o “UnBusca”, como o nome indica, é um programa de busca de produtos e lojas dentro da Universidade de Brasília. Será implementado uma plataforma de busca para facilitar quando o estudante precisar de qualquer produto ou serviço. Dentro da plataforma será possível criar uma conta, criar lojas e produtos, haverá uma tela de cliente que mostrará as lojas principais e um sistema de avaliações. Essa aplicação trará muita visibilidade aos vendedores e praticidade para o cliente que deseja saber onde encontrar produtos e serviços dentro da universidade, além de saber qual loja oferece pelo menor preço ou melhor qualidade.


## Regras de Negócio
- Nosso projeto se aplicará somente à Universidade de Brasília, pelo fato dos integrantes cursarem nela e o problema apresentado ser evidente no ambiente.
- As lojas mais bem avaliadas serão destacadas na página principal, como uma forma de incentivar os estabelecimentos a ter uma melhor qualidade de serviços e produtos.
- Será possível se cadastrar e entrar em uma conta.
- O usuário ao se cadastrar, pode tanto continuar somente com a conta de cliente ou completar seu cadastro e se tornar uma conta de dono também.
- Para poder criar lojas, é necessário ser maior de 18 anos e fornecer seu número de telefone.
- Não haverá um sistema de compras, a plataforma é somente para buscas e avaliações.
- Toda avaliação terá uma nota, que foram inspiradas no formato de avaliação da UnB, cada loja terá uma nota média, indicadas pelas letras:
  - SS = 4 ≤ nota média ≤ 5.
  - MS = 3 ≤ nota média < 4.
  - MM = 2 ≤ nota média < 3.
  - MI = 1 ≤ nota média < 2
  - II = 0 < nota média < 1.
  - SR, significa que uma loja não possui avaliações.
  
## Diagrama de Relacionamentos

![diaHUB](https://user-images.githubusercontent.com/64702639/221646146-ee6472d4-9b56-4df6-b36c-48f300a5eb73.png)

## Explicação das Classes
### Usuário
&emsp;Essa é a classe base para qualquer perfil criado dentro do aplicativo, ela servirá como superclasse para
o dono, dentro dela está o nome, a senha, o username, o cpf, as avaliações que ele fez e o id do respectivo
usuário, tal id que será utilizado para guardar as informações em arquivos .ser. Ela possui métodos de
verificar senha e de avaliações.

### Dono
&emsp;Essa classe herda do usuário e possui o telefone e a data de nascimento do dono, que como foi citado,
é necessário para ter lojas. Nela também está as lojas que ele possui e os métodos de criar, editar e deletar
tais lojas.

### Loja
&emsp;Ela define todas as informações de horário de funcionamento, local, rede social, nota média, enfim,
todas as características da loja. Dentro dela que está guardado as avaliações e produtos do estabelecimento,
além dos métodso para calcular a nota média e a menção com as avaliações nela existente.

### Avaliação
&emsp;A classe de avaliação vai guardar a nota, o id do usuário, o comentário, o id da loja e a data da
avaliação. O usuário poderá avaliar qualquer loja com uma nota e o comentário. Utilizada para avaliar as
lojas e gerar suas notas.

### Produto
&emsp;Essa classe possui as informações dos produtos de cada loja, o id do produto, o nome, seu preço, sua
imagem. Ela é usada para suas informações serem mostradas nas lojas.

### Classes de Controle
&emsp;No JavaFX é necessário as classes de controle para dar funcionalidade às telas, dentro do projeto elas
possuem informações como o usuário que está logado, a loja selecionada e os métodos que trocam de
telas, cria usuários, cria lojas etc.

### Classes Extras
&emsp;Utilizamos algumas interfaces prontas para implementar as telas e algumas funções: a classe Seri-
alizable traz a função de salvar informações em arquivos, a classe Initializable possibilita instanciar as
classes de controle para visualizá-las, a classe Comparator permite substituir a função de comparação
para utilizarmos nos algoritmos de filtragem. Temos também a classe ObjectSer que serve para salvar e
carregar arquivos da memória, por meio dela, foi possível fazer um banco de dados com os arquivos de ex-
tensão .ser. Possuímos a classe Tela, que tem métodos para as janelas, como possibilitar arrastar a janela e
abrir outras telas, para finalizar, temos a classe SortAvaliacao que modifica o método de comparação para
ordenar as avaliações.

## Telas
&emsp;Utilizamos a plataforma JavaFX para criar as telas e suas funções, criamos diversas classes de controle
para utilizar os elementos das telas e funcionar o programa com um todo. As telas não possuem a barra
superior padrão que a maioria dos programas possuem, não é possível redimensionar a janela, definimos
que ao clicar e arrastar na tela é possível mover para qualquer posição e implementamos um botão de
fechar customizado, tudo isso por motivos estéticos. As telas, os botões, campos de texto, labels, foram
todos estilizados por um arquivo css de customização e pelas opções do Gluon Scene Builder, que é o
programa que gera e edita os arquivos FXML, no qual possui os elementos e atributos gráficos da tela.

![telaLogin](https://user-images.githubusercontent.com/64702639/221650861-378c9bd8-931e-4058-b950-69c5cf877bd9.jpg)
![telaCadastro](https://user-images.githubusercontent.com/64702639/221650327-ab7041c6-b94f-4a96-a71e-7c5d3185fdc7.jpg)
![telaEntrada](https://user-images.githubusercontent.com/64702639/221651072-4a8a912d-136e-4658-9f5d-7a71ba071fe6.jpg)
![telaCliente](https://user-images.githubusercontent.com/64702639/221651043-8a699e87-49d4-48df-9692-b9d3cef95f60.jpg)
![telaDono](https://user-images.githubusercontent.com/64702639/221651105-919dd7b3-c64b-4226-a3b2-30f0b4b2e3db.jpg)
![TelaLojaDono](https://user-images.githubusercontent.com/64702639/221651157-17f10595-1b1a-4c8b-8da5-1571c01b061b.jpg)
![image](https://user-images.githubusercontent.com/64702639/221651425-c2472c3c-2429-480f-ab66-c52d14833bcb.png)
![telaMinhasAvaliacoes](https://user-images.githubusercontent.com/64702639/221651203-1a85143d-62ce-4b47-a97e-fc356a9557a2.jpg)
![telaAdicionarLoja](https://user-images.githubusercontent.com/64702639/221651226-687a56d8-1d80-4439-a587-31fb3b257b25.jpg)

> ### Frontend

- [X] Tela de Cadastro
- [X] Tela de Login
- [X] Tela de Entrada
- [X] Tela de CompletarCadastro
- [X] Tela de Cliente
- [X] Tela de Avaliações
- [X] Tela de Dono
- [X] Tela da Loja
- [X] Tela de Criar/Editar Lojas
- [X] Tela de Criar/Editar Produtos
- [X] Tela de Criar/Editar Avaliações
- [X] Tela de Editar Perfil

> ### Backend
- [X] Criação de usuário
- [X] Verificação de usuário
- [ ] Criação de perfil de dono
- [ ] Editar perfil
- [X] Banco de dados
- [ ] Criação de lojas
- [ ] Criação de avaliações
- [ ] Mecanismo de busca
- [ ] Formatação dos campos de entrada


