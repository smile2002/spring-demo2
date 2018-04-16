package cn.xiao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static DataSource dataSource;
    public static JdbcTemplate jdbcTemplate;

    public static ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/studydb?characterEncoding=utf8");
        ds.setUser("root");
        ds.setPassword("smile#2002");
        ds.setMaxPoolSize(10);
        ds.setMinPoolSize(1);
        ds.setInitialPoolSize(2);
        ds.setMaxIdleTime(20);
        ds.setAcquireIncrement(3);
        ds.setIdleConnectionTestPeriod(60);
        ds.setUnreturnedConnectionTimeout(190);
        ds.setCheckoutTimeout(20000);
        ds.setAcquireRetryAttempts(30);
        return ds;
    }

    public static void queryForObject1() {
        System.out.println("======= queryForObject1 ========");
        try {
            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
            User user = jdbcTemplate.queryForObject("select userId, age, name from user where userId = ?", rowMapper, "18621586003");
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void queryForObject2() {
        System.out.println("======= queryForObject2 ========");
        try {
            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
            Long count = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
            System.out.println(String.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void queryForList() {
        System.out.println("======= queryForList ========");
        try {
            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
            List<User> userList = jdbcTemplate.query("select userId, age, name from user where userId > ?", rowMapper, "0");
            for (User user : userList) {
                System.out.println(user.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        try {
            dataSource = dataSource();
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        queryForObject1();
        queryForObject2();
        queryForList();
    }
}
