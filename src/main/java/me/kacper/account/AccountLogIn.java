package me.kacper.account;

public interface AccountLogIn {

    String name();
    String password();
    int pin();
    void onLogin();
}
