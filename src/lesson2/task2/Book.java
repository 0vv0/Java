package lesson2.task2;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Book {
    private static int idCounter = 0;
    //Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
    private int id = idCounter++;
    private String name = "";
    private Author author = new Author("", "", "", 0);
    private String printedBy = "";
    private int year = 0;
    private int volume = 0;
    private float price = 0.0f;
    private boolean softBinding = true;

    /**
     * @param author
     * @param title
     * @param printedBy
     * @param yearOfPrint
     * @param volume
     * @param price
     * @param isSoftBinding
     */
    Book(Author author, String title, String printedBy, int yearOfPrint, int volume, int price, boolean isSoftBinding) {
        this.author = author;
        this.name = title;
        this.printedBy = printedBy;
        this.year = yearOfPrint;
        this.volume = volume;
        this.price = price;
        this.softBinding = isSoftBinding;
    }

    void changePrice(float newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price less then 0:" + newPrice);
        }
        this.price = newPrice;
    }

    public String toString(){
        return String.format("Book #%d, %s, %s, %4d, %4dpages, $%.2f, ", id, author.toString(), name, year, volume, price) + (isSoftBinding()?"soft binding":"hard binding");
    }

    public void setCorrectTitle(String newTitle) {
        this.name = newTitle;
    }

    public void setCorrectAuthor(Author correctedAuthor) {
        this.author = correctedAuthor;
    }

    public void setCorrectPrintAgency(String printedBy) {
        this.printedBy = printedBy;
    }

    public void setCorrectYearOfPrint(int year) {
        this.year = year;
    }

    public void setCorrectVolume(int volume) {
        this.volume = volume;
    }

    public void setCorrectTypeOfBinding(boolean isSoftBinding) {
        this.softBinding = isSoftBinding;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPrintedBy() {
        return printedBy;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isSoftBinding() {
        return softBinding;
    }
}
