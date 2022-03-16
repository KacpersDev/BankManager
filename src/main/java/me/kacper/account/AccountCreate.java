package me.kacper.account;

import java.io.IOException;

public interface AccountCreate {

    String name();
    String password();
    int pin();
    void onCreation() throws IOException;
}
