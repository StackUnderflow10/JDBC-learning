import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "0R4cl34321_";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connected successfully");

            String updateQuery = "UPDATE teachers SET salary = ? WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(updateQuery);

            ps.setInt(1,110000);
            ps.setString(2,"Kallol");

            ps.executeUpdate();
            System.out.println("Updated successfully");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
