import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Guy;
import domain.Phone;

/**
 * I creating here unidirectional relation OneToMany, i using to entity class
 * Phone and Guy. Guy have List<Phone>.
 */
public class OneToMany
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Guy guy = new Guy();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();

		guy.setName("Janusz");
		phone1.setType("mobile");
		phone1.setNumber(41237842);
		phone2.setType("home");
		phone2.setNumber(64723667);

		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);

		guy.setPhones(phones);

		entityManager.getTransaction().begin();

		entityManager.persist(guy);
		entityManager.persist(phone1);
		entityManager.persist(phone2);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
