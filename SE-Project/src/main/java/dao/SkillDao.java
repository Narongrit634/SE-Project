package dao;

import model.Skill;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class SkillDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Skill> rowMapper = (rs, rowNum) -> new Skill(rs.getString("title"),rs.getString("description"),rs.getInt("point"));

    public SkillDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Skill> getSkillList() {
        String query = "SELECT * FROM Skill";
        return jdbcTemplate.query(query, rowMapper);
    }


}
