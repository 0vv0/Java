package lesson2.task2;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */

class Book {
    private static int idCounter = 0;
    //Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
    private final int id = idCounter++;
    private final String name;
    private final Author author;
    private final String printedBy;
    private final int year;
    private final int volume;
    private final float price;
    private final boolean softBinding;

    static class Builder {
        private String name;
        private Author author;
        private String printedBy;
        private int year;
        private int volume;
        private float price;
        private boolean softBinding;

        Book build() {
            if(name==null
                    ||author==null
                    ||printedBy==null){
                throw new IllegalArgumentException("Not all values were set");
            }
            return new Book(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAuthor(Author author) {
            this.author = author;
            return this;
        }

        public Builder setPrintedBy(String printedBy) {
            this.printedBy = printedBy;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setSoftBinding(boolean softBinding) {
            this.softBinding = softBinding;
            return this;
        }
    }

    Builder getBuilder() {
        return new Builder();
    }

    Book(Builder builder) {
        this.author = builder.author;
        this.name = builder.name;
        this.printedBy = builder.printedBy;
        this.year = builder.year;
        this.volume = builder.volume;
        this.price = builder.price;
        this.softBinding = builder.softBinding;
    }

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

    public String toString() {
        return String.format("Book #%d, %s, %s, %4d, %4dpages, $%.2f, ", id, author.toString(), name, year, volume, price) + (isSoftBinding() ? "soft binding" : "hard binding");
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
