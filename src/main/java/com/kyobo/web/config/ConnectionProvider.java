package com.kyobo.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnectionProvider{

    private static final Properties PROPERTIES = loadProperties();

    private ConnectionProvider() {
    }
    public static Connection getConnection() throws SQLException {
        String url = PROPERTIES.getProperty("db.url");
        String user = PROPERTIES.getProperty("db.user");
        String password = PROPERTIES.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream =
                     ConnectionProvider.class.getClassLoader()
                             .getResourceAsStream("db.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException("db.properties 파일을 찾을 수 없습니다.");
            }

            properties.load(inputStream);
            return properties;

        } catch (IOException e) {
            throw new IllegalStateException("db.properties 파일을 읽지 못했습니다.", e);
        }
    }
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("DB 연결 성공: " + !connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
