package org.smart4j.helper;

import org.smart4j.util.PropsUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by marszhou on 15/12/18.
 */
public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DatabaseHelper.class);
    private static final ThreadLocal<Connection> CONNECTION_HOLDER;
    private static final QueryRunner QUERY_RUNNER ;
    private static final BasicDataSource DATA_SOURCE;
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();

    static {
        CONNECTION_HOLDER = new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(ConfigHelper.getJdbcDriver());
        DATA_SOURCE.setUrl(ConfigHelper.getJdbcUrl());
        DATA_SOURCE.setUsername(ConfigHelper.getJdbcUsername());
        DATA_SOURCE.setPassword(ConfigHelper.getJdbcPassword());
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass,
            /*Connection conn, */String sql, Object... params) {
        List<T> entityList;
        try {
            Connection conn=getConnection();
            entityList = QUERY_RUNNER.query(conn, sql,
                    new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity list failure", e);
            throw new RuntimeException(e);
        } finally {
//            closeConnection(conn);
//            closeConnection();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T entity;
        try {
            Connection conn = getConnection();
            entity = QUERY_RUNNER.query(conn, sql,
                    new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity failure", e);
            throw new RuntimeException(e);
        } finally {
//            closeConnection(conn);
//            closeConnection();
        }
        return entity;
    }

    public static <T> boolean updateEntity(Class<T> entityClass, String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            LOGGER.error("update entity failure", e);
        } finally {
//            closeConnection();
            if (rows == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static <T> boolean deleteEntity(Class<T> entityClass, String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            LOGGER.error("update entity failure", e);
        } finally {
//            closeConnection();
            if (rows == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static <T> boolean insertEntity(Class<T> entityClass, String sql, Object... params) {
        T entity = null;
        try {
            Connection conn = getConnection();
            entity = QUERY_RUNNER.insert(conn, sql,
                    new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("update entity failure", e);
        } finally {
//            closeConnection();
            if (entity != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static Connection getConnection() {
//        Connection conn = CONNECTION_THREAD_LOCAL.get();
//        try {
//            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            LOGGER.error("get connection failure", e);
//        }
//        return conn;
        Connection conn = CONNECTION_HOLDER.get();
        if (conn == null) {
            try {
                conn = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                LOGGER.error("get connection failure", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

//    public static void closeConnection(/*Connection conn*/) {
//        Connection conn = CONNECTION_THREAD_LOCAL.get();
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                LOGGER.error("close connections failure", e);
//            }
//        }
//    }

    public static int executeUpdate(String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            LOGGER.error("execute update failure", e);
            throw new RuntimeException(e);
        } finally {
//            closeConnection();
        }
        return rows;
    }

    public static void executeSqlFile(String filePath) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String sql;
            while ((sql = reader.readLine()) != null) {
                DatabaseHelper.executeUpdate(sql);
            }
        } catch (Exception e) {
            LOGGER.error("execute sql file failure", e);
            throw new RuntimeException(e);
        }
    }
}
