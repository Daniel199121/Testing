    import java.sql.*;  
    class MysqlCon{  
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection con=DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Testowanie4u!");  

    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from mydb.table");  
    System.out.println("ID\tDATA\t\tEUR\tFRANK\tDOLAR\tFUNT");
    while(rs.next())  
    System.out.println(rs.getInt(1)+"\t"+rs.getDate(2)+"\t"+rs.getDouble(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6));  
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    }  