
public class BookAccess {

    public static void main(String s[]) throws CloneNotSupportedException {

        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);



        Book book2 = new Book();

        book2.setTitle("Sapiens");

        book2.setAuthor("Yuval Noah Harari");

        book2.setPrice(25.00f);



        System.out.println("The first book object is ");

        System.out.println(book1);

        System.out.println("The second book object is ");

        System.out.println(book2);



        Book book3 = (Book)(book1.clone());

        System.out.println("The third book cloned object is ");

        System.out.println(book3);

    }

    public static boolean bookEquals(Book a, Book b) {
        if(a == null || b == null) {
            System.out.println("Uno de los libros no existe");
            return false;
        }
        return a.equals(b);
    }

}