package datos;
import java.sql.*;

public class Conexion {
    private static String user = "migna";
    private static String pswd = "root";
    private static String bd = "pro_Shield";
    private static String server = "jdbc:postgresql://localhost:5432/" + bd;
    private static String driver = "org.postgresql.Driver";
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(server, user, pswd);
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la BD " + bd);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void close(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
