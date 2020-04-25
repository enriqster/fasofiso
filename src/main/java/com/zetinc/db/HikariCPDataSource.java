package com.zetinc.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:32768/zetdb");
        ds.setUsername("izzet");
        ds.setPassword("1");
        ds.setMaximumPoolSize(2);
        ds.setDriverClassName("org.postgresql.ds.PGSimpleDataSource");



        /*config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("1");
        config.addDataSourceProperty("dataSourceClassName","org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");*/

        /*config.setJdbcUrl("jdbc:postgresql://localhost:32768/zetdb");
        config.setUsername("izzet");
        config.setPassword("1");
        config.addDataSourceProperty("dataSourceClassName","org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );*/

        /*Properties props = new Properties();
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "izzet");
        props.setProperty("dataSource.password", "1");
        props.setProperty("dataSource.databaseName", "zetdb");
        props.put("dataSource.logWriter", new PrintWriter(System.out));

        HikariConfig config = new HikariConfig(props);
        ds = new HikariDataSource(config);*/
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}