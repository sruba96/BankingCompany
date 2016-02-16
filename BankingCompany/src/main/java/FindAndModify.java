import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;


public class FindAndModify
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Employee employee = entityManager.find(Employee.class, 1l);
		
		System.out.println("First name: "+employee.getFirstName());
		System.out.println("Salary : "+employee.getSalary());
		
		employee.setSalary(employee.getSalary()+500); //Here i modified, without persist.
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
