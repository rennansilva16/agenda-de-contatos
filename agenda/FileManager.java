package agenda;

import java.io.*;

public class FileManager {

    // Método para carregar a lista de contatos a partir de um arquivo
    public static ContactList loadContactList(String fileName) {
        ContactList contactList = new ContactList(); // Cria uma nova instância de ContactList
        try {
            contactList = ContactList.loadFromFile(fileName); // Carrega os contatos do arquivo
        } catch (IOException e) {
            // Se o arquivo não for encontrado ou ocorrer um erro de I/O, exibe a mensagem e inicia uma nova lista
            System.out.println("Nenhum arquivo de contatos encontrado. Iniciando uma nova lista.");
        }
        return contactList; // Retorna a lista de contatos, seja carregada do arquivo ou uma nova lista vazia
    }

    // Método para salvar a lista de contatos em um arquivo
    public static void saveContactList(ContactList contactList, String fileName) {
        try {
            contactList.saveToFile(fileName); // Tenta salvar a lista de contatos no arquivo
            System.out.println("*** Contatos salvos com sucesso! ***"); // Mensagem de sucesso
        } catch (IOException e) {
            // Em caso de erro ao salvar o arquivo, exibe a mensagem de erro
            System.out.println("Erro ao salvar os contatos: " + e.getMessage());
        }
    }
}
