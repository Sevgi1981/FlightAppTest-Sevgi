package e2e.utils;

import java.sql.*;

public class DBUtils {


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void createDBConnection() throws SQLException {
        String urlDb=ConfigReader.getPropertyValues("urlDB");
        String userName=ConfigReader.getPropertyValues("username");
        String password=ConfigReader.getPropertyValues("password");

        try {
            connection = DriverManager.getConnection(urlDb,userName,password);
            System.out.println("Database connected created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("DB connection is failed");
        }

    }

    public static void closeDatabase(){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Exception occurred");
        }
    }
    public static ResultSet runQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Failed on Executing query");
        }
        return resultSet;
    }
}
