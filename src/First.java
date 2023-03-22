import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class First  {

    public static void main(String []args) {
        try {
            //Loading driver
            Class.forName("oracle.jdbc.OracleDriver");

            //creating connection
            Connection con = DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:XE", "dream", "dream");

            Statement s = con.createStatement();      //creating statement

            ResultSet rs = s.executeQuery("select * from staff");   //executing statement

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            con.close();    //closing connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

