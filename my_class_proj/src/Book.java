public class Book implements Cloneable {

    private String title;

    private String author;

    private float price;



    public Book() {

        this.title = null;

        this.author = null;

    }



    public Book(String title, String author, float price) {

        this.title = title;

        this.author = author;

        this.price = price;

    }



    // Overriding the clone() method

    @Override

    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }

    public void setTitle(String title) {

        this.title = title;

    }



    public void setAuthor(String author) {

        this.author = author;

    }



    public void setPrice(float price) {

        this.price = price;

    }



    public String getTitle() {

        return this.title;

    }



    public String getAuthor() {

        return this.author;

    }



    public float getPrice() {

        return this.price;

    }



    public String toString() {

        return "Title - " + this.title + "\nAuthor - "

                + this.author + "\nPrice - "+ String.format("%.2f", this.price);

    }

    //Metodo para comprobar 2 libros
    public boolean equals(Object obj) {
        if(this == obj) return true; //En caso de que sea igual
        if(obj == null) return false;

        Book other = (Book) obj;

        return this.title.equals(other.title)
                && this.author.equals(other.author)
                && Float.compare(this.price, other.price) == 0;
    }

}