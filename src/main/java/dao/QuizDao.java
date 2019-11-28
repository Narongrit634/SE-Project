package dao;

import model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;

import java.util.List;

public class QuizDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Quiz> rowMapper = (rs, rowNum) -> new Quiz(rs.getString("question"),rs.getString("ans1"),rs.getString("ans2"),rs.getString("ans3"),rs.getString("ans4"),rs.getString("realans"),rs.getString("pin"),rs.getInt("time"),rs.getInt("point"));


    public QuizDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Quiz> getQuizList(String pin) {
        String query = "SELECT * FROM Quiz WHERE pin = '"+pin+"'";
        return jdbcTemplate.query(query, rowMapper);
    }


    public void addQuiz(Quiz quiz){
        String query = "INSERT INTO Quiz(question, ans1, ans2, ans3, ans4,realans,pin,time,point) VALUES (?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, quiz.getQuestion());
            ps.setString(2, quiz.getAns1());
            ps.setString(3, quiz.getAns2());
            ps.setString(4, quiz.getAns3());
            ps.setString(5, quiz.getAns4());
            ps.setString(6, quiz.getRealans());
            ps.setString(7, quiz.getPin());
            ps.setInt(8, quiz.getTime());
            ps.setInt(9, quiz.getPoint());

            return ps;
        });
    }
}
