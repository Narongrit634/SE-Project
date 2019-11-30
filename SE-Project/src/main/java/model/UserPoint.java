package model;

public class UserPoint {
    private int point,userId,courseId;

    public UserPoint(int point, int userId, int courseId) {
        this.point = point;
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
