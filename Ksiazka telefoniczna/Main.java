import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean shouldContinue = true;

        TeleBook teleBook = new TeleBook();

        while (shouldContinue) {

            System.out.println(">>>Opcje:");
            System.out.println("0 - Dodaj kontakt");
            System.out.println("1 - Szukaj po nazwie");
            System.out.println("2 - Szukaj po telefonie");
            System.out.println("3 - Usuń");
            System.out.println("4 - Koniec");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 0 -> teleBook.addContact();
                case 1 -> teleBook.displayContactByName();
                case 2 -> teleBook.displayContactByPhoneNumber();
                case 3 -> teleBook.removeContact();
                case 4 -> {
                    System.out.println("Wyjście...");
                    shouldContinue = false;
                }
            }
        }
    }
}










//    dodawanie nowych rekordów,
//        wyszukiwania po części nazwy,
//        wyszukiwania po części numeru telefonu,
//        usuwanie rekordów.
//
//        Program powinien zapisywać stan przy zamykaniu aplikacji.
//
//        Ograniczenia:
//
//        nazwy kontaktów w programie powinny być unikalne,
//        nazwa ani numer telefonu nie mogą być nullami ani pustymi Stringami ("").