package com.tea.modules.bean.non;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PACKAGE_NAME
 *
 * @author xiejiemin
 * @create 2020/10/21
 */
public class BeforeSpring {

    public static void main(String[] args) {
        MySQLConfig mySQLConfig = new MySQLConfig();
        mySQLConfig.url = "jdbc:mysql://127.0.0.1:3306/user";
        mySQLConfig.userName = "root";
        mySQLConfig.password = "root";
        UserMapper userMapper = new UserMapper(mySQLConfig);
        UserService userService = new UserService(userMapper);
        UserController userController = new UserController(userService);
        userController.deleteUserById("1");
    }

    public static class UserController {
        public UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        public void deleteUserById(String id) {
            userService.deleteUserById(id);
        }
    }

    public static class UserService {
        public UserMapper userMapper;

        public UserService(UserMapper userMapper) {
            this.userMapper = userMapper;
        }

        public void deleteUserById(String userId) {
            userMapper.deleteUser(userId);
        }
    }

    public static class UserMapper {
        private MySQLDataSource dataSource;

        public UserMapper(MySQLConfig mySQLConfig) {
            this.dataSource = new MySQLDataSource(mySQLConfig);
        }

        public void deleteUser(String userId) {
            Connection connection = dataSource.getConnection();
            try {
                Statement stmt = connection.createStatement();
                stmt.execute("DELETE FROM USER WHERE user_id = " + userId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static class MySQLConfig {
        private String url;
        private String userName;
        private String password;
    }

    public static class MySQLDataSource {
        private String url;
        private String userName;
        private String password;
        private Connection connection;

        public MySQLDataSource(MySQLConfig config) {
            this.url = config.url;
            this.userName = config.userName;
            this.password = config.password;
            try {
                //1.加载驱动程序
                Class.forName("com.mysql.jdbc.Driver");
                //2. 获得数据库连接
                connection = DriverManager.getConnection(config.url, config.userName, config.password);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("异常");
            }
        }

        public Connection getConnection() {
            return this.connection;
        }
    }
}
