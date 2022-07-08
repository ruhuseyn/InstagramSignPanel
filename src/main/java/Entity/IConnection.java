package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IConnection {

    private static Connection connection = null;
    public static Connection getConnection() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","root","12345");
            System.out.println("Already connect !");

        return connection;
    }
    public static void getClose() throws Exception{
        connection.close();
        System.out.println("Already closed !");
    }
}
