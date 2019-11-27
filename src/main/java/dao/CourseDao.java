package dao;

import model.Course;
import model.StudentList;
import model.UserCourse;
import model.UserQuiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.util.List;

public class CourseDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Course> rowMapper = (rs, rowNum) -> new Course(rs.getString("name"),rs.getString("code"),rs.getString("PIN"),rs.getString("t_name"));

    private RowMapper<StudentList> rowMapper2 = (rs, rowNum) -> new StudentList(rs.getInt("user_id"),rs.getString("nameStudent"),rs.getInt("point"));

    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> getCourseList() {
        String query = "SELECT * FROM Courses";
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<StudentList> getStudentList(String pin) {
        String query = "SELECT Users.id AS user_id ,name AS nameStudent,User_Class_Point.point AS point FROM Users left join User_Course ON Users.id = User_Course.user_id left JOIN User_Class_Point ON Users.id = User_Class_Point.user_id AND User_Course.course_id = User_Class_Point.course_id WHERE Users.role ='student' AND User_Course.class_PIN = '"+pin+"'";
        return jdbcTemplate.query(query, rowMapper2);
    }


    public void addCourse(Course course){
        String query = "INSERT INTO Courses(name, code, PIN, t_name) VALUES (?,?,?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, course.getName());
            ps.setString(2, course.getCode());
            ps.setString(3, course.getPIN());
            ps.setString(4, course.getT_name());

            return ps;
        });
    }
}
