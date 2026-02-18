import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "0R4cl34321_";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO teachers(name,subject,salary) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            while (true){
                System.out.println("Enter name");
                String name = sc.next();
                System.out.println("Enter subject");
                String subject = sc.next();
                System.out.println("Enter salary");
                int salary = sc.nextInt();
                System.out.println("Enter more data(Y/N)");
                String choice  = sc.next();
                ps.setString(1,name);
                ps.setString(2,subject);
                ps.setInt(3,salary);

                ps.addBatch();
                if(choice.toUpperCase().equals("N")) break;
            }
            int[] arr = ps.executeBatch();

            for(int i = 0; i < arr.length ; i++){
                if(arr[i] == 0) System.out.println("Query: "+ i + "not executed successfully");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
