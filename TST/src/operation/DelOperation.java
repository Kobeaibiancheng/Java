package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("请输入要删除的书籍的书名");
        String name = scan.next();
        Book book = null;
        int i = 0;
        for (i = 0; i < bookList.getUsedSize(); i++) {
            book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                break;
            }
        }
        if(i == bookList.getUsedSize()) {
            System.out.println("没有要删除的书籍");
        }
        else {
            //删除书籍
            for (int j = i; j < bookList.getUsedSize()-1; j++) {
                book = bookList.getBook(j+1);
                bookList.setBooks(j,book);
            }
            bookList.setUsedSize(bookList.getUsedSize()-1);
            System.out.println("删除成功");
        }

    }


}