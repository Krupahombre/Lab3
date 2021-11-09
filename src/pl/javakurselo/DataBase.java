package pl.javakurselo;

import java.util.*;

public class DataBase {

    private Map<String, String> allUsers;

    public void usersDataBase() {
        allUsers = new HashMap<>();

        allUsers.put("admin", "admin");
        allUsers.put("Kacper", "1234");
        allUsers.put("Figo", "Fagot");
    }

    public Map<String, String> getAllUsers() {
        return allUsers;
    }
}
