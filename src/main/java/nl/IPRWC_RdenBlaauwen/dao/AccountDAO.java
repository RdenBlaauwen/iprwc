/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import nl.IPRWC_RdenBlaauwen.models.AccountModel;
import nl.IPRWC_RdenBlaauwen.models.ProductModel;

/**
 *
 * @author RdenBlaauwen
 */
public class AccountDAO {
    private ConnectDAO connect;

    public AccountDAO(){
        this.connect = new ConnectDAO();
//        this.createAddProjectFunction();
    }
    public ArrayList<AccountModel> readAll() throws SQLException, Exception{
        String query = "SELECT * FROM account WHERE a_isdeleted=false;";
        Connection connection = this.connect.makeConnection();
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<AccountModel> models = new ArrayList<>();
        while(resultSet.next()){
            AccountModel model = new AccountModel();
            model.setId(resultSet.getInt("a_id"));
            model.setFirstName(resultSet.getString("a_firstname"));
            model.setLastName(resultSet.getString("a_lastname"));
            model.setEmail(resultSet.getString("a_email"));
            model.setPassword(resultSet.getString("a_password"));
            model.setIsDeleted(resultSet.getBoolean("a_isdeleted"));
            model.setIsAdmin(resultSet.getBoolean("a_isadmin"));
            models.add(model);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return models;
    }
}
