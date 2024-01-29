
package DBManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Bingnan Dong
 */
public class SqliteDB  {
    private static String fileName = "alphacare.db";
    private static Connection connection;
  
   /**
     * Get the connection of the database
   */
    public static Connection getConnection()
    {
         String url = "jdbc:sqlite:" + fileName;
         try{
             connection = DriverManager.getConnection(url);
             System.out.println("Opened database successfully");
                
          }
          catch (SQLException e) {
             System.out.println(e.getMessage());
          }
          return connection;
    }
    
    /**
     * Create a table with a specified string in the database
     * @param conn The connection of DB
     * @param sql A sql string for creating table
    */
    public void createTable(Connection conn , String sql ){
          try (
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table created successfully");
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     /**
     * Delete all information from a specified table in the database
     * @param conn The connection of the database
     * @param tablename A table name for deleting
     */
     public void deleteTable(Connection conn ,String tableName){
       try (
           Statement stmt = conn.createStatement()) {
           String sql = "DELETE from " + tableName +";";
           stmt.execute(sql);
           stmt.close();
           System.out.println("Table deleted successfully"); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }       
      }
       
     /**
     * Drop a specified table in the database
     * @param conn The connection of the database
     * @param tablename A table name for dropping
     */
      public  void dropTable(Connection conn,String tableName){
        try (
           Statement stmt = conn.createStatement()) {
           String sql = "DROP table " + tableName +";";
           stmt.execute(sql);
           stmt.close();
           System.out.println("Table dropped successfully"); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }       
      }
}

