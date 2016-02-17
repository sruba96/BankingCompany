package domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
/*
 *  One table in database with fields form all entity.
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //-
/*
 * three tables joined in database, interior tables have id from superior table.
 * @Inheritance(strategy = InheritanceType.JOINED)
 */

@DiscriminatorColumn(name = "Typ_rekordu")
public class Person
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String firstName;
	private String lastName;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

}
