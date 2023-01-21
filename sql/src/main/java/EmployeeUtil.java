import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public final class EmployeeUtil {

    private EmployeeUtil(){

    }

    private static final String CREATE_TABLE = "CREATE TABLE EMPLOYEES(" +
            "ID INTEGER AUTO_INCREMENT NOT NULL," +
            "FIRST_NAME VARCHAR(255)," +
            "LAST_NAME VARCHAR(255)," +
            "SALARY INTEGER," +
            "PRIMARY KEY(ID))";



    public static void createTable(){
        try {
            JDBCConfig.getStatement().executeUpdate(CREATE_TABLE);
            System.out.println("Create table in given database");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public static void insert(Employee employee){
        String INSET_TABLE = "INSERT INTO EMPLOYEES(FIRST_NAME, lAST_NAME, SALARY)" +
                "VALUES( '" + employee.getFirstName() +"' , '" + employee.getLastName() +"' ," + employee.getSalary() + ")";

        try{
            JDBCConfig.getStatement().executeUpdate(INSET_TABLE);
            System.out.println("Table updated");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> selectAllEmployee() throws SQLException {
        String select = "SELECT * FROM EMPLOYEES";

        List<Employee> employees = new ArrayList<>();

        try{
            ResultSet result = JDBCConfig.getStatement().executeQuery(select);

            while (result.next()){
                Employee employee  = new Employee();
                employee.setId(result.getLong("ID"));
                employee.setFirstName(result.getString("FIRST_NAME"));
                employee.setLastName(result.getString("LAST_NAME"));
                employee.setSalary(result.getInt("SALARY"));

                employees.add(employee);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return employees;
    }

    public static void updateTable(long id, String newName){

        String update ="UPDATE EMPLOYEES SET FIRST_NAME = " + newName + " WHERE ID =" + id;

        try {
            JDBCConfig.getStatement().executeUpdate(update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteEmployee(long id){
        String delete = "DELETE FROM EMPLOYEES WHERE ID = " + id;

        try {
            JDBCConfig.getStatement().executeUpdate(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
