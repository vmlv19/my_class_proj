import java.util.Scanner;

public class BooksMenu {

    //metodo para devolver el mas caro y comprar 2 libros
    public static Book moreExpensiveBook(Book a, Book b) {
        if (a == null || b == null) {
            System.out.println("Uno de los libros no existe");
            return null;
        }
        return (a.getPrice() >= b.getPrice()) ? a : b;
    }


    public static void main(String s[]) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        Book[] books = new Book[10];

        int bkIdx = 0;

        while(true) {

            System.out.println("Press 1 to view books, 2 to add books, 3 comparar precios, any other key to exit");

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {

                for(int i=0;i<books.length;i++) {

                    if(books[i] != null) {

                        System.out.println(books[i]);

                    }

                }

            } else if (userAction.equals("2")) {

                if(bkIdx == 10) {

                    System.out.println("10 books added already. Cannot add any more books!");

                    continue;

                }

                System.out.println("Enter book title");

                String tmpTitle = scanner.nextLine();

                System.out.println("Enter book author");

                String tmpAuthor = scanner.nextLine();

                System.out.println("Enter book price");

                float tmpPrice = Float.parseFloat(scanner.nextLine());

                Book bkTmp = new Book();

                bkTmp.setTitle(tmpTitle);

                bkTmp.setAuthor(tmpAuthor);

                bkTmp.setPrice(tmpPrice);

                books[bkIdx++] = bkTmp;

            }else if (userAction.equals("3")) {
                if(bkIdx < 2) {
                    System.out.println("Al menos 2 libros para comparar precios");
                    continue;
                }

                System.out.println("Ingrese índice del 1er libro:");
                int idx1 = Integer.parseInt(scanner.nextLine());

                System.out.println("Ingrese índice del 2do libro:");
                int idx2 = Integer.parseInt(scanner.nextLine());

                // Validar índices
                if (idx1 < 0 || idx1 >= bkIdx || idx2 < 0 || idx2 >= bkIdx) {
                    System.out.println("Índices inválidos");
                    continue;
                }

            Book moreExpensive = moreExpensiveBook(books[idx1], books[idx2]);

            if (moreExpensive != null) {
                System.out.println("El libro más caro es: " + moreExpensive);
            }
        }
        else {
                break;
            }

        }

    }

}

