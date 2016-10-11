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
        catalog = Catalog.getInstance();
        librarian = Librarian.getInstance();
        administrator = Administrator.getInstance();
    }

    public boolean checkBooks(Order order) {
        for (Book book : order.getBooks()) {
            if (!catalog.containsKey(book)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Library library = new Library();
        //boolean bookIsInLibrary = library.checkBooks(new Book("B", "def"));
        //System.out.println(bookIsInLibrary);
        System.out.println(library.administrator);

        Reader reader = new Reader();
        System.out.println(library.checkBooks(new Order(new Book("B", "def"))));
    }
}
