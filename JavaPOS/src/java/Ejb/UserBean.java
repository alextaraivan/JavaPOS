/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.UserDetails;
import entity.User1;
import java.util.ArrayList;
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
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

   @PersistenceContext
   private EntityManager em;
 
    public void createUser(String username, String email, String passwordSha256, String position) {
        User1 user = new User1();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordSha256);
        user.setPosition(position);
        
        em.persist(user);
    }
    
    public List<User1> findUser(String username,String password)
    {
        Query userQuery=em.createNamedQuery("User1.findByNameAndPass");
        userQuery.setParameter("username",username);
        userQuery.setParameter("password",password);
        return userQuery.getResultList();
    }
    public List<UserDetails> getAllUsers() {
        LOG.info("getAllUsers");
        
        try {
            Query query = em.createQuery("SELECT u FROM User1 u");
            List<User1> users = (List<User1>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<UserDetails> copyUsersToDetails(List<User1> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User1 user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPosition(),
                user.getPassword());
            detailsList.add(userDetails);
        }
        return detailsList;
    }
   
}
