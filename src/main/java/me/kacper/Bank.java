package me.kacper;

import me.kacper.account.handler.AccountCreateHandler;
import me.kacper.account.handler.AccountLoginHandler;

public class Bank {

    public static void main(String[] args) {

        AccountCreateHandler accountCreateHandler = new AccountCreateHandler();
        AccountLoginHandler accountLoginHandler = new AccountLoginHandler();
        accountLoginHandler.onLogin();

    }
}
