package com.netcracker.students.BatyrkinAndrew.dao.bookDAO;

import com.netcracker.students.BatyrkinAndrew.dao.BasicDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BasicDAO implements IBookDAO {


    @Override
    public void deleteBookById(int idBook) throws HibernateException {
        Book entity = (Book) getSession().get(Book.class, idBook);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void updateBook(int idBook, String name, int price, String region, int qty) {
        Book updatedBook = (Book) getSession().get(Book.class, idBook);
        if (updatedBook != null) {
            if (!name.equals(""))
                updatedBook.setName(name);
            if (price != -1)
                updatedBook.setPrice(price);
            if (!region.equals(""))
                updatedBook.setRegion(region);
            if (qty != -1)
                updatedBook.setQty(qty);
        }
    }

    @Override
    public void saveBook(Book entity) {
        getSession().persist(entity);
    }

    @Override
    public List<Book> findAllBooks() {
        return getSession().createCriteria(Book.class).list();
    }

    @Override
    public long numberOfRow() {
        return (long) getSession().createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Book findBookById(int idBook) {
        return (Book) getSession().get(Book.class, idBook);
    }

    @Override
    public List<Book> task2a() {
        SQLQuery query = getSession().createSQLQuery("select  distinct name, price from Books");
        List<Book> list = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    @Override
    public List<Book> task3c(String aname, double price) {
        SQLQuery query = getSession().createSQLQuery("select name, price from Books where name like :searchKey1 or price > :searchKey2 order by price desc");
        query.setParameter("searchKey1", "%" + aname + "%");
        query.setParameter("searchKey2", price);
        List<Book> list = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
}
