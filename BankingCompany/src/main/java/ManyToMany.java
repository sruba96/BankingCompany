import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Guy;
import domain.Phone;
import domain.Programer;
import domain.Project;


public class ManyToMany
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		
		Project project1 = new Project("Project for Bank",.5);
		Project project2 = new Project("Project for Fundation", .1);
	
		
		Programer programer1 = new Programer("Janek");
		Programer programer2 = new Programer("Marcin");
		Programer programer3 = new Programer("Jola");
		Programer programer4 = new Programer("Zbigniew");
		Programer programer5 = new Programer("Jan");
		Programer programer6 = new Programer("Maciek");
		
		List<Programer> programersInProject1 = new ArrayList<Programer>();
		List<Programer> programersInProject2 = new ArrayList<Programer>();
		
		project1.setProgramers(programersInProject1);
		project2.setProgramers(programersInProject2);
		
		programersInProject1.add(programer3);
		programersInProject1.add(programer1);
		programersInProject1.add(programer2);
		programersInProject1.add(programer6);
		
		programersInProject2.add(programer3);
		programersInProject2.add(programer1);
		programersInProject2.add(programer5);
		programersInProject2.add(programer3);
		
		entityManager.getTransaction().begin();

		entityManager.persist(project1);
		entityManager.persist(project2);
		
		entityManager.persist(programer1);
		entityManager.persist(programer2);
		entityManager.persist(programer3);
		entityManager.persist(programer4);
		entityManager.persist(programer5);
		entityManager.persist(programer6);
		
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
