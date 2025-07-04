import java.util.ArrayList;
import java.util.Iterator;

public class Library{

    private ArrayList<Book> books;

    public Library(){

        books = new ArrayList<>();
    }


    public void addBook(Book book){
        books.add(book);
        System.out.println("the book added: " + book.getDetails());

    }

  public void removeBook(String isbn) {
    Iterator<Book> iterator = books.iterator();
    while (iterator.hasNext()) {
        Book book = iterator.next();
        if (book.getDetails().contains(isbn)) {
            iterator.remove();
            return;
        }
    }
}

    public void printBooks(){

        if(books.isEmpty()){
            System.out.println("no books are in the library");
            return;
        }

        System.out.println("the books found:");
        for(int i=0; i< books.size(); i++){
            System.out.println(books.get(i).getDetails());
            System.out.println();
        }



    }


    public static void main(String[] args){


        //library instance
        Library library = new Library();


        //book instances
        Book book1 = new Book("Broken April", "Ismail Kadare", "93832497823");
        Book book2 = new Book("All about love", "Bell Hooks", "873492738498234");
        Book book3 = new Book("The Palace of Dreams", "Ismail Kadare", "840398203984");

        //add books to library
        library.addBook(book2);
        library.addBook(book1);
        library.addBook(book3);


        //print the books in the library
        library.printBooks();

        //remove the book with the "93832497823" isbn
        library.removeBook("93832497823");
    
        //print the current books in the library
        library.printBooks();

    }

}
