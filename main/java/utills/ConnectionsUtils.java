package utills;

import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsUtils {
    private static String USER_NAME = "root";
    private static String USER_PASS = "";
    private static String URL = "jdbc:mysql://localhost/shop_java";


    public static Connection openConection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DOMConfigurator.configure("logConfig.xml");
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER_NAME, USER_PASS);
    }

}
