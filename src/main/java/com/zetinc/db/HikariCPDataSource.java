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
        ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}