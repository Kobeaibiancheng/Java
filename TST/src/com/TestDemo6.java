package com;

/**
 * 1.implements Cloneable
 * 2.重写Object clone()
 * 3.如果当前类包含了引用类型
 *   Person->Money
 *   在Person 的clone方法内，不仅要克隆自己本身
 *   还要克隆Money
 */
class Money implements Cloneable{
    public double money = 66.6;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    public int age;
    public Money m;
    public Person(String name,int age) {
        this.name = name;
        this.m = new Money();
        this.age = age;
        try {
            if (this.age < 0 || this.age > 200) {
                throw new NoAgeException("年龄值非法");
            }
        }catch (NoAgeException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }

    public void study() {
        System.out.println("study");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person per = (Person)super.clone();
        per.m = (Money)this.m.clone();
        return per;
    }
}
//自定义异常类
class NoAgeException extends Exception {
    public NoAgeException() {

    }
    public NoAgeException(String s) {
        super(s);
    }
}
class TestDome6 {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person person = new Person("李四",-1);




        Person person1 = new Person("zhangsan",20);
        System.out.println(person1.m.money);
        Person person2 = (Person)person1.clone();
        person2.m.money = 99;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
    }
}

