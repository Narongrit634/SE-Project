package dao;

import model.UserCourse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentInClassDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<UserCourse> rowMapper = (rs, rowNum) -> new UserCourse(rs.getInt("userId"),rs.getString("classPIN"));

    public StudentInClassDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
