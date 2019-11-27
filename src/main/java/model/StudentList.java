package model;

public class StudentList {
    private int user_id,point;
    private String nameStudent;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public StudentList(int user_id, String nameStudent, int point) {
        this.user_id = user_id;
        this.nameStudent = nameStudent;
        this.point = point;
    }
}
