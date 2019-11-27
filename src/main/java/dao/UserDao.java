package dao;

import model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper = (rs, rowNum) -> new User(rs.getInt("id"),rs.getString("name"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("role"));

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserList() {
        String query = "SELECT * FROM Users";
        return jdbcTemplate.query(query, rowMapper);
    }


    public User isLogin(String username,String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ? AND role = 'teacher' ";
        Object[] args = new Object[]{username,password};
        try {
            return jdbcTemplate.queryForObject(query ,args ,rowMapper);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void register(User user){
        String query = "INSERT INTO Users (name, username, password, email,role) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5,"student");
            return ps;
        });
    }


}
