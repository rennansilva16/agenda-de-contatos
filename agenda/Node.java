package agenda;

public class Node {
    private Contact contact;
    private Node next;

    // Construtor
    public Node(Contact contact) {
        this.contact = contact;
        this.next = null;
    }

    // Getter para o contato
    public Contact getContact() {
        return contact;
    }

    // Getter para o próximo nó
    public Node getNext() {
        return next;
    }

    // Setter para o próximo nó
    public void setNext(Node next) {
        this.next = next;
    }
}