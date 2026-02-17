import java.sql.DriverManager;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "0R4cl34321_";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected Successfully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");

            while(rs.next()){
                System.out.println(
                        rs.getInt("id") + "" + rs.getString("name") + " " + rs.getString("subject") + " " + rs.getInt("salary")
                );
            }
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}