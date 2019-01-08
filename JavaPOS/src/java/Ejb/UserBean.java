/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import PosClasses.UserDetails;
import entity.User1;
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
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

   @PersistenceContext
   private EntityManager em;
 
    public void createUser(String username, String email,int phone, String password, String position) {
        User1 user = new User1();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
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
    
    public UserDetails findById(Integer userId) {
        User1 user = em.find(User1.class, userId);
        return new UserDetails(user.getId(),user.getUsername(), user.getEmail(), user.getPhone(),user.getPosition(),user.getPassword());
    }
    public Integer findUserID(String name)
    {
        Query  q=em.createNamedQuery("User1.findByUsername");
                q.setParameter("username",name);
        User1 u=(User1) q.getSingleResult();
        
        return u.getId();
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
                user.getPhone(),  
                user.getPosition(),     
                user.getPassword());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    public void updateUser(int userId, String username, String email, int phone, String position) {
        
        LOG.info("updateUser");
        User1 user = em.find(User1.class, userId);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPosition(position);
        
    }
    
     public void deleteUsersByIds(Collection<Integer> ids) {
        LOG.info("deleteUsersByIds");
        for (Integer id : ids) {
            User1 user = em.find(User1.class, id);
            em.remove(user);
        }
    }
   
}
