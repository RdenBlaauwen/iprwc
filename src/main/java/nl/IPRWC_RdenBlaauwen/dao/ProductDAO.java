/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.dao;
import java.sql.*;
import java.util.ArrayList;
import nl.IPRWC_RdenBlaauwen.models.ProductModel;

/**
 *
 * @author RdenBlaauwen
 */
public class ProductDAO {
    private ConnectDAO connect;

    public ProductDAO(){
        this.connect = new ConnectDAO();
//        this.createAddProjectFunction();
    }
    public void create(ProductModel productModel) throws SQLException, Exception{
        String query = "INSERT INTO product(p_productname,p_description,p_image,p_weight,p_price,p_isdeleted) " +
                        "VALUES(?,?,?,?,?,false);";
        Connection connection = this.connect.makeConnection();
        PreparedStatement statement= connection.prepareStatement(query);
        statement.setString(1, productModel.getName());
        statement.setString(2, productModel.getDescription());
        statement.setString(3, productModel.getImage());
        statement.setFloat(4, productModel.getWeight());
        statement.setFloat(5, productModel.getPrice());
        
        ResultSet resultSet = statement.executeQuery();
        resultSet.close();
        statement.close();
        connection.close();
    }
    public ArrayList<ProductModel> readAll() throws SQLException, Exception{
        String query = "SELECT * FROM product;";
        Connection connection = this.connect.makeConnection();
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<ProductModel> models = new ArrayList<>();
        while(resultSet.next()){
            ProductModel model = new ProductModel();
            model.setId(resultSet.getInt("p_id"));
            model.setName(resultSet.getString("p_productname"));
            model.setDescription(resultSet.getString("p_description"));
            model.setImage(resultSet.getString("p_image"));
            model.setPrice(resultSet.getFloat("p_price"));
            model.setWeight(resultSet.getFloat("p_weight"));
            model.setIsDeleted(resultSet.getBoolean("p_isdeleted"));
            models.add(model);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return models;
    }
    
    public void read(){
        
    }
    public void update(){
        
    }
    public void delete(){
        
    }
}
