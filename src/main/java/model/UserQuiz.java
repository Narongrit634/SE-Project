package model;

public class UserQuiz {
    private int userId,quizId;
    private String pin;
    private boolean status;

    public UserQuiz(int userId, int quizId, String pin, boolean status) {
        this.userId = userId;
        this.quizId = quizId;
        this.pin = pin;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
