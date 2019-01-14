package com.netcracker.students.BatyrkinAndrew.dao.shopDAO;

import com.netcracker.students.BatyrkinAndrew.dao.BasicDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import org.hibernate.Criteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BasicDAO implements IShopDAO {

    @Override
    public void deleteShopById(int idShop) {
        Shop entity = (Shop) getSession().get(Shop.class, idShop);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void updateShop(int idShop, String name, String region, double commission) {
        Shop updatedShop = (Shop) getSession().get(Shop.class, idShop);
        if (updatedShop != null) {
            if (!name.equals(""))
                updatedShop.setName(name);
            if (!region.equals(""))
                updatedShop.setRegion(region);
            if (commission != -1)
                updatedShop.setCommission(commission);
        }
    }

    @Override
    public void saveShop(Shop entity) {
        getSession().persist(entity);
    }

    @Override
    public List<Shop> findAllShop() {
        return getSession().createCriteria(Shop.class).list();
    }

    @Override
    public long numberOfRow() {
        return (long) getSession().createCriteria(Shop.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Shop findShopById(int idShop) {
        return (Shop) getSession().get(Shop.class, idShop);
    }

    @Override
    public List<Shop> task3b(String[] regions) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        Junction junction = Restrictions.disjunction();
        for (String region : regions) {
            junction.add(Restrictions.eq("region", region));
        }
        criteria.add(junction);
        return criteria.list();
    }

}
