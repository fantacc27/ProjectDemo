/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdemo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Xiao
 */
public class BookDao {
    public Statement statement = null;
    public Connection dbConnection = null;
    public List<Book> getAllBooks(String Name) throws SQLException{
        List<Book> mylist = new ArrayList();
        try {
            MyConnection mc = new MyConnection();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
                String selectTableSQL = "SELECT * FROM database_project.book WHERE NAME =" + "( '"+Name+"')";
                ResultSet rs = statement.executeQuery(selectTableSQL);
                
                while (rs.next()) {
                    Integer sId = rs.getInt("id");
                    String sName = rs.getString("name");
                    Double sPrice = rs.getDouble("price");
                    Boolean sSale = rs.getBoolean("sale");
                    String sAuthor = rs.getString("author");
                    String sNation = rs.getString("nation");
                    String sPublisher = rs.getString("publisher");
                    Integer sPublishyear = rs.getInt("publishyear");
                    String sEmail = rs.getString("email");
                    Integer sCode = rs.getInt("code");
                    
                    Book e = new Book(sId,sName,sPrice,sSale,sAuthor,sNation,sPublisher,sPublishyear,sEmail,sCode);
                        System.out.println("Book ID: " + sId);
                        System.out.println("Book NAME: " + sName);
                        mylist.add(e);
                }
                                       
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                finally{
                            if (statement != null) {
                                statement.close();
                            }
                            if (dbConnection != null) {
                                dbConnection.close();
                            }
                
                       
        }
        return mylist;
    }
        public void insertBook(String Name, Double Price, Boolean Sale, String Author, String Nation , String Publisher, Integer Publishyear, String Email, Integer Code) throws SQLException {
                String insertTableSQL = "INSERT INTO database_project.book" + "( name, price, sale, author, nation, publisher, publishyear, email, code)" + "VALUES" + "('"+Name+"',"+Price+","+Sale+",'"+Author+"','"+Nation+"','"+Publisher+"',"+Publishyear+",'"+Email+"',"+Code+")";
                    try {
                            MyConnection mc = new MyConnection();
                            dbConnection = mc.getConnection();
                            statement = dbConnection.createStatement();
                            statement.executeUpdate(insertTableSQL);
                            System.out.println("Record is inserted into Book table!");
                            JOptionPane.showMessageDialog(null,"Record is inserted into Book table!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        
                    } finally {
                        if (statement != null) {
                            statement.close();
                        }
                        if(dbConnection != null) {
                            dbConnection.close();
                        }
                    }
        }
        public void updateBook(Integer ID, Double Price) throws SQLException {
                String updateTableSQL = "UPDATE database_project.book SET PRICE ='"+Price+"' WHERE ID='"+ID+"'";
                    try {
                            MyConnection mc = new MyConnection();
                            dbConnection = mc.getConnection();
                            statement = dbConnection.createStatement();
                            statement.executeUpdate(updateTableSQL);
                            JOptionPane.showMessageDialog(null,"Record is updated in Book table!");
                            System.out.println("Record is updated into Book table!");
                            
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        
                    } finally {
                        if (statement != null) {
                            statement.close();
                        }
                        if(dbConnection != null) {
                            dbConnection.close();
                        }
                    }
        }
        public void deleteBook(Integer Code) throws SQLException {
                String deleteTableSQL = "DELETE FROM database_project.book WHERE CODE='"+Code+"'";
                    try {
                            MyConnection mc = new MyConnection();
                            dbConnection = mc.getConnection();
                            statement = dbConnection.createStatement();
                            statement.executeUpdate(deleteTableSQL);
                            JOptionPane.showMessageDialog(null,"Record is deleted from Book table!");
                            System.out.println("Record is deleted from Book table!");
                            
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        
                    } finally {
                        if (statement != null) {
                            statement.close();
                        }
                        if(dbConnection != null) {
                            dbConnection.close();
                        }
                    }
        }
}
