package model;

public class UserCourse {

    private int userId;
    private String classPIN;

    public UserCourse(int userId, String classPIN) {
        this.userId = userId;
        this.classPIN = classPIN;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getClassPIN() {
        return classPIN;
    }

    public void setClassPIN(String classPIN) {
        this.classPIN = classPIN;
    }
}
