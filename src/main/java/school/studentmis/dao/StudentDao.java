package school.studentmis.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import school.studentmis.models.Student;

public class StudentDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    public StudentDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public boolean insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (first_name, last_name, gender) VALUES (?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getGender());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public boolean insertStudentHbnt(Student student) throws SQLException {
        String sql = "INSERT INTO student (first_name, last_name, gender) VALUES (?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getGender());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    public List<Student> listAllStudents() throws SQLException {
        List<Student> listStudent = new ArrayList<Student>();
        String sql = "SELECT * FROM student";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
//            Student Student = new Student(id, firstName, lastName, gender);
//            listStudent.add(Student);
        }
        resultSet.close();
        statement.close();
        //disconnect();
        return listStudent;
    }
    public boolean deleteStudent(Student student) throws SQLException {
        String sql = "DELETE FROM student where id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, student.getId().intValue());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    public boolean updateStudent(Student Student) throws SQLException {
        String sql = "UPDATE student SET first_name = ?, last_name = ?, gender = ?";
        sql += " WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, Student.getFirstName());
        statement.setString(2, Student.getLastName());
        statement.setString(3, Student.getGender());
//        statement.setLong(4, Student.getId());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    public Student getStudent(Student sst) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";
        connect();
//        int stdId = sst.getId().intValue();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, stdId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
//            student = new Student(new Long(stdId), firstName, lastName, gender);
        }
        resultSet.close();
        statement.close();
        return student;
    }
}
