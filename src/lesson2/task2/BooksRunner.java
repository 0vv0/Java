package lesson2.task2;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
class BooksRunner {
    public static void main(String[] args) {
        Books bookShelf = new Books();//new empty book shelf
        printLine("Empty book shelf:");
        printBooks(bookShelf);

        Book theBook = new Book.Builder()
                .setAuthor(new Author("nick", "name", "surname", 1980))
                .setTitle("My Kampf")
                .setSoftBinding(true)
                .build();

        Book theBook2 = new Book.Builder()
                .setAuthor(new Author("The First", "Oleksii", "Sergiienko", 1980))
                .setTitle("My First Book")
                .setPrintedBy("SelfPrint")
                .setYear(2016)
                .setVolume(50)
                .setPrice(10f)
                .setSoftBinding(true)
                .build();

        bookShelf
                .add(theBook)
                .add(theBook2)
                .add(new Book.Builder().build());

        printLine("3 books on shelf:");
        printBooks(bookShelf);

        bookShelf.add(theBook);
        printLine("Book with Id=0 was added second time:");
        printBooks(bookShelf);

        printLine("Books printed in or after 2000:");
        printBooks(bookShelf.getBooksFrom(2000));

        bookShelf.removeBook(theBook);
        printLine("Book with Id=0 was removed from shelf:");
        printBooks(bookShelf);

        bookShelf.removeAll();
        printLine("Book shelf is cleared:");
        printBooks(bookShelf);

        bookShelf = new Books();
        printLine("Book shelf with one book:");
        bookShelf.add(
                new Book.Builder()
                        .setAuthor(new Author("THEUNKNOWN", "The Author", "Unknown", 1980))
                        .setPrice(.22f)
                        .build()
        );
        printBooks(bookShelf);

    }

    private static void printBooks(Books books) {
        books.getAllBooks().forEach(book -> System.out.println(book.toString()));
        System.out.println();
    }

    private static void printLine(String line) {
        System.out.println(line);
    }
}
