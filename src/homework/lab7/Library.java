package homework.lab7;

public class Library {
    private Catalog catalog;
    private Librarian librarian;
    private Administrator administrator;
//    private LinkedList<Reader> readers;

    public Library() {
        catalog = Catalog.getInstance();
        librarian = Librarian.getInstance();
        administrator = Administrator.getInstance();
    }

    public boolean checkBooks(Order order) {
        for (Book book : order.getBooks()) {
            if (!catalog.booksCatalog.containsKey(book)) {
                return false;
            }
        }

        return true;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}
