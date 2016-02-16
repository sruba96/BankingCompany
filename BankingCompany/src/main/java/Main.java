import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import domain.Address;
import domain.Employee;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Employee employee = new Employee();
		Address address = new Address();

		// employee.setId(1l);
		employee.setFirstName("Paweł");
		employee.setLastName("Malina");
		employee.setSalary(20.0);
		employee.setAddress(address);

		address.setCity("Krakow");
		address.setNumber(22.0);

		entityManager.getTransaction().begin();
		/*
		 * We must save everything, employee and address.
		 */
		entityManager.persist(employee);
		entityManager.persist(address);
		
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
