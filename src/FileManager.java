package src;

import java.io.*;

public class FileManager {

    public static ContactList loadContactList(String fileName) {
        ContactList contactList = new ContactList();
        try {
            contactList = ContactList.loadFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Nenhum arquivo de contatos encontrado. Iniciando uma nova lista.");
        }
        return contactList;
    }

    public static void saveContactList(ContactList contactList, String fileName) {
        try {
            contactList.saveToFile(fileName);
            System.out.println("*** Contatos salvos com sucesso! ***");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os contatos: " + e.getMessage());
        }
    }
}
