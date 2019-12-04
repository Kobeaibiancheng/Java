package operation;

import book.Book;
import book.BookList;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        System.out.println("请输入要查找的书籍");
        String name = scan.next();
        Book book = null;
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有要查找的书籍");
    }
}