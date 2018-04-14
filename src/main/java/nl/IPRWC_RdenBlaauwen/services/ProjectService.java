package nl.IPRWC_RdenBlaauwen.services;

import java.util.ArrayList;
import nl.IPRWC_RdenBlaauwen.dao.ProjectDAO;
import nl.IPRWC_RdenBlaauwen.models.EmployeeModel;
import nl.IPRWC_RdenBlaauwen.models.ProjectModel;
import nl.IPRWC_RdenBlaauwen.models.Role;

public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService(){
        projectDAO = new ProjectDAO();
    }
    
    public ArrayList<ProjectModel> read(){
        return this.projectDAO.getAllProjects();
    }
    public ArrayList<ProjectModel> readFromUrl(int employeeId){
        return this.projectDAO.project_list_employee(employeeId);
    }
    
    public boolean createProject(ProjectModel projectModel, EmployeeModel loggedUser){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return projectDAO.addProject(projectModel);
        }else{return false;}
        
    }
        
    public boolean update(ProjectModel projectModel, EmployeeModel loggedUser) throws Exception{
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
           return projectDAO.modifyProject(projectModel); 
        }else{return false;}
         
    }

    public boolean delete(ProjectModel projectModel, EmployeeModel loggedUser){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return projectDAO.removeProject(projectModel);
        }else{return false;}
        
    }

    public boolean unDeleteByUrl(int projectId, EmployeeModel loggedUser){
        if(loggedUser.getEmployeeRole().equals(Role.administration.toString())){
            return this.projectDAO.unRemoveProject(projectId);
        }else{return false;}
        
    }
    

}
