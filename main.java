import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homegym",
                "root",
                ""
            );

            Statement stmt = conn.createStatement();

            // INSERT
            stmt.executeUpdate("INSERT INTO users (username, password) VALUES ('ana', '1234')");
            System.out.println("Usuario insertado");

            // SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            // UPDATE
            stmt.executeUpdate("UPDATE users SET password='9999' WHERE username='ana'");
            System.out.println("Usuario actualizado");

            // DELETE
            stmt.executeUpdate("DELETE FROM users WHERE username='ana'");
            System.out.println("Usuario eliminado");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}