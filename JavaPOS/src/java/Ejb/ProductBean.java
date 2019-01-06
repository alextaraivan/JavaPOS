/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.ProductDetails;
import entity.Productcatalog;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Romelia Milascon
 */
@Stateless
public class ProductBean {

    @PersistenceContext(unitName = "JavaPOSPU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<ProductDetails> getAllProducts() {
        LOG.info("getAllProducts");
        
        try {
            List<Productcatalog> products = (List<Productcatalog>) em.createNamedQuery("Productcatalog.findAll").getResultList();
            return copyProductsToDetails(products);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
     private List<ProductDetails> copyProductsToDetails(List<Productcatalog> products) {
        List<ProductDetails> detailsList = new ArrayList<>();
        for (Productcatalog product : products) {
            ProductDetails productDetails = new ProductDetails(product.getProdid(),
               product.getProdname());
            detailsList.add(productDetails);
        }
        return detailsList;
    }
   
    
}
