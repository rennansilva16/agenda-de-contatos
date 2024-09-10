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
   - Certifique-se de que você está na pasta do projeto. Use o comando se for preciso:
     ```
     cd caminho/para/agenda-de-contatos
     ```

3. **Compile os arquivos Java**:
   - Navegue até a pasta `src` onde estão localizados os arquivos `.java`:
     ```
     cd ./src
     ```
   - Compile os arquivos Java e coloque os arquivos `.class` na pasta `bin`:
     ```
     javac -d ../bin *.java
     ```

## Execução da Aplicação

1. **Navegue até a pasta do projeto**:
   - Após compilar os arquivos java, volte para a pasta do prjeto(agenda-de-contatos):
     ```
     cd caminho/para/agenda-de-contatos 
     
     ou

     cd ..
     ```

2. **Execute a aplicação**:
   - Com a estrutura de diretórios atual, onde os arquivos `.class` estão dentro da pasta src em `bin` e você está na pasta principal do projeto, use o comando:
     ```
     java -cp bin src.ContactManager

     ```

## Problemas Comuns

- **Classe não encontrada**:
  - Verifique se os arquivos `.class` estão realmente na pasta `src` dentro de `bin` e se você está executando dentro da pasta `agenda-de-contatos` .

- **Erros ao compilar**:
  - Certifique-se de que o JDK está corretamente instalado e que você está na pasta `src` ao compilar os arquivos `.java`.

---