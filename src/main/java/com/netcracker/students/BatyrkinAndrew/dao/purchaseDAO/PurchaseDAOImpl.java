package com.netcracker.students.BatyrkinAndrew.dao.purchaseDAO;

import com.netcracker.students.BatyrkinAndrew.dao.BasicDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Book;
import com.netcracker.students.BatyrkinAndrew.entity.Buyer;
import com.netcracker.students.BatyrkinAndrew.entity.Purchase;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BasicDAO implements IPurchaseDAO {

    @Override
    public void deletePurchaseById(int idPurchase) {
        Purchase entity = (Purchase) getSession().get(Purchase.class, idPurchase);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void updatePurchase(int idPurchase, Date date, Shop shop, Buyer buyer, Book book, int qty, double total) {
        Purchase updatedPurchase = (Purchase) getSession().get(Purchase.class, idPurchase);
        if (updatedPurchase != null) {
            if (date.getTime() != -1)
                updatedPurchase.setDate(date);
            if (shop != null)
                updatedPurchase.setShop(shop);
            if (buyer != null)
                updatedPurchase.setBuyer(buyer);
            if (book != null)
                updatedPurchase.setBook(book);
            if (qty != -1)
                updatedPurchase.setQty(qty);
            if (total != -1)
                updatedPurchase.setTotal(total);
        }
    }

    @Override
    public void savePurchase(Purchase entity) {
        getSession().persist(entity);
    }

    @Override
    public List<Purchase> findAllPurchase() {
        return getSession().createCriteria(Purchase.class).list();
    }

    public long numberOfRow() {
        return (long) getSession().createCriteria(Purchase.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Purchase findPurchaseById(int idPurchase) {
        return (Purchase) getSession().get(Purchase.class, idPurchase);
    }

    @Override
    public List<Purchase> task2c() {
        SQLQuery query = getSession().createSQLQuery("SELECT distinct DATE_FORMAT(date,'%m-%Y') AS dateColumn FROM purchase");
        List<Purchase> list = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    @Override
    public List<Purchase> task4a() {
        SQLQuery query = getSession().createSQLQuery("SELECT buyers.name as BuyerFamily, shop.name as ShopName FROM purchase\n" +
                "left join buyers on (buyers.id_buyer=purchase.buyer)\n" +
                "left join shop on (shop.id_shop = purchase.shop)");
        List<Purchase> list = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    @Override
    public List<Purchase> task4b() {
        SQLQuery query = getSession().createSQLQuery("SELECT purchase.date as Date, buyers.name as BuyerFamily, buyers.sale as BuyerSale, books.name as BookName, purchase.qty as CountBooks FROM purchase \n" +
                "left join buyers on (buyers.id_buyer=purchase.buyer)\n" +
                "left join books on (books.id_book = purchase.shop);");
        List<Purchase> list = query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    @Override
    public List<Purchase> task5a(double total) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.ge("total", total));
        return criteria.list();
    }

    @Override
    public List<Purchase> task5b(int month) {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-" + month + "-01", new ParsePosition(0));
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.ge("date", date));
        System.out.println(criteria.list());
        criteria.createAlias("buyer", "b")
                .createAlias("shop", "s")
                .add(Restrictions.eqProperty("b.region", "s.region"))
                .addOrder(Order.desc("b.region"));
        return criteria.list();
    }

    @Override
    public List<Purchase> task5c(String region, double fromDiscount, double toDiscount) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.createAlias("buyer", "b")
                .createAlias("shop", "s")
                .add(Restrictions.between("b.sale", fromDiscount, toDiscount))
                .add(Restrictions.not(Restrictions.eq("s.region", region)));
        return criteria.list();
    }

    @Override
    public List<Purchase> task5d() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.createAlias("shop", "s").createAlias("book", "b")
                .add(Restrictions.eqProperty("s.region", "b.region"))
                .add(Restrictions.ge("b.qty", 10))
                .addOrder(Order.asc("b.price"));
        return criteria.list();
    }

}
