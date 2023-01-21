import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeUtil.createTable();
        EmployeeUtil.insert(new Employee("Megi", "Salia", 1850));
        EmployeeUtil.insert(new Employee("Maryam", "Salia", 3200));
        EmployeeUtil.selectAllEmployee().stream().forEach(employee -> System.out.println(employee));
    }

}
