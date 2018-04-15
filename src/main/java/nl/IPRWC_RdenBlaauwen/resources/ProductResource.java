/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.auth.Auth;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.IPRWC_RdenBlaauwen.models.AccountModel;
import nl.IPRWC_RdenBlaauwen.models.CategoryModel;
import nl.IPRWC_RdenBlaauwen.models.EmployeeModel;
import nl.IPRWC_RdenBlaauwen.models.ProductModel;
import nl.IPRWC_RdenBlaauwen.services.ProductService;

/**
 *
 * @author RdenBlaauwen
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private ProductService service = new ProductService();
    
    @GET
    @JsonProperty
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductModel> read(@Auth AccountModel requester){
            return service.read();
    }
    
}
