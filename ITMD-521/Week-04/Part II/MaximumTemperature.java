//MaxTemperature Application to find the maximum temperature in the weather dataset

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MaximumTemperature{

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                String url = "jdbc:mysql://127.0.0.1/521";
                String user = "root";
                String password = "itmd521";
                String driver = "com.mysql.jdbc.Driver";
                try {
                        Class.forName(driver);
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }

                // creating a connection object to establish the connection to the
                // database
                @SuppressWarnings("unused")
                Connection connection = null;
                try {
                        connection = DriverManager.getConnection(url, user, password);
                        String sql = "SELECT year,MAX(temperature) FROM records GROUP BY year";
                        PreparedStatement statement = null;
                        ResultSet resultSet = null;
                        statement = connection.prepareStatement(sql);
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {

                                int year = resultSet.getInt("year");
                                int temperature = resultSet.getInt("MAX(temperature)");
                                System.out.println("Max temperature for the year " +year+ " is " +temperature+ " !");
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                }


        }
}
