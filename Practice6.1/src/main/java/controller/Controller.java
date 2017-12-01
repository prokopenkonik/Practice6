package controller;

import model.Book;
import model.Bookshelf;
import view.Viewer;
import java.util.Scanner;

public class Controller {
    private Viewer view;
    private Bookshelf bookshelf;

    public Controller(Viewer view, Bookshelf bookshelf) {
        this.view = view;
        this.bookshelf = bookshelf;
    }

    public void run() {
        int commandNum;
        Scanner in = new Scanner(System.in);
        String data = "";
        Book[] books;
        while (true) {
            view.printMenu();

            if (in.hasNext()) {
                commandNum = in.nextInt();
                in.nextLine();
            } else {
                continue;
            }

            if (commandNum == 0) {
                break;
            }

            if (commandNum >= 1 && commandNum <= 4) {
                if (commandNum == 4) {
                    books = bookshelf.getSortedBooks();
                }
                else {
                    view.printMessage();
                    if (in.hasNext()) {
                        data = in.nextLine();
                    }
                    books = bookshelf.getBooks(data, commandNum);
                }
                view.printResult(books);
                continue;
            }

            if (commandNum == 5) {
                bookshelf.save();
            }

            view.printError();
        }
    }
}
