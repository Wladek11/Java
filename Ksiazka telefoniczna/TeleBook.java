import java.util.*;

public class TeleBook {
    private List<Contact> contacts = new ArrayList<>();
    private Map<Integer, Contact> phoneToGuest = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public void addContact() {
        boolean check;

        String name;
        boolean isNameError;

        int phoneNumber = 0;
        boolean isNumberError;


        do {
            System.out.println("Podaj nazwę kontaktu:");
            name = scanner.nextLine();

            if (name.isBlank() || name.isEmpty()) {
                isNameError = true;
            } else {
                isNameError = false;
            }

            System.out.println("Podaj numer telefonu");
            try {
                phoneNumber = Integer.valueOf(scanner.nextLine());
                isNumberError = false;
            } catch (NumberFormatException e) {
                isNumberError = true;
            }

            if (!isNameError && !isNumberError) {
                check = false;
            } else {
                System.err.println("Nie podałeś numeru telefonu lub nazwy, spróbuj jeszcze raz");
                check = true;
            }
        } while (check);

        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        phoneToGuest.put(phoneNumber, contact);
    }

    public void displayContactByName() {
        boolean check;
        String name;
        boolean isNameError;
        boolean nameNotFound;

        do {
            System.out.println("Podaj nazwę jaką chcesz wyszukać");
            name = scanner.nextLine();

            if (name.isBlank() || name.isEmpty()) {
                isNameError = true;
            } else {
                isNameError = false;
            }

            if (phoneToGuest.containsValue(name)) {
                nameNotFound = false;
            } else {
                nameNotFound = true;
            }

            if (isNameError) {
                System.err.println("Nie podałeś nazwy");
                check = true;
            } else if (nameNotFound) {
                System.err.println("Nie ma takiej nazwy");
                check = true;
            } else {
                check = false;
            }
        } while (check);


    }

    public void displayContactByPhoneNumber() {
        boolean check;
        int phoneNumber = 0;
        boolean isNumberError;
        boolean numberNotFound;

        do {
            System.out.println("Podaj numer telefonu jaki chcesz wyszukać");

            try {
                phoneNumber = Integer.valueOf(scanner.nextLine());
                isNumberError = false;
            } catch (NumberFormatException e) {
                isNumberError = true;
            } catch (NullPointerException e) {
                isNumberError = true;
            }

            if (phoneToGuest.containsKey(phoneNumber)) {
                numberNotFound = false;
            } else {
                numberNotFound = true;
            }

            if (!isNumberError && !numberNotFound) {
                check = false;
            } else if (phoneToGuest.isEmpty()) {
                System.err.println("Lista obecnie jest pusta, najpierw dodaj kogoś");
                check = false;
            } else {
                System.err.println("Nie ma takiego numeru telefonu");
                check = true;
            }
        } while (check);

        if (!phoneToGuest.isEmpty()) {
            Contact contact = phoneToGuest.get(phoneNumber);
            contact.displayContactInformation();
        }
    }

    public void removeContact() {
        Integer phoneNumber = 0;

        System.out.println("Podaj numer do usunięcia");

        try {
            phoneNumber = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Muisz podać numer telefonu");
        } catch (NullPointerException e) {
            System.err.println("Musisz coś w ogóle podać");
        }

        Contact contact = phoneToGuest.remove(phoneNumber);
    }
}
