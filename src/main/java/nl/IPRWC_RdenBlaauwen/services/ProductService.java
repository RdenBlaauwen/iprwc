/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.services;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.IPRWC_RdenBlaauwen.dao.ProductDAO;
import nl.IPRWC_RdenBlaauwen.models.*;

/**
 *
 * @author RdenBlaauwen
 */
public class ProductService {
    public void create(){
        
    }
    
    public ArrayList<ProductModel> read(){
        ProductDAO productDao = new ProductDAO();
        try {
            return productDao.readAll();
        } catch (java.lang.Exception ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
