package homework.lab7;

class Book extends LibraryPart {
    private String name;
    private String author;

    Book(String name, String author) {
        super("Book", Type.ITEM);

        this.name = name;
        this.author = author;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"" + " by " + author;
    }
}
