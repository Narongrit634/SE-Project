package Server;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseManager {
    private static final String DB_URL = "remotemysql.com:3306/ytzEjdpCNf";
    private static DatabaseManager databaseManager;

    private JdbcTemplate jdbcTemplate;

    private DatabaseManager() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://" + DB_URL);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("ytzEjdpCNf");
        dataSource.setPassword("L9LcYDD81I");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static synchronized DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
