/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    private static final String INIT_DB = "sql/init_db.sql";


    public void databaseInit() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(INIT_DB));
            statement.executeUpdate(sql);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
