/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosClasses;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.jms.Connection;
import javax.resource.cci.ResultSet;

/**
 *
 * @author Romelia Milascon
 */
public class ValidateLogin {
    
    public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
//      try{
//
//	 //loading drivers for mysql
//         Class.forName("com.mysql.jdbc.Driver");
//
// 	 //creating connection with the database 
//       Connection con=DriverManager.getConnection ("jdbc:mysql:/ /localhost:3306/test","root","studytonight");
//         PreparedStatement ps =con.prepareStatement
//                             ("select * from register where email=? and pass=?");
//         ps.setString(1, email);
//         ps.setString(2, pass);
//         ResultSet rs =ps.executeQuery();
//         st = rs.next();
//        
//      }catch(Exception e)
//      {
//          e.printStackTrace();
//      }
         return st;                 
  }   
}
