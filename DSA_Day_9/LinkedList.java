import java.util.Scanner;

public class LinkedList {

    private Node start;

    public LinkedList() {
        start = null;
    }

    public void addItem(Scanner scanner) {
        Node newNode = new Node();
        MenuItems item = new MenuItems();

        System.out.println("Enter ID");
        int id = scanner.nextInt();
        item.setItemID(id);

        System.out.println("Enter Name");
        item.setName(scanner.next());

        System.out.println("Enter Price");
        item.setPrice(scanner.nextDouble());

        newNode.setMenu(item);

        if (start == null || item.getName().compareToIgnoreCase(start.menu.getName()) < 0) {
            newNode.next = start;
            start = newNode;
        } else {
            Node current = start;

            while (current.next != null &&
                   current.next.menu.getName().compareToIgnoreCase(item.getName()) < 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        if (start == null) {
            System.out.println("Menu is empty");
            return;
        }

        Node temp = start;

        while (temp != null) {
            System.out.println("-------------------");
            System.out.println("ID: " + temp.menu.getItemID());
            System.out.println("Name: " + temp.menu.getName());
            System.out.println("Price: " + temp.menu.getPrice());
            temp = temp.next;
        }
    }

    public void deleteItem(Scanner scanner) {
        System.out.println("Enter ID to delete");
        int id = scanner.nextInt();

        if (start == null) {
            System.out.println("Menu is empty");
            return;
        }

        if (start.menu.getItemID() == id) {
            start = start.next;
            System.out.println("Item deleted");
            return;
        }

        Node current = start;

        while (current.next != null && current.next.menu.getItemID() != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item not found");
        } else {
            current.next = current.next.next;
            System.out.println("Item deleted");
        }
    }

    public void modifyItem(Scanner scanner) {
        System.out.println("Enter ID to modify");
        int id = scanner.nextInt();

        Node current = start;

        while (current != null && current.menu.getItemID() != id) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Item not found");
            return;
        }

        deleteById(id);

        MenuItems item = new MenuItems();
        item.setItemID(id);

        System.out.println("Enter new name");
        item.setName(scanner.next());

        System.out.println("Enter new price");
        item.setPrice(scanner.nextDouble());

        insertSorted(item);

        System.out.println("Item modified");
    }

    private void deleteById(int id) {
        if (start == null) return;

        if (start.menu.getItemID() == id) {
            start = start.next;
            return;
        }

        Node current = start;
        while (current.next != null && current.next.menu.getItemID() != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    private void insertSorted(MenuItems item) {
        Node newNode = new Node();
        newNode.setMenu(item);

        if (start == null || item.getName().compareToIgnoreCase(start.menu.getName()) < 0) {
            newNode.next = start;
            start = newNode;
        } else {
            Node current = start;

            while (current.next != null &&
                   current.next.menu.getName().compareToIgnoreCase(item.getName()) < 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }
}