package Main;

import Entity.IConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SignUp {

    public static void signUp() throws Exception {
        Connection connection = IConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone number,username or email :");
        String username = sc.nextLine();

        String ques = "SELECT * FROM user WHERE username = '" + username + "'";
        PreparedStatement preparedStatements = connection.prepareStatement(ques);
        ResultSet resultSets = preparedStatements.executeQuery();

        if(resultSets.next()) {
            System.err.println("Username already used");
        }
        else{
            sc = new Scanner(System.in);
            System.out.println("Enter password : ");
            String password = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.println("Enter your name : ");
            String name = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.println("Enter your surname : ");
            String surname = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.println("Enter your father name : ");
            String fatherName = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.println("Enter your age : ");
            int age = sc.nextInt();
            sc = new Scanner(System.in);
            System.out.println("Enter your gender : ");
            String gender = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.println("Enter your country : ");
            String country = sc.nextLine();

            String query = "INSERT INTO user(username,password,name,surname,father_name,age,gender,country) VALUES(?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.setString(5, fatherName);
            preparedStatement.setInt(6, age);
            preparedStatement.setString(7, gender);
            preparedStatement.setString(8, country);
            preparedStatement.execute();

            System.out.println("\n The operation is successful");
            IConnection.getClose();
        }
    }
}
