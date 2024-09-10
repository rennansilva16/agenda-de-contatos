# Agenda de Contatos

Este projeto é uma aplicação de gerenciamento de contatos em Java. Ele permite adicionar, buscar, remover e listar contatos, além de salvar e carregar contatos a partir de um arquivo de texto.

## Estrutura do Projeto

- **src/**: Contém os arquivos fonte `.java`.
- **bin/**: Contém os arquivos `.class` compilados.

## Configuração do Ambiente

1. **Certifique-se de que o JDK está instalado**:
   - Verifique se a máquina tem o JDK instalado. Caso não esteja, faça a instalação a partir do [site da Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Para verificar a instalação, utilize os seguintes comandos (após a execução, o terminal deve exibir a versão instalada):
     ```
     java -version
     javac -version
     ```

2. **Navegue até a pasta do projeto**:
   - Certifique-se de que você está na pasta do projeto `agenda-de-contatos`. Use o seguinte comando se necessário:
     ```
     cd caminho/para/agenda-de-contatos
     ```

3. **Compile os arquivos Java**:
   - Navegue até a pasta `src`, onde estão localizados os arquivos `.java`. Você pode usar o seguinte comando para isso:
     ```
     cd src
     ```
   - Compile os arquivos Java, gerando os arquivos `.class` dentro da pasta `bin/src`. Use o seguinte comando para isso:
     ```
     javac -d ../bin *.java
     ```
   - Certifique-se de que os arquivos `.class` foram corretamente gerados na pasta `bin/src`.

---

## Execução da Aplicação

1. **Navegue até a pasta do projeto**:
   - Após compilar os arquivos Java, volte para a pasta principal do projeto `agenda-de-contatos`. Você pode usar o seguinte comando para isso:
     ```
     cd caminho/para/agenda-de-contatos
     ```
   - Caso você já esteja dentro da pasta `src`, basta utilizar o comando:
     ```
     cd ..
     ```

2. **Execute a aplicação**:
   - Com a estrutura de diretórios atual, onde os arquivos `.class` estão em `bin/src` e você está na pasta principal do projeto, use o comando:
     ```
     java -cp bin src.ContactManager
     ```

---

## Problemas Comuns

- **Classe não encontrada**:
  - Verifique se os arquivos `.class` estão na pasta `src` dentro da pasta `bin`, e se você está executando o comando a partir da pasta `agenda-de-contatos`.

- **Erros ao compilar**:
  - Certifique-se de que o JDK está corretamente instalado e que você está na pasta `src` ao compilar os arquivos `.java`.

---