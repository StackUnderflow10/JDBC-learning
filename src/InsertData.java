import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "0R4cl34321_";

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connected successfully");

            String query = "INSERT INTO teachers (name,subject,salary) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"HC verma");
            ps.setString(2,"AI");
            ps.setInt(3,90000);

            ps.executeUpdate();
            System.out.println("data inserted");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
