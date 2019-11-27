package model;

public class User {
    private int id;
    private String name,username,password,email,role;


    public User(int id ,String name, String username, String password, String email,String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static User getOurInstance() {
//        return ourInstance;
//    }
//
//    public static void setOurInstance(User ourInstance) {
//        User.ourInstance = ourInstance;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
