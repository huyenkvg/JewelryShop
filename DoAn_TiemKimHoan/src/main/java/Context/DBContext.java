package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:sqlserver://;databaseName=datakimhoan";
        String user = "sa";
        String password = "123";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối jdbc");
        }
        return conn;
    }
   
}
