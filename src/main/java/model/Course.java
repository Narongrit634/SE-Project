package model;

public class Course {

    private String name;
    private String code;
    private String PIN;
    private String t_name;

    public Course(String name, String code, String PIN, String t_name) {
        this.name = name;
        this.code = code;
        this.PIN = PIN;
        this.t_name = t_name;
    }


    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
