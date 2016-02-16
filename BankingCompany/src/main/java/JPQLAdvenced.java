import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Employee;

public class JPQLAdvenced
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		/*
		 * Parameter first method Name of parameter :name (:minSalary)
		 */
		TypedQuery<Employee> query = entityManager.createQuery(
				"select e from Employee e where e.salary > :minSalary",
				Employee.class);

		query.setParameter("minSalary", 19.0);
		List<Employee> employeeList = query.getResultList();

		for (Employee employee : employeeList)
		{
			System.out.println("Employee about id:" + employee.getId()
					+ " have salary:" + employee.getSalary());
		}

		/*
		 * Parameter second method ?1 - first ?2 - second ....
		 */
		TypedQuery<Employee> query2 = entityManager
				.createQuery(
						"select e from Employee e where e.salary > ?1 and e.salary < ?2",
						Employee.class);

		query2.setParameter(1, 10.0);
		query2.setParameter(2, 40.0);

		List<Employee> employeeList2 = query2.getResultList();

		for (Employee employee2 : employeeList2)
		{
			System.out.println("Employee about id:" + employee2.getId()
					+ " have salary:" + employee2.getSalary());
		}

		/*
		 * Another option
		 * Whole list :)
		 */
		TypedQuery<Employee> query3 = entityManager
				.createQuery(
						"select e from Employee e where e.salary in :moneyParameter",
						Employee.class);

		List<Double> moneyList = new ArrayList<Double>();
		moneyList.add(20.0);
		moneyList.add(40.0);
		moneyList.add(520.0);
       
		query3.setParameter("moneyParameter", moneyList);

		List<Employee> employeeList3 = query3.getResultList();

		for (Employee employee : employeeList3)
		{
			System.out.println("Employee about id:" + employee.getId()
					+ " have salary:" + employee.getSalary());
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
