package ro.beta.curs13.homework;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ReadFromFile r = new ReadFromFile("quotes.txt");
        QuoteService service = new QuoteService(r.readFromFile());

        System.out.println(service.getAllQuotes());

        try {
            System.out.println("Enter author: ");
            String author = scan.nextLine();
            for (Quote q : service.getQuotesForAuthor(author)) {
                System.out.println(q);
            }
        } catch (InvalidInput e) {
            System.err.println(e.getMessage());
        }

        System.out.println(service.getAuthors());

        do {
            System.out.println("Enter ID to set favourite: ");
            int id = scan.nextInt();
            service.setFavourite(id);
            System.out.println("Do you want to set abother one?");
        } while (response().equalsIgnoreCase("yes"));
        System.out.println("You favourite quotes are: " + service.getFavourites());

        System.out.println(service.getRandomQuote());
    }
    public static String response() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
