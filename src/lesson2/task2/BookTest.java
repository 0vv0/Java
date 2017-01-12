package lesson2.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleksii.Sergiienko on 1/12/2017.
 */
public class BookTest {
    @Test
    public void getId() throws Exception {
        Book book;
        book = new Book.Builder().build();
        assert book.getId()==0;
        assert book.getId()==0;
        Book newBook = new Book.Builder().build();
        assert newBook.getId()==1;
        book=new Book.Builder().build();
        assert book.getId()==2;
    }

    @Test
    public void getTitle() throws Exception {
        Book book;
        book = new Book.Builder().build();
        assert book.getTitle().equals("");
        book = new Book.Builder().setTitle(null).build();
        assert book.getTitle().equals("");
        book = new Book.Builder().setTitle("").build();
        assert book.getTitle().equals("");
        book = new Book.Builder().setTitle("The Title").build();
        assert book.getTitle().equals("The Title");
        assertFalse(book.getTitle().equals("the title"));
    }

    @Test
    public void getAuthor() throws Exception {
        Book book;
        book = new Book.Builder().build();
        assert book.getAuthor().getNick().equals("");
        assert book.getAuthor().getName().equals("");
        assert book.getAuthor().getSurname().equals("");
        assert book.getAuthor().getYearOfBirth()==0;

        book = new Book.Builder().setAuthor(null).build();
        assert book.getAuthor().getNick().equals("");
        assert book.getAuthor().getName().equals("");
        assert book.getAuthor().getSurname().equals("");
        assert book.getAuthor().getYearOfBirth()==0;

        Author author = new Author("The Nick", "The Name", "The Surname", 1980);
        book = new Book.Builder().setAuthor(author).build();
        assert book.getAuthor().equals(author);
        assertFalse(book.getAuthor().equals(new Author("The Nick", "The Name", "The Surname", 1980)));
    }

    @Test
    public void getPrintedBy() throws Exception {

    }

    @Test
    public void getYear() throws Exception {

    }

    @Test
    public void getVolume() throws Exception {

    }

    @Test
    public void isSoftBinding() throws Exception {

    }

}