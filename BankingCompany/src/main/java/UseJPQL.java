
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domain.Employee;

public class UseJPQL
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		/*
		 * Single result TypedQuery<Employee> query = entityManager
		 * .createQuery("select e from Employee e where e.id='2'",
		 * Employee.class);
		 * 
		 * Employee employee = query.getSingleResult(); //Single result
		 * 
		 * System.out.println("Salary: "+employee.getSalary());
		 */

		/*
		 * This solution when we will have more result.
		 * 
		 * TypedQuery<Employee> query = entityManager.
		 * createQuery("select e from Employee e where e.salary > 300",
		 * Employee.class); List<Employee> employeesList =
		 * query.getResultList();
		 * 
		 * for (Employee employee : employeesList) {
		 * System.out.println("Employee about id:" + employee.getId() +
		 * " have salary:" + employee.getSalary()); }
		 */
		
		/*
		 * Iterator
		 
		Query query = entityManager
				.createQuery("select concat(e.firstName,' ',e.lastName), e.salary from Employee e");

		Iterator<?> iterator = query.getResultList().iterator();

		while (iterator.hasNext())
		{
			Object[] item = (Object[]) iterator.next();
			String name = (String) item[0];
			Double salary = (Double) item[1];
			System.out.println("Employee: " + name + " salary:" + salary);
		}
		*/
		entityManager.getTransaction().begin();

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
