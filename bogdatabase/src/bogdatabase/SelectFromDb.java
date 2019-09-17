
package bogdatabase;


import bogdatabase.MySQLJDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nbh
 */




public class SelectFromDb {
 
    /**
     * Update candidate demo
     */
    public static String selectPersonByFirstName(String name) {
 
        String res = "ingen resultater"; 
        
        String sql = "select * from UdlaanTirsdag.laaneoversigt " 
                
                + " WHERE navn = ?";
 
        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
        
         
           pstmt.setString(1, name);
                   
          
 
               ResultSet resultSet = pstmt.executeQuery();

                
               
               if(resultSet.wasNull() ) {
               
                   return res;
               }
                   
               res="";
               
               while (resultSet.next()) {
                
                   res = res + " " + resultSet.getString("navn") + 
                           " " + resultSet.getString("forfatter") +
                           " " + resultSet.getString("title");
            }
            
               
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
}



