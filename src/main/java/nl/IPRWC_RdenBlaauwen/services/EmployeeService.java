package nl.IPRWC_RdenBlaauwen.services;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.IPRWC_RdenBlaauwen.dao.EmployeeDAO;
import nl.IPRWC_RdenBlaauwen.models.EmployeeModel;
import nl.IPRWC_RdenBlaauwen.models.Role;

public class EmployeeService {
    
    private EmployeeDAO employeeDao = new EmployeeDAO(); 
    
    public boolean createEmployee(EmployeeModel loggedUser, EmployeeModel employeeModel){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return this.employeeDao.createEmployeeVersion(employeeModel);
        }else{return false;}
       
    }
    
    public ArrayList<EmployeeModel> getAllEmployees(){
        return this.employeeDao.getAllEmployees();
    }
    
    public boolean updateEmployee( EmployeeModel loggedUser, EmployeeModel employeeModel){
//        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
//            return this.employeeDao.updateEmployee(employeeModel);
//        }else{
//            return false;
//        }
        return this.employeeDao.updateEmployee(employeeModel);
    }
    
    public boolean updateSelf(EmployeeModel loggedUser, EmployeeModel employeeModel){
        return this.employeeDao.updateEmployee(employeeModel);
    }
    
    public boolean deleteEmployee( EmployeeModel loggedUser, int employeeId){
        try {
            if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
                    return this.employeeDao.lockEmployee(employeeId);
            }else{
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
}
