/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Xiao
 */
public class UserDao {
    public boolean CheckUserNameAndPassword(String Un,String Pass) throws SQLException
    {
        String sql = "SELECT 'ID','UserName','Password' FROM database_project.User WHERE UserName = '"+Un+"' and Password = '"+Pass+"'";
        boolean IsValid = false;
        MyConnection con = new MyConnection();
        Connection connect = con.getConnection();
        Statement statement = null;
        try{
            statement=connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            String UserName = "";
            String Password = "";
            while(rs.next())
            {
                IsValid = true;
            } }catch (Exception ex){}
            finally{
                    connect.close();
                    statement.close();
                    }
            return IsValid;
        }
    }
