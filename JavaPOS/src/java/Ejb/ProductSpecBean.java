/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.ProductSpecDetails;
import entity.Product;
import entity.ProductSpec;
import java.util.ArrayList;
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
public class ProductSpecBean {

    private static final Logger LOG = Logger.getLogger(ProductSpecBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void createProductSpecification(String description, Double price, Integer unitInStock, Integer productId, String barcode) {
        ProductSpec productSpec = new ProductSpec();
        productSpec.setDescription(description);
        productSpec.setPrice(price);
        productSpec.setUnitInStock(unitInStock);
        
        Product product = em.find(Product.class, productId);
        product.setProductSpec(productSpec);
        productSpec.setProduct(product);
        
        productSpec.setBarcode(barcode);
        
        em.persist(productSpec);
    }
    
    public void updateProductSpecification(Integer id, Integer unitInStock) {
        LOG.info("updateProductSpecQuantity");
        ProductSpec productSpec = em.find(ProductSpec.class, id);
        productSpec.setUnitInStock(unitInStock);
   
    }
      
    public List<ProductSpecDetails> getAllProductSpecs() {
        LOG.info("getAllProductSpecifications");
        
        try {
            Query query = em.createQuery("SELECT ps FROM ProductSpec ps");
            List<ProductSpec> productSpec = (List<ProductSpec>) query.getResultList();
            return copyProductSpecsToDetails(productSpec);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<ProductSpecDetails> copyProductSpecsToDetails(List<ProductSpec> productSpecs) {
        List<ProductSpecDetails> detailsList = new ArrayList<>();
        for (ProductSpec productSpec : productSpecs) {
            ProductSpecDetails productSpecDetails = new ProductSpecDetails(productSpec.getId(),
                productSpec.getDescription(),
                productSpec.getPrice(),
                productSpec.getUnitInStock(),
                productSpec.getProduct().getProdName(),
                productSpec.getBarcode());
            detailsList.add(productSpecDetails);
        }
        return detailsList;
    }
    
    public ProductSpecDetails findById(Integer productSpecId) {
        ProductSpec productSpec = em.find(ProductSpec.class, productSpecId);
        return new ProductSpecDetails(productSpec.getId(),
                productSpec.getDescription(),
                productSpec.getPrice(),
                productSpec.getUnitInStock(),
                productSpec.getProduct().getProdName(),
                productSpec.getBarcode());
    }
    
    public ProductSpecDetails findByProdName(String productName) {
         Query query = em.createQuery("SELECT ps FROM ProductSpec ps WHERE ps.product = (SELECT p FROM Product p WHERE p.prodName = :productName)")
                .setParameter("productName", productName)
                .setMaxResults(1);
        ProductSpec productSpec = (ProductSpec) query.getSingleResult();
        return new ProductSpecDetails(productSpec.getId(),
                productSpec.getDescription(),
                productSpec.getPrice(),
                productSpec.getUnitInStock(),
                productSpec.getProduct().getProdName(),
                productSpec.getBarcode());
    }
    public ProductSpecDetails findByBarcode(String barcode) {
        try{
        Query query = em.createQuery("SELECT ps FROM ProductSpec ps WHERE ps.barcode = :barcode")
                .setParameter("barcode", barcode)
                .setMaxResults(1);
        ProductSpec productSpec = (ProductSpec) query.getSingleResult();
        return new ProductSpecDetails(productSpec.getId(),
                productSpec.getDescription(),
                productSpec.getPrice(),
                productSpec.getUnitInStock(),
                productSpec.getProduct().getProdName(),
                productSpec.getBarcode());
        }catch(NoResultException ex)
        {
            return null;
        }
    }
    
}
