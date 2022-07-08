package Main;

import Entity.IConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LogIn {


    public static void login() throws Exception{

        Connection connection = IConnection.getConnection();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone number,username or email :");
        String username = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Enter password : ");
        String password = sc.nextLine();

        String query = "SELECT * FROM user WHERE username = '"+username+"' and password  = '"+password+"'";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString(4);
            String surname = resultSet.getString(5);
            String fatherName= resultSet.getString(6);
            int age = resultSet.getInt(7);
            String gender = resultSet.getString(8);
            String country = resultSet.getString(9);

            System.out.println(name+ " " +surname+" "+fatherName+" "+age+" "+gender+" "+country);

        }

        String query1 = "SELECT * FROM user WHERE username = '"+username+"' and !password  = '"+password+"'";
        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        System.out.println("Password is incorrect ! \n" +
                "Did you forgot your password? --> Refresh your Password !");

        sc = new Scanner(System.in);
        System.out.println(" \n Enter your old name : ");
        String yourName = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Enter your old surname :");
        String yourSurname = sc.nextLine();

        String ques = "SELECT * FROM user WHERE  username = '"+username+"' and name = '" + yourName + "' and surname = '"+yourSurname+"'";
        PreparedStatement preparedStatements = connection.prepareStatement(ques);
        ResultSet resultSets = preparedStatements.executeQuery();

        if(resultSets.next()) {
            sc = new Scanner(System.in);
            System.out.println("Enter new password !");
            String newPassword = sc.nextLine();

            String ques1 = "UPDATE user SET password = '"+newPassword+"' WHERE username = '"+username+"'";
            PreparedStatement preparedStatement2 = connection.prepareStatement(ques1);
            preparedStatement2.executeUpdate();

            String ques3 = "SELECT * FROM user WHERE username = '"+username+"' and password  = '"+newPassword+"'";
            PreparedStatement preparedStatement3 = connection.prepareStatement(ques3);
            ResultSet resultSet2 = preparedStatement3.executeQuery();
            while(resultSet2.next()){
                String name = resultSet2.getString(4);
                String surname = resultSet2.getString(5);
                String fatherName= resultSet2.getString(6);
                int age = resultSet2.getInt(7);
                String gender = resultSet2.getString(8);
                String country = resultSet2.getString(9);

                System.out.println(name+ " " +surname+" "+fatherName+" "+age+" "+gender+" "+country);
            }


        }





    }
}
