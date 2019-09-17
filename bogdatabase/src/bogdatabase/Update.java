/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bogdatabase;


import bogdatabase.MySQLJDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class Update {
 
    /**
     * Update candidate demo
     */
    public static void UpdateLastName( int laanerId, String name) {
 
        String sql = "UPDATE laaner "
                + "SET navn  = ? "
                + "WHERE idlaaner = ?";
 
        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // prepare data for update
            
            
            pstmt.setString(1, name);
            pstmt.setInt(2, laanerId);
 
            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
