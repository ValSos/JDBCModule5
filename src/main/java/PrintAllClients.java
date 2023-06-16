import database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintAllClients {
    public void printAllClients() throws SQLException {
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

            System.out.println("Clients:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
                System.out.println("_______");
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
