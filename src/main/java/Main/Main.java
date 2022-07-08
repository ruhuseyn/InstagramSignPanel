package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("Do you have any account? \n ");
        System.out.println("Choose please sign in or login" +
                "\n 1. sign up" +
                "\n 2. login");
        System.out.println("your choice: ");
        int yourChoice = sc.nextInt();

        if(yourChoice == 1){

            SignUp.signUp();

        }else if(yourChoice == 2){

            LogIn.login();

        }else{
            System.err.println("You can choose only 1 or 2 ...");
        }

    }
}
