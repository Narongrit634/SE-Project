package store;

import model.User;

public class UserStore {
    private static User user;

    public static void setUser(User user) {
        UserStore.user = user;
    }

    public static User getUser() {
        return user;
    }
}
