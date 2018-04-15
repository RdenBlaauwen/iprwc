
package nl.IPRWC_RdenBlaauwen.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.IPRWC_RdenBlaauwen.dao.AccountDAO;
import nl.IPRWC_RdenBlaauwen.dao.EmployeeDAO;
import nl.IPRWC_RdenBlaauwen.models.AccountModel;
import nl.IPRWC_RdenBlaauwen.models.EmployeeModel;

/**
 *
 * @author rezanaser
 */
public class Auth implements Authenticator<BasicCredentials, AccountModel>{

    @Override
    public Optional<AccountModel> authenticate(BasicCredentials c) throws AuthenticationException {
        AccountDAO accountDao = new AccountDAO();
        AccountModel currentEmployee = null;
        
        
        
        ArrayList<AccountModel> accounts;
        try {
            accounts = accountDao.readAll();
            if(accounts!=null){
                for(AccountModel account : accounts){
                    if(account.getEmail().trim().equals(c.getUsername().trim())
                        &&account.getPassword().trim().equals(c.getPassword().trim())){
                        currentEmployee = account;
                    }
                }
                if(currentEmployee != null)
                {
                    return Optional.of(currentEmployee);
                }else{

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.absent();
    }
}
