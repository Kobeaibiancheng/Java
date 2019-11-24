package user;

import book.BookList;
import operation.IOperation;

public abstract class User {
    public String name;
    public IOperation[] operations;
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
        //      对象       .
    }

    //抽象方法
    public abstract int menu();
}
