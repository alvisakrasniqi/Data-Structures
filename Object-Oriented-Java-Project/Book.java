public class Book{

    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;

    }

    public String getDetails(){
        return "title: " + title + ", author: " + author + ", isbn: " + isbn; 
    } 


}