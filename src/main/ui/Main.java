package ui;

import java.util.Map;

import model.User;
import model.UserAction;

public class Main {
    public static void main(String[] args) {
        Map<String,User> map = UserAction.getAllUsersMap();
        System.out.println(map);
        CoDecideApp app = new CoDecideApp();
        app.run();
    }
}
