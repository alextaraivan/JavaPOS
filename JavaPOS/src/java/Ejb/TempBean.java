/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.TempDetails;
import entity.Temp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Romelia Milascon
 */
@Stateless
public class TempBean {

    private static final Logger LOG = Logger.getLogger(TempBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public void createTemp(String prodName, String description, Double price, Integer quantity) {
        Temp productTemp = new Temp();
        productTemp.setProdName(prodName);
        productTemp.setDescription(description);
        productTemp.setPrice(price);
        productTemp.setQuantity(quantity);
        
        em.persist(productTemp);
    }
    
     public void updateTemp(Integer id,Integer quantity) {
        LOG.info("updateTemporar");
        Temp temporar = em.find(Temp.class, id);
        temporar.setQuantity(quantity);
        
    }
    
    public void deleteTemporarsByIds(Collection<Integer> ids) {
        LOG.info("deleteTemporarsByIds");
        for (Integer id : ids) {
            Temp temp = em.find(Temp.class, id);
            em.remove(temp);
        }
    }
    
    public List<TempDetails> getAllTemporars() {
        LOG.info("getAllTemporars");
        
        try {
            Query query = em.createQuery("SELECT t FROM Temp t");
            List<Temp> temp = (List<Temp>) query.getResultList();
            return copyTempToDetails(temp);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public Double getTotal()
    {
         LOG.info("getPriceSum");
         
          try {
            Query query = em.createQuery("SELECT sum(t.price*t.quantity) FROM Temp t");
            Double sum = (Double) query.getSingleResult();
            return sum;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    private List<TempDetails> copyTempToDetails(List<Temp> temp) {
        List<TempDetails> detailsList = new ArrayList<>();
        for (Temp tp : temp) {
            TempDetails tempDetails = new TempDetails(tp.getId(),
                tp.getProdName(),
                tp.getDescription(),
                tp.getPrice(),
                tp.getQuantity());
            detailsList.add(tempDetails);
        }
        return detailsList;
    }
    
    public TempDetails findById(Integer tempId) {
        Temp temp = em.find(Temp.class, tempId);
        return new TempDetails(temp.getId(),
                temp.getProdName(),
                temp.getDescription(),
                temp.getPrice(),
                temp.getQuantity()); }
    
    public TempDetails findByName(String productName) {
        
         LOG.info("getTempProdByName");
         try{
        Query query = em.createQuery("SELECT t FROM Temp t WHERE t.prodName = :productName")
                .setParameter("productName", productName)
                .setMaxResults(1);
        Temp temp = (Temp) query.getSingleResult();
        return new TempDetails(temp.getId(), temp.getProdName(),temp.getDescription(),temp.getPrice(),temp.getQuantity());
         }catch(NoResultException ex)
         {
             return null;
         }
    }
    
    public void deleteRecords()
    {
        LOG.info("deleteRecords");
        Query del=em.createQuery("DELETE FROM Temp t");
        del.executeUpdate();
    }
}
