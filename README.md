# Biblioteca Socket Server

## Descrição

Este é um projeto de servidor e cliente implementado em Java utilizando sockets para gerenciar uma biblioteca. O servidor permite a listagem, cadastro, aluguel e devolução de livros. Os dados dos livros são armazenados em um arquivo JSON. A comunicação entre cliente e servidor é feita por meio de sockets.

## Tecnologias Usadas

- **Java 17**: Linguagem de programação usada para implementar o servidor e o cliente.
- **Gson**: Biblioteca para manipulação de JSON em Java.
- **Sockets**: Para comunicação entre o cliente e o servidor.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

### Servidor

- **servidor.Livro**: Representa um livro na biblioteca.
- **servidor.Biblioteca**: Classe que gerencia a lista de livros e as operações de cadastro, aluguel e devolução.
- **servidor.JsonUtil**: Classe utilitária para carregar e salvar dados dos livros em um arquivo JSON.
- **servidor.Livros**: Classe utilizada para permitir ler um arrayList.
- **servidor.ServidorBiblioteca**: Classe principal do servidor que aceita conexões de clientes e processa os comandos.

### Cliente

- **cliente.ClienteBiblioteca**: Classe principal do cliente que se conecta ao servidor e envia comandos.

## Como Executar

### Pré-requisitos

- Java 17 instalado.
- Biblioteca Gson. Baixe o JAR do Gson [aqui](https://github.com/google/gson).

### Passo a Passo

1. **Baixar o Projeto**

   Clone o repositório ou baixe os arquivos do projeto.

2. **Colocar a Biblioteca Gson no Projeto**

   Coloque o arquivo `gson-2.8.9.jar` (ou outra versão do Gson) no diretório do projeto.

3. **Preparar o Arquivo JSON**

   Certifique-se de que o arquivo `livros.json` está presente no diretório do projeto com a seguinte estrutura:

   ```json
   {
     "livros": [
       {
         "titulo": "Meditações",
         "autor": "Marco Aurélio",
         "genero": "Filosofia",
         "exemplares": 4
       },
       {
         "titulo": "Orgulho e Preconceito",
         "autor": "Jane Austen",
         "genero": "Romance",
         "exemplares": 4
       },
       {
         "titulo": "Nada Pode Me Ferir",
         "autor": "David Goggins",
         "genero": "Autoajuda",
         "exemplares": 2
       },
       {
         "titulo": "O Homem Invisível",
         "autor": "H.G. Wells",
         "genero": "Ficção Científica",
         "exemplares": 1
       },
       {
         "titulo": "Utopia",
         "autor": "Thomas More",
         "genero": "Filosofia",
         "exemplares": 14
       },
       {
         "titulo": "A Revolução dos Bichos",
         "autor": "George Orwell",
         "genero": "Fábula Política",
         "exemplares": 1
       },
       {
         "titulo": "As Crônicas de Nárnia",
         "autor": "C.S. Lewis",
         "genero": "Fantasia",
         "exemplares": 8
       },
       {
         "titulo": "Cartas Chilenas",
         "autor": "Tomás Antônio Gonzaga",
         "genero": "Sátira",
         "exemplares": 3
       },
       {
         "titulo": "O Príncipe",
         "autor": "Nicolau Maquiavel",
         "genero": "Filosofia Política",
         "exemplares": 1
       },
       {
         "titulo": "O Guia do Mochileiro das Galáxias",
         "autor": "Douglas Adams",
         "genero": "Ficção Científica",
         "exemplares": 10
       }
     ]
   }

4. **Compilar e Executar o Servidor**

   No terminal, navegue até o diretório do projeto e execute os seguintes comandos:

       javac -cp gson-2.8.9.jar src/main/java/servidor/*.java
       java -cp gson-2.8.9.jar:src/main/java servidor.ServidorBiblioteca
    
   Isso iniciará o servidor na porta 12345.

5. **Compilar e Executar o Cliente**

   Abra um novo terminal, navegue até o diretório do projeto e execute os seguintes comandos:

       javac -cp gson-2.8.9.jar src/main/java/cliente/*.java
       java -cp gson-2.8.9.jar:src/main/java cliente.ClienteBiblioteca

   Isso conectará o cliente ao servidor.

## Usando o Programa

Depois de executar o cliente, você verá um prompt onde poderá digitar comandos. Aqui estão os comandos disponíveis:

### Comandos Disponíveis
  Listar Livros
  
  Comando: LISTAR
  - Descrição: Lista todos os livros disponíveis na biblioteca.
  
  Cadastrar Livro
  
  - Comando: CADASTRAR;autor;nome;genero;numeroExemplares
  - Exemplo: CADASTRAR;J.K. Rowling;Harry Potter;Fantasia;10
  - Descrição: Cadastra um novo livro na biblioteca.
  
  Alugar Livro
  
  - Comando: ALUGAR;nomeDoLivro
  - Exemplo: ALUGAR;Harry Potter
  - Descrição: Aluga um exemplar do livro especificado pelo nome.
  
  Devolver Livro
  
  - Comando: DEVOLVER;nomeDoLivro
  - Exemplo: DEVOLVER;Harry Potter
  - Descrição: Devolve um exemplar do livro especificado pelo nome.
  
  Sair
  
  - Comando: SAIR
  - Descrição: Encerra a conexão do cliente com o servidor.
