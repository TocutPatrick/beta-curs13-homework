package ro.beta.curs13.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteService {
    private final List<Quote> quotesList;

    public QuoteService(List<Quote> quotesList) {
        this.quotesList = quotesList;
    }

    public List<String> getAllQuotes() {
        List<String> quotes = new ArrayList<>();
        for (Quote q : quotesList) {
            quotes.add(q.getQuote());
        }
        return quotes;
    }

    public List<Quote> getQuotesForAuthor(String author) throws InvalidInput {
        List<Quote> result = new ArrayList<>();
        for (Quote q : quotesList) {
            if (q.getAuthor().equalsIgnoreCase(author)) {
                result.add(q);
            }
            if (result.isEmpty()) {
                throw new InvalidInput("Author not found");
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        for (Quote q : quotesList) {
            if (!result.contains(q.getAuthor())) {
                result.add(q.getAuthor());
            }
        }
        return result;
    }

    public void setFavourite(int id) {
        for (Quote q : quotesList) {
            if (q.getId() == id) {
                try {
                    q.setFavourite();
                } catch (AlreadyFavourite e) {
                    System.err.println("Error: " + e.getMessage());
                }
                return;
            }
        }
    }

    public List<Quote> getFavourites(){
        List<Quote> favourites = new ArrayList<>();
        for (Quote q : quotesList){
            if(q.isFavourite()){
                favourites.add(q);
            }
        }
        return favourites;
    }

    public String getRandomQuote() {
        Random rand = new Random();
        String result = "";
        for (Quote q : quotesList) {
            if (q.getId() == rand.nextInt(quotesList.toArray().length)) {
                result = q.getQuote();
            }
        }
        return result;
    }


}

