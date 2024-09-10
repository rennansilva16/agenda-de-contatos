
public class Contact {
    // Atributos da classe
    private String name;
    private String phoneNumber;
    private String email;

    // Construtor para inicializar os atributos
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter para o nome
    public String getName() {
        return name;
    }

    // Getter para o número de telefone
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter para o e-mail
    public String getEmail() {
        return email;
    }

    // Método toString() para exibir as informações do contato
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}