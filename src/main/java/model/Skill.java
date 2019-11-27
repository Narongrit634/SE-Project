package model;

public class Skill {
    private String title,description;
    private int point;

    public Skill(String title, String description, int point) {
        this.title = title;
        this.description = description;
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
