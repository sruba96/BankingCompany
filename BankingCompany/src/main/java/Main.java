

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;



public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		//employee.setId(1l);
		employee.setFirstName("Paweł");
		employee.setLastName("Malina");
		employee.setSalary(20.0);
		employee.setDate(new Date(new java.util.Date().getTime()));
		employee.setSqlDate(new Date(new java.util.Date().getTime()));
		
		
		System.out.println(employee.getDate().toString());
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
