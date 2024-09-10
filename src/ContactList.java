package src;

import java.io.*;

public class ContactList {
    private Node head;

    public ContactList() {
        this.head = null;
    }

    // Método para adicionar um novo contato à lista
    public void addContact(Contact contact) {
        Node newNode = new Node(contact);

        if (head == null) {
            head = newNode; // Se a lista estiver vazia, o novo nó é o primeiro.
        } else {
            Node current = head;
            while (current.getNext() != null) {
                // Percorre até o último nó
                current = current.getNext();
            }

            current.setNext(newNode); // Adiciona um novo nó ao final da lista
        }

        System.out.println("Contato adicionado com sucesso.");
    }

    // Método para buscar um contato pelo nome ou pelo número de telefone (agora com busca parcial)
    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            Contact contact = current.getContact();
            // Verifica se o nome ou parte dele ou o telefone coincidem
            if (contact.getName().toLowerCase().contains(nameOrPhone.toLowerCase()) || contact.getPhoneNumber().equals(nameOrPhone)) {
                return contact; // Retorna o contato se a busca for bem-sucedida
            }
            current = current.getNext();
        }
        return null; // Retorna null se o contato não for encontrado
    }

    // Método para remover um contato pelo nome ou número de telefone
    public void removeContact(String nameOrPhone) {
        if (head == null) {
            System.out.println("Lista vazia. Não há contatos para remover.");
            return;
        }

        if (head.getContact().getName().equalsIgnoreCase(nameOrPhone) || head.getContact().getPhoneNumber().equals(nameOrPhone)) {
            head = head.getNext(); // Remove o primeiro nó se ele for o contato a ser removido.
            
            System.out.println("Contato removido com sucesso!");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.getContact().getName().equalsIgnoreCase(nameOrPhone) || current.getContact().getPhoneNumber().equals(nameOrPhone)) {
                if (previous != null) {
                    previous.setNext(current.getNext()); // Remove o nó do meio ou do final
                }
                System.out.println("Contato removido com sucesso!");
                return;
            }
            previous = current;
            current = current.getNext();
        }

        System.out.println("Contato não encontrado.");
    }

    // Método para remover todos os contatos
    public void removeAllContacts() {
        head = null;
        System.out.println("Todos os contatos foram removidos com sucesso.");
    }

    // Método para listar todos os contatos
    public void listContacts() {
        if (head == null) {
            System.out.println("Nenhum contato na lista.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.getContact()); // O método toString() será chamado automaticamente
            current = current.getNext();
        }
    }

    // Método para salvar contatos em um arquivo de texto
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node current = head;
            while (current != null) {
                Contact contact = current.getContact();
                writer.write(contact.getName() + "|" + contact.getPhoneNumber() + "|" + contact.getEmail());
                writer.newLine();
                current = current.getNext();
            }
        }
    }

    // Método para carregar contatos de um arquivo de texto
    public static ContactList loadFromFile(String fileName) throws IOException {
        ContactList contactList = new ContactList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String name = parts[0];
                    String phone = parts[1];
                    String email = parts[2];
                    Contact contact = new Contact(name, phone, email);
                    contactList.addContact(contact);
                }
            }
        }
        return contactList;
    }

    // Classe Node
    public class Node {
        private Contact contact;
        private Node next;

        public Node(Contact contact) {
            this.contact = contact;
            this.next = null;
        }

        public Contact getContact() {
            return contact;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}