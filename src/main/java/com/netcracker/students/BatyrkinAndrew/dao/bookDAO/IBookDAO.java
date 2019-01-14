package com.netcracker.students.BatyrkinAndrew.dao.bookDAO;

import com.netcracker.students.BatyrkinAndrew.entity.Book;

import java.util.List;

public interface IBookDAO {

    void deleteBookById(int idBook);

    void updateBook(int idBook, String name, int price, String region, int qty);

    void saveBook(Book entity);

    List<Book> findAllBooks();

    long numberOfRow();

    Book findBookById(int idBook);

    List<Book> task2a();

    List<Book> task3c(String name, double price);
}
