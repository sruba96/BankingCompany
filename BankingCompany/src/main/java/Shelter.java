import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Cat;
import domain.Owner;

public class Shelter
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Owner owner = new Owner();
		Cat cat = new Cat();
		Owner owner2 = new Owner();
		Cat cat2 = new Cat();
		
		owner.setFirstName("Maciek");
		owner.setLastName("Kowalski");
		owner.setCat(cat);

		cat.setName("Franek");
		cat.setAge(20.0);

		owner2.setFirstName("Janek");
		owner2.setLastName("Nowak");
		owner2.setCat(cat2);

		cat2.setName("Bonifacy");
		cat2.setAge(2.0);

		entityManager.getTransaction().begin();

		entityManager.persist(owner);
		entityManager.persist(owner2);
		entityManager.persist(cat);
		entityManager.persist(cat2);

		entityManager.getTransaction().commit();

		entityManager.refresh(cat2);
		entityManager.refresh(cat);

		
		entityManager.close();
		entityManagerFactory.close();
	}

}
