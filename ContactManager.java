
import java.util.regex.Pattern;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt"; // Nome do arquivo para salvar os contatos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = FileManager.loadContactList(FILE_NAME); // Carrega os contatos do arquivo
        boolean running = true;

        while (running) {
            // Exibe o menu
            showMenu();

            System.out.println("Escolha uma opção: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n===== Adicionar Novo Contato =====");
                    addContact(scanner, contactList);
                    System.out.println("==================================\n");
                    break;

                case "2":
                    System.out.println("\n===== Buscar Contato =====");
                    searchContact(scanner, contactList);
                    System.out.println("================================\n");
                    break;

                case "3":
                    System.out.println("\n===== Remover Contato =====");
                    removeContact(scanner, contactList);
                    System.out.println("=================================\n");
                    break;

                case "4":
                    System.out.println("\n===== Lista de Contatos =====");
                    contactList.listContacts();
                    System.out.println("=================================\n");
                    break;

                case "5":
                    System.out.println("\n===== Salvar Contatos =====");
                    FileManager.saveContactList(contactList, FILE_NAME); // Salva os contatos no arquivo
                    System.out.println("=================================\n");
                    break;

                case "6":
                    System.out.println("\n===== Remover Todos os Contatos =====");
                    removeAllContacts(contactList);
                    System.out.println("=================================\n");
                    break;

                case "7":
                    System.out.println("\nSaindo do programa. Até logo!");
                    FileManager.saveContactList(contactList, FILE_NAME); // Salva os contatos antes de sair
                    running = false;
                    break;

                default:
                    System.out.println("\n*** Entrada inválida. Por favor, insira um número válido. ***\n");
            }
        }
        scanner.close();
    }

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

    private static void addContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome do contato: ");
        String name = scanner.nextLine();

        String phone;
        while (true) {
            System.out.println("Digite o número de telefone (somente números): ");
            phone = scanner.nextLine();
            if (isValidPhoneNumber(phone)) {
                break;
            }
            System.out.println("*** Número de telefone inválido. Deve conter apenas números e ter pelo menos 7 dígitos. ***\n");
        }

        String email;
        while (true) {
            System.out.println("Digite o email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            }
            System.out.println("*** Email inválido. Certifique-se de que o email contenha '@' e um domínio válido. ***\n");
        }

        Contact contact = new Contact(name, phone, email);
        contactList.addContact(contact);

        System.out.println("\n*** Contato adicionado com sucesso! ***\n");
    }

    private static void searchContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome ou número de telefone para buscar: ");
        String query = scanner.nextLine();

        Contact contact = contactList.searchContact(query);
        if (contact != null) {
            System.out.println("\n===== Contato Encontrado =====");
            System.out.println(contact);
            System.out.println("==============================\n");
        } else {
            System.out.println("\n*** Contato não encontrado. ***\n");
        }
    }

    private static void removeContact(Scanner scanner, ContactList contactList) {
        System.out.println("Digite o nome ou número de telefone para remover: ");
        String query = scanner.nextLine();

        contactList.removeContact(query);
    }

    private static void removeAllContacts(ContactList contactList) {
        contactList.removeAllContacts();
        System.out.println("\n*** Todos os contatos foram removidos com sucesso! ***\n");
    }

    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{7,}"); // Deve conter pelo menos 7 dígitos
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}