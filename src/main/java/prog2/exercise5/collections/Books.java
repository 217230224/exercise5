package prog2.exercise5.collections;

public enum Books {
    BOOK1("001", "Carrie", "Stephen King", 272, "Horror", 3.98, 1974, "Wings", 14),
    BOOK2("002", "The Firm", "Robin Waterfield / John Grisham", 448, "Thriller", 4.01, 1991, "Addison Wesley Publishing Company", 25),
    BOOK3("003","Slaughterhouse-Five","Kurt Vonnegut Jr.",275,"Sci-Fi",4.10,1969,"Dial Press",18.0),
    BOOK4("004","The Great Gatsby","F. Scott Fitzgerald",188,"Classic",3.91,1925,"Scribner",8.0),
    BOOK5("005","American Gods","Neil Gaiman",635,"Fantasy",4.11,2001,"Harper Collins",4.0);
    private String bookID;
    private String bookName;
    private String bookAuthor;
    private int bookPages;
    private String bookGenre;
    private double bookRating;
    private int  bookPublishedYear;
    private String bookPublisher;
    private double bookPrice;
    private final double bookRent = 5.0;
    
    private Books(String bookID, String bookName, String bookAuthor, int bookPages, String bookGenre, double bookRating,int bookPublishedYear, String bookPublisher, double bookPrice) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
        this.bookGenre = bookGenre;
        this.bookRating = bookRating;
        this.bookPublishedYear = bookPublishedYear;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
    }


    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public int getBookPages() {
        return bookPages;
    }
    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }
    public String getBookGenre() {
        return bookGenre;
    }
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    public double getBookRating() {
        return bookRating;
    }
    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }
    public int getBookPublishedYear() {
        return bookPublishedYear;
    }
    public void setBookPublishedYear(int bookPublishedYear) {
        this.bookPublishedYear = bookPublishedYear;
    }
    public String getBookPublisher() {
        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    public double getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public double getBookRent() {
        return bookRent;
    }
    
}
