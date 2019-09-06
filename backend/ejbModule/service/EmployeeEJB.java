package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {


	@PersistenceContext
	private EntityManager em;
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Employee> findEmployees(){
    	
    	List<Employee> data = em.createQuery("SELECT id,dateOfBirth,name,surName FROM employee_tbl",Employee.class).getResultList();
    	System.out.println(data.get(1).getDateOfBirth());
    	   System.out.println(data.get(2).getName());
    	   System.out.println(data.get(3).getSurName());
    	
    	return data;
    }

    
    public void addNew(EmployeeEntity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity);
    	System.out.println("============================");
    }

}
