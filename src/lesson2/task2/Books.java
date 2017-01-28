package lesson2.task2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Books {
    /*
    2. Books: ArrayList<Book> books. Позволяет выполнить поиск:
    a)  список книг заданного автора;
    b)  список книг, выпущенных заданным издательством;
    c)  список книг, выпущенных после заданного года.
     */
    private final Set<Book> books = new HashSet<>();

    Books() {
    }

    Books(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book is Null");
        }
        books.add(book);
    }

    Books add(Book book) {
        if (book != null) {
            books.add(book);
        }
        return this;
    }

    Books removeBook(Book book){
        if (book != null) {
            books.remove(book);
        }
        return this;
    }


    Books getBooksOf(Author author) {
        return getBooksByFilter("author", author);
    }


    Books getBooksPrintedBy(String printAgency) {
        return getBooksByFilter("agency", printAgency);
    }

    Books getBooksFrom(int year) {
        return getBooksFromYearToYear(year, null);
    }

    Books getBooksBefore(int year) {
        return getBooksFromYearToYear(null, year);
    }

    Books getBooksBetween(int startYear, int endYear) {
        return getBooksFromYearToYear(startYear, endYear);
    }

    Set<Book> getAllBooks() {
        return this.books;
    }

    Books removeAll(){
        books.clear();
        return this;
    }

    private Books getBooksByFilter(String fieldName, Object object) {
        Books list = new Books();
        assert books != null;
        switch (fieldName.toLowerCase().intern()) {
            case "author":
                for (Book book : books) {
                    if (book.getAuthor().equals(object)) {
                        list.add(book);
                    }
                }
                return list;
            case "agency":
                for (Book book : books) {
                    if (book.getPrintedBy().equals(object)) {
                        list.add(book);
                    }
                }
                return list;
            default:
                return this;
        }
    }

    private Books getBooksFromYearToYear(Integer fromYear, Integer toYear) {
        Books list = new Books();
        assert books != null;
        if (fromYear == null) {
            fromYear = Integer.MIN_VALUE;
        }
        if (toYear == null) {
            toYear = Integer.MAX_VALUE;
        }

        if(fromYear>toYear){return new Books();}

        for (Book book : books) {
            if (book.getYear()>=fromYear && book.getYear()<=toYear) {
                list.add(book);
            }
        }
        return list;
    }


}
