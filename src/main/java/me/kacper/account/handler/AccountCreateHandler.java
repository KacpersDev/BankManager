package me.kacper.account.handler;

import lombok.Getter;
import me.kacper.account.AccountCreate;
import me.kacper.account.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


@Getter
public class AccountCreateHandler implements AccountCreate {

    private String accountName;
    private String passwordName;
    private int pinValue;

    @Override
    public String name() {
        return accountName;
    }

    @Override
    public String password() {
        return passwordName;
    }

    @Override
    public int pin() {
        return pinValue;
    }

    @Override
    public void onCreation() throws IOException {

        Scanner scanner = new Scanner(System.in);
        Message.accountMessage("Please enter name of account.");
        accountName = scanner.nextLine();

        Scanner pscanner = new Scanner(System.in);
        Message.accountMessage("Please enter password of account.");
        passwordName = pscanner.nextLine();

        Scanner pinScanner = new Scanner(System.in);
        Message.accountMessage("Please enter pin");
        pinValue = Integer.parseInt(pinScanner.nextLine());

        File file = new File("data.txt");

        FileWriter writer = new FileWriter(file);

        writer.write("Username-" + name());
        writer.write("Username-" + name() + "-" + password());
        writer.write("Username-" + name() + "-" + pin());
        writer.close();

        Message.accountMessage("Thank you for creating an account you can now log in.");

    }
}
