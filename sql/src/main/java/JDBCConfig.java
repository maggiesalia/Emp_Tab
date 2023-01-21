import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final  class JDBCConfig {

    public static final String  DB_URL = "jdbc:mysql://localhost:3306";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public static Statement getStatement() throws SQLException {
        try {
            statement = connection.createStatement();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return statement;
    }


}
