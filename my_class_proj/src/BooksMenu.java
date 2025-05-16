import java.util.Scanner;

public class BooksMenu {

    private static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice() < book2.getPrice()) {
            return book2;
        } else {
            return book1;
        }
    }

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;

        while (true) {
            System.out.println(
                    "Press 1 to view books,\n" +
                            "2 to add books,\n" +
                            "3 to compare books,\n" +
                            "4 to change the price,\n" +
                            "Any other key to exit");

            String userAction = scanner.nextLine();

            //Ver todos los libros
            if (userAction.equals("1")) {
                for (int i = 0; i < books.length; i++) {
                    if (books[i] != null) {
                        System.out.println("Index [" + i + "]\n" + books[i] + "\n");
                    }
                }

                // Agregar libros nuevo/clonar
            } else if (userAction.equals("2")) {
                if (bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }

                System.out.println("Press 1 to create a new book, 2 to clone an existing book:");
                String subOption = scanner.nextLine();

                // Crear libro nuevo
                if (subOption.equals("1")) {
                    System.out.println("Which constructor do you want to use? Press 1 for default, any other key for overloaded constructor");
                    String constructor = scanner.nextLine();

                    System.out.println("Enter book title");
                    String tmpTitle = scanner.nextLine();

                    System.out.println("Enter book author");
                    String tmpAuthor = scanner.nextLine();

                    System.out.println("Enter book price");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());

                    if (constructor.equals("1")) {
                        Book bkTmp = new Book();
                        bkTmp.setTitle(tmpTitle);
                        bkTmp.setAuthor(tmpAuthor);
                        bkTmp.setPrice(tmpPrice);
                        books[bkIdx++] = bkTmp;
                    } else {
                        books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                    }

                    //Clonar libro existente
                } else if (subOption.equals("2")) {
                    if (bkIdx == 0) {
                        System.out.println("No books to clone yet.");
                        continue;
                    }

                    System.out.println("Enter index of the book to clone:");
                    int cloneIdx = Integer.parseInt(scanner.nextLine());

                    if (cloneIdx < 0 || cloneIdx >= bkIdx || books[cloneIdx] == null) {
                        System.out.println("Invalid index.");
                        continue;
                    }

                    try {
                        Book clonedBook = (Book) books[cloneIdx].clone();
                        books[bkIdx++] = clonedBook;
                        System.out.println("Book cloned successfully.");
                    } catch (CloneNotSupportedException e) {
                        System.out.println("Error cloning the book.");
                    }
                } else {
                    System.out.println("Invalid option.");
                }

                //Comparar ibros
            } else if (userAction.equals("3")) {
            //comparar si dos libros son iguales
            System.out.println("Insert the first book title:");
            int idx1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Insert the second book title:");
            int idx2 = Integer.parseInt(scanner.nextLine());

            if (idx1 < 0 || idx1 >= bkIdx || books[idx1] == null ||
                    idx2 < 0 || idx2 >= bkIdx || books[idx2] == null) {
                System.out.println("Índices inválidos o libros no existen.");
                continue;
            }

            boolean iguales = books[idx1].equals(books[idx2]);

            if (iguales) {
                System.out.println("Books are equals.");
            } else {
                System.out.println("Books aret not equals");
            }

            //Cambiar precio
            } else if (userAction.equals("4")) {
                System.out.println("Insert the index for change the price");
                int index = Integer.parseInt(scanner.nextLine());

                //Validar indice
                if(index < 0 || index >= bkIdx || books[index] == null) {
                    System.out.println("Invalid index");
                    continue;
                }

                System.out.println("Insert the new price of the book");
                float newPrice = Float.parseFloat(scanner.nextLine());

                books[index].setPrice(newPrice);

                System.out.println("PRICE CHANGE SUCCESSFULLY");
            } else {
                break;
            }
        }
    }
}
