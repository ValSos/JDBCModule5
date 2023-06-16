import database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintAllWorkers {
    Connection connection = Database.getInstance().getConnection();
    String sql = "SELECT * FROM worker";

    public void printAllWorkers() throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String level = resultSet.getString("level");
                int salary = resultSet.getInt("salary");

                System.out.println("Worker ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Birthday: " + birthday);
                System.out.println("Level: " + level);
                System.out.println("Salary: " + salary);
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
