package nl.IPRWC_RdenBlaauwen.services;

import java.sql.Date;
import java.util.ArrayList;
import nl.IPRWC_RdenBlaauwen.dao.SprintDAO;
import nl.IPRWC_RdenBlaauwen.helpers.DateHelper;
import nl.IPRWC_RdenBlaauwen.models.CategoryModel;
import nl.IPRWC_RdenBlaauwen.models.EmployeeModel;
import nl.IPRWC_RdenBlaauwen.models.Role;

public class CategoryService {
    
    private SprintDAO categoryDao = new SprintDAO();
    
    public boolean create(CategoryModel sprintModel, EmployeeModel loggedUser){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return categoryDao.createSprint(sprintModel);
        }else{return false;}
      
    }
    
    public boolean updateCategory(CategoryModel categoryModel, EmployeeModel loggedUser){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
         DateHelper dateHelper = new DateHelper();
        Date startDateParsed = dateHelper.parseDate(categoryModel.getCategoryStartDate(), "yyyy-MM-dd");
        Date endDateParsed = dateHelper.parseDate(categoryModel.getCategoryEndDate(), "yyyy-MM-dd");
        return categoryDao.modifySprint(categoryModel, startDateParsed, endDateParsed);
        }else{return false;}
        
    }
    
    public ArrayList<CategoryModel> getAllCategories() throws Exception{
        return this.categoryDao.allSprints();
    }
    
    public boolean deleteCategory(int catId, EmployeeModel loggedUser) throws Exception{
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return this.categoryDao.removeSprint(catId);
        }else{return false;}
        
    }
    
    public boolean unDelete(int catId, EmployeeModel loggedUser) throws Exception{
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return this.categoryDao.removeSprint(catId);
        }else{return false;}
        
    }
    
}
