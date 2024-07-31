package ro.beta.curs13.homework;

public class Quote {
    private final int id;
    private final String author;
    private final String quote;
    private boolean favourite;

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public int getId(){
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public void setFavourite() throws AlreadyFavourite {
        if (this.favourite) {
            throw new AlreadyFavourite("This quote is already marked as favourite.");
        }
        this.favourite = true;
    }

    public boolean isFavourite() {
        return favourite;
    }

    @Override
    public String toString() {
        return "Quote {" +
                "Id: " + id +
                ", Author: '" + author + '\'' +
                ", Quote: '" + quote + '\'' +
                '}';
    }
}
