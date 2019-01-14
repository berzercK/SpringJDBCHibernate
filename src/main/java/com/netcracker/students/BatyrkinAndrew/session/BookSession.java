package com.netcracker.students.BatyrkinAndrew.session;

import com.netcracker.students.BatyrkinAndrew.config.SpringConfig;
import com.netcracker.students.BatyrkinAndrew.dao.bookDAO.IBookDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class BookSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IBookDAO service = (IBookDAO) context.getBean("bookDAO");

    public static void deleteBookById(int idBook) {
        System.out.println("BookSession.deleteBookById");
        service.deleteBookById(idBook);
    }

    public static Book updateBook(int idBook, String name, int price, String region, int qty) {
        System.out.println("BookSession.updateBook");
        service.updateBook(idBook, name, price, region, qty);
        return findBookById(idBook);
    }

    public static Book addBook(Book entity) {
        System.out.println("BookSession.addBook");
        service.saveBook(entity);
        return entity;
    }

    public static void findAllBooks() {
        System.out.println("BookSession.findAllBooks:");
        System.out.println(service.findAllBooks());
    }

    public static void numberOfRow() {
        System.out.println("BookSession.numberOfRow:");
        System.out.println(service.numberOfRow());
    }

    public static Book findBookById(int idBook) {
        System.out.println("BookSession.findBookById:");
        System.out.println(service.findBookById(idBook));
        return service.findBookById(idBook);
    }

    public static void task2a() {
        System.out.println("BookSession.task2a");
        System.out.println(service.task2a());
    }

    public static void task3c(String name, double price) {
        System.out.println("BookSession.task3c");
        List<Book> list = service.task3c(name, price);
        System.out.println(list);
    }

}
