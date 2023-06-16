import database.DatabaseInitService;
import database.DatabasePopulateService;
import database.DatabaseQueryService;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) throws SQLException, FileNotFoundException {

        PrintAllClients printAllClients = new PrintAllClients();
        printAllClients.printAllClients();
/*        DatabaseInitService databaseInitService = new DatabaseInitService();
        databaseInitService.databaseInit();*/

        //DatabasePopulateService databasePopulateService = new DatabasePopulateService();
/*        databasePopulateService.insertWorkers();
        databasePopulateService.insertClient();*/
        //databasePopulateService.insertProject();
/*        databasePopulateService.insertProjectWorker();

        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxProjectsClient();
        databaseQueryService.findLongestProject();
        databaseQueryService.findYoungestAndEldestWorkers();
        databaseQueryService.findMaxSalaryWorker();
        databaseQueryService.printProfectPrices();*/
    }
}
