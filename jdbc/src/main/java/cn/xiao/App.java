package cn.xiao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

/**
 * Hello world!
 *
 */
public class App 
{
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
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
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
