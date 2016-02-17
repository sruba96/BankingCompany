import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Professor;
import domain.Programer;
import domain.Project;
import domain.Student;


public class Legacy
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		Student student = new Student();
		student.setFirstName("Robert");
		student.setLastName("Nowak");
		student.setAverageGrade(3.0);
		
		Professor professor = new Professor();
		professor.setFirstName("Piotrek");
		professor.setLastName("Kustra");
		professor.setSalary(4500.0);
		
		
		
		
		
		entityManager.getTransaction().begin();

		entityManager.persist(professor);
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
