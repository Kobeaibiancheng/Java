package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入要归还书籍的书名");
        String name = scan.next();
        //查找书籍是否存在
        Book book = null;
        int i = 0;
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
            book.setBorrowed(false);
            System.out.println("归还图书成功");
        }
        else {
            System.out.println("该书未被借出");
        }
    }
}
