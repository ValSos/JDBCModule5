package database;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    private static final String WORKERS_FILE = "sql/workers.txt";
    private static final String CLIENT_FILE = "sql/client.txt";
    private static final String PROJECT_FILE = "sql/project.txt";
    private static final String PROJECT_WORKER_FILE = "sql/project_worker.txt";
    private static final String INSERT_WORKER_SQL = "INSERT INTO " +
            "worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (name) VALUES (?)";
    private static final String INSERT_PROJECT_SQL = "INSERT INTO " +
            "project (name, client_id, start_date, finish_date) VALUES (?, ?, ?, ?)";
    private static final String INSERT_PROJECT_WORKER_SQL = "INSERT INTO " +
            "project_worker (project_id , worker_id) VALUES (?, ?)";

    private final Connection connection = Database.getInstance().getConnection();




    public void insertWorkers() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(WORKERS_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] workerData = line.split(", ");
                String name = workerData[0];
                String birthday = workerData[1];
                String level = workerData[2];
                int salary = Integer.parseInt(workerData[3]);
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertClient() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(CLIENT_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line;
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProject() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(PROJECT_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] projectData = line.split(", ");
                String name = projectData[0];
                int client_id = Integer.parseInt(projectData[1]);
                String start_date = projectData[2];
                String finish_date = projectData[3];
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProjectWorker() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_WORKER_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(PROJECT_WORKER_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] projectWorkerData = line.split(",");
                int project_id = Integer.parseInt(projectWorkerData[0]);
                int worker_id = Integer.parseInt(projectWorkerData[1]);
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
