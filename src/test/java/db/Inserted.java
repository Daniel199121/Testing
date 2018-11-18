package db;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserted {

    public void insertValue(Date DATA, String EURO, String FRANK, String DOLAR, String FUNT) {
        
        ResultSet rs = null;
        
        String sql = "INSERT INTO mydb.table (DATA,EURO,FRANK,DOLAR,FUNT) "
                   + "VALUES(?,?,?,?,?)";
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            
		            pstmt.setDate(1, DATA);
		            pstmt.setString(2, EURO);
		            pstmt.setString(3, FRANK);
		            pstmt.setString(4, DOLAR);
		            pstmt.setString(5, FUNT);
	 
		            int rowAffected = pstmt.executeUpdate();
		            if(rowAffected == 1)
		            {
		                rs = pstmt.getGeneratedKeys();
		            }
	        } catch (SQLException ex) {
	            	System.out.println(ex.getMessage());
	        } finally {
	            try {
	                	if(rs != null)  rs.close();
	            } 	catch (SQLException e) {
	                	System.out.println(e.getMessage());
	            }
	        }   
	   }

    public int getID() {

	ResultSet rs = null;
	int Id = 0;
	
	String sql = "select * from mydb.table";
	
	try (Connection conn = MySQLJDBCUtil.getConnection();
			Statement stmt=conn.createStatement();
			) {
		
				rs=stmt.executeQuery(sql);  
				while(rs.next()) {
						Id = rs.getInt(1);
					}
				} 	catch (SQLException ex) {
						System.out.println(ex.getMessage());
				} finally {
					try {
						if(rs != null)  
								rs.close();
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
				}
					return Id;
			    }
}