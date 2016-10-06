package homework.lab7;

/**
 * Created by theme on 10/5/16.
 */
public class Library {
    //private List<Book> catalog;
    //private List<Reader> readers;
    private Catalog catalog;
    private Librarian librarian;
    private Administrator administrator;

    public Library() {
        //catalog = new ArrayList<>();
        //readers = new LinkedList<>();
        //blackList = new LinkedList<>();
        catalog = new Catalog();
        librarian = Librarian.getInstance();
        administrator = Administrator.getInstance();
    }

    /*public boolean checkBook(String author, String bookName) {
        return catalog.isInList(new Book(author, bookName));
    }*/

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.administrator);
    }
}
