/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp.service;

import customerapp.dao.CustomerFacade;
import customerapp.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author guzman
 */
@Stateless
@LocalBean
public class CustomerBean {

    @EJB
    private CustomerFacade customerFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
        public List<Customer> findByZipAndName (String zipcode, String name) {
            return this.customerFacade.findByZipAndName (zipcode, name);
        }
}
