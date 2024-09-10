package agenda;

import java.util.regex.Pattern;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt"; // Nome do arquivo para salvar os contatos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        ContactList contactList = FileManager.loadContactList(FILE_NAME); // Carrega os contatos do arquivo ao iniciar o programa
        boolean running = true; // Controle do loop principal do programa

        // Loop principal para exibir o menu e processar a entrada do usuário
        while (running) {
            showMenu(); // Exibe o menu de opções

            System.out.println("Escolha uma opção: ");
            String input = scanner.nextLine(); // Recebe a entrada do usuário

            // Processa a opção escolhida pelo usuário
            switch (input) {
                case "1":
                    System.out.println("\n===== Adicionar Novo Contato =====");
                    addContact(scanner, contactList); // Chama o método para adicionar um contato
                    System.out.println("==================================\n");
                    break;

                case "2":
                    System.out.println("\n===== Buscar Contato =====");
                    searchContact(scanner, contactList); // Chama o método para buscar um contato
                    System.out.println("================================\n");
                    break;

                case "3":
                    System.out.println("\n===== Remover Contato =====");
                    removeContact(scanner, contactList); // Chama o método para remover um contato
                    System.out.println("=================================\n");
                    break;

                case "4":
                    System.out.println("\n===== Lista de Contatos =====");
                    contactList.listContacts(); // Exibe todos os contatos
                    System.out.println("=================================\n");
                    break;

                case "5":
                    System.out.println("\n===== Salvar Contatos =====");
                    FileManager.saveContactList(contactList, FILE_NAME); // Salva os contatos no arquivo
                    System.out.println("=================================\n");
                    break;

                case "6":
                    System.out.println("\n===== Remover Todos os Contatos =====");
                    removeAllContacts(contactList); // Remove todos os contatos da lista
                    System.out.println("=================================\n");
                    break;

                case "7":
                    System.out.println("\nSaindo do programa. Até logo!");
                    FileManager.saveContactList(contactList, FILE_NAME); // Salva os contatos antes de sair
                    running = false; // Encerra o loop
                    break;

                default:
                    System.out.println("\n*** Entrada inválida. Por favor, insira um número válido. ***\n"); // Exibe mensagem de erro para entrada inválida
            }
        }
        scanner.close(); // Fecha o scanner ao finalizar o programa
    }

    // Método para exibir o menu de opções
    private static void showMenu() {
        System.out.println("=========================================");
        System.out.println("           Gerenciador de Contatos       ");
        System.out.println("=========================================");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Buscar Contato");
        System.out.println("3. Remover Contato");
        System.out.println("4. Listar Contatos");
        System.out.println("5. Salvar Contatos");
        System.out.println("6. Remover Todos os Contatos");
        System.out.println("7. Sair");
        System.out.println("=========================================");
    }

    // Método para adicionar um novo contato
    private static void addContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome do contato: ");
        String name = scanner.nextLine(); // Recebe o nome do contato

        // Loop para validar o número de telefone
        String phone;
        while (true) {
            System.out.println("Digite o número de telefone (somente números): ");
            phone = scanner.nextLine();
            if (isValidPhoneNumber(phone)) { // Verifica se o telefone é válido
                break;
            }
            System.out.println("*** Número de telefone inválido. Deve conter apenas números e ter pelo menos 7 dígitos. ***\n");
        }

        // Loop para validar o email
        String email;
        while (true) {
            System.out.println("Digite o email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) { // Verifica se o email é válido
                break;
            }
            System.out.println("*** Email inválido. Certifique-se de que o email contenha '@' e um domínio válido. ***\n");
        }

        // Cria o novo contato e o adiciona à lista
        Contact contact = new Contact(name, phone, email);
        contactList.addContact(contact);

        System.out.println("\n*** Contato adicionado com sucesso! ***\n");
    }

    // Método para buscar um contato pelo nome ou número
    private static void searchContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome ou número de telefone para buscar: ");
        String query = scanner.nextLine(); // Recebe a entrada para busca

        Contact contact = contactList.searchContact(query); // Realiza a busca do contato
        if (contact != null) { // Se o contato for encontrado, exibe suas informações
            System.out.println("\n===== Contato Encontrado =====");
            System.out.println(contact);
            System.out.println("==============================\n");
        } else {
            System.out.println("\n*** Contato não encontrado. ***\n"); // Exibe mensagem se o contato não for encontrado
        }
    }

    // Método para remover um contato pelo nome ou número
    private static void removeContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome ou número de telefone para remover: ");
        String query = scanner.nextLine(); // Recebe a entrada para remover o contato

        contactList.removeContact(query); // Remove o contato da lista
    }

    // Método para remover todos os contatos
    private static void removeAllContacts(ContactList contactList) {
        contactList.removeAllContacts(); // Remove todos os contatos da lista
        System.out.println("\n*** Todos os contatos foram removidos com sucesso! ***\n");
    }

    // Valida se o número de telefone é válido (apenas dígitos e no mínimo 7)
    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{7,}"); // O número de telefone deve conter apenas números e ter no mínimo 7 dígitos
    }

    // Valida se o email é válido com base no formato padrão
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"; // Expressão regular para verificar o formato de email
        return Pattern.matches(emailRegex, email);
    }
}