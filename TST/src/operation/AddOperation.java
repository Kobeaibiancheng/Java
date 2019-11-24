package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入添加书籍的书名");
        String name = scan.next();
        System.out.println("请输入添加书籍的作者");
        String author = scan.next();
        System.out.println("请输入添加书籍的价格");
        int price = scan.nextInt();
        System.out.println("请输入添加书籍的类型");
        String type = scan.next();


        Book book = new Book(name, author, price, type);
        int pos = bookList.getUsedSize();
        bookList.setBooks(pos, book);
        bookList.setUsedSize(pos + 1);
        System.out.println("添加成功");
    }
}
