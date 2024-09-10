# Agenda de Contatos

Este projeto é uma aplicação de gerenciamento de contatos em Java. Ele permite adicionar, buscar, remover e listar contatos, além de salvar e carregar contatos a partir de um arquivo de texto.

## Estrutura do Projeto

- **src/**: Contém os arquivos fonte `.java`.
- **bin/**: Contém os arquivos `.class` compilados.

## Configuração do Ambiente

1. **Certifique-se de que o JDK está instalado**:
   - Verifique a instalação do JDK com o comando:
     ```sh
     java -version
     javac -version
     ```

2. **Navegue até a pasta do projeto**:
   - Use o comando:
     ```
     cd caminho/para/agenda-de-contatos
     ```

3. **Compile os arquivos Java**:
   - Navegue até a pasta `src` onde estão localizados os arquivos `.java`:
     ```
     cd src
     ```
   - Compile os arquivos Java e coloque os arquivos `.class` na pasta `bin`:
     ```
     javac -d ../bin *.java
     ```

## Execução da Aplicação

1. **Navegue até a pasta do projeto**:
   - Se ainda não estiver na pasta principal do projeto, vá para ela:
     ```
     cd caminho/para/agenda-de-contatos
     ```

2. **Execute a aplicação**:
   - Com a estrutura de diretórios atual, onde os arquivos `.class` estão em `bin` e você está na pasta principal do projeto, use o comando:
     ```
     java -cp bin ContactManager
     ```

## Problemas Comuns

- **Classe não encontrada**:
  - Verifique se os arquivos `.class` estão realmente na pasta `bin` e se o diretório de execução está correto.

- **Erros ao compilar**:
  - Certifique-se de que o JDK está corretamente instalado e que você está na pasta correta ao compilar os arquivos `.java`.

---