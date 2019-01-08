/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.SaleDetails;
import entity.Sale;
import entity.Store;
import entity.User1;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Romelia Milascon
 */
@Stateless
public class SaleBean {

    private static final Logger LOG = Logger.getLogger(SaleBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public List<SaleDetails> getAllSales() {
        LOG.info("getAllSales");
        
        try {
            Query query = em.createQuery("SELECT s FROM Sale s");
            List<Sale> sales = (List<Sale>) query.getResultList();
            return copySalesToDetails(sales);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<SaleDetails> copySalesToDetails(List<Sale> sales) {
        List<SaleDetails> detailsList = new ArrayList<>();
        for (Sale sale : sales) {
            SaleDetails saleDetails = new SaleDetails(sale.getId(),
                sale.getSaleDate(),
                sale.getSaleTime(),
                sale.getCashier().getUsername(),
                sale.getStore().getName(),
                sale.getPaymentAmount());
            detailsList.add(saleDetails);
        }
        return detailsList;
    }
    
    public void createSale(LocalDate saleDate,  LocalTime saleTime, Integer cashierId, Integer storeId, Double paymentAmount) {
        LOG.info("createSale");
        Sale sale = new Sale();
        sale.setSaleDate(saleDate);
        sale.setSaleTime(saleTime);
        
        User1 user = em.find(User1.class, cashierId);
        user.getSales().add(sale);
        sale.setCashier(user);
        
        Store store = em.find(Store.class, storeId);
        store.getSales().add(sale);
        sale.setStore(store);
        
        sale.setPaymentAmount(paymentAmount);
        
        em.persist(sale);
    }
    
}
