package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        System.out.println("请输入借阅书籍的书名");
        String name = scan.next();
        int i = 0;
        Book book = null;
        for (i = 0; i < bookList.getUsedSize(); i++) {
            book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                break;
            }
        }

        if(i == bookList.getUsedSize()) {
            System.out.println("没有这本书籍");
            return;
        }
        book = bookList.getBook(i);
        if(book.isBorrowed()) {
            System.out.println("该书已被借出");
        }
        else {
            book.setBorrowed(true);
            System.out.println("借阅书籍成功");
        }
    }
}
