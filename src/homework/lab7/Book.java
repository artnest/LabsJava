package homework.lab7;

/**
 * Created by theme on 10/5/16.
 */
class Book {
    private String author;
    private String name;
    private boolean isInLibrary = true;

    Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    String getAuthor() {
        return author;
    }

    String getName() {
        return name;
    }

    boolean isInLibrary() {
        return isInLibrary;
    }

    void setInLibrary(boolean inLibrary) {
        isInLibrary = inLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return author.equals(book.author) && name.equals(book.name);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
