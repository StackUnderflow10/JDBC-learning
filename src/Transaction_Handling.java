import java.sql.*;
import java.util.Scanner;

public class Transaction_Handling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/transaction";
        String username = "root";
        String password = "0R4cl34321_";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            con.setAutoCommit(false);
            System.out.println("connected successfully");

            String debitQuery = "UPDATE accounts SET balance = balance- ? WHERE account_number = ?";
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

            PreparedStatement ps_debit = con.prepareStatement(debitQuery);
            PreparedStatement ps_credit = con.prepareStatement(creditQuery);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your account number");
            int account_number = sc.nextInt();
            System.out.println("Enter the amount");
            double amount = sc.nextDouble();

            ps_debit.setDouble(1,amount);
            ps_debit.setInt(2,account_number);

            ps_credit.setDouble(1,amount);
            ps_credit.setInt(2,102);

            ps_debit.executeUpdate();
            ps_credit.executeUpdate();

            if(isSufficent(con,account_number, amount)){
                con.commit();
                System.out.println("Transaction successfull");
            }else {
                con.rollback();
                System.out.println("Insufficient balance, transaction failed");
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
    static boolean isSufficent(Connection con, int account_number, double amount){
        try{
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,account_number);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                double cuurent_balance = rs.getDouble("balance");
                if(amount > cuurent_balance) return false;
                else return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
