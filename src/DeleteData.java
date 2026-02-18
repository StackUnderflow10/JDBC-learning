import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "0R4cl34321_";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connected");

            String deleteQuery = "DELETE FROM teachers WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(deleteQuery);

            ps.setString(1,"kakoli");

            ps.executeUpdate();
            System.out.println("successfully deleted");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
