package me.kacper.account.handler;

import lombok.Getter;
import me.kacper.account.AccountLogIn;
import me.kacper.account.Message;

import java.io.*;
import java.util.Scanner;

@Getter
public class AccountLoginHandler implements AccountLogIn {

    private String username;
    private String password;
    private int pin;
    private FileReader reader;

    @Override
    public String name() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public int pin() {
        return pin;
    }

    @Override
    public void onLogin() {
        File file = new File("data.txt");
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner user = new Scanner(System.in);
        Message.accountMessage("Please enter username to log in");
        username = user.nextLine();
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String line = bufferedReader.readLine();
            if (line.contains("Username-" + name())) {
                Scanner pass = new Scanner(System.in);
                Message.accountMessage("Please enter password");
                password = pass.nextLine();
                if (line.contains("Username-" + name() + "Username-" + name() + "-" + password())) {
                    Scanner pinScanner = new Scanner(System.in);
                    Message.accountMessage("Please enter pin to log in");
                    pin = Integer.parseInt(pinScanner.nextLine());
                    if (line.contains("Username-" + name() + "Username-" + name() + "-" + password() + "Username-" + name() + "-" + pin())) {
                        System.out.println("Welcome again");
                    } else {
                        System.out.println("pin is wrong");
                    }
                } else {
                    Message.accountMessage(password() + " is wrong password. Please try again!");
                }
            } else {
                Message.accountMessage(name() + " doesn't exist in our database.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
