package domain;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/*
 * This one class will create two tables in database.
 */
@Entity
@Table(name = "Pracownicy")
public class Person
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String frstName;
	private String lastName;
	private double age;
	
	@Embedded //I puted here other class.
	private Address data = new Address();

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getFrstName()
	{
		return frstName;
	}

	public void setFrstName(String frstName)
	{
		this.frstName = frstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public double getAge()
	{
		return age;
	}

	public void setAge(double age)
	{
		this.age = age;
	}

	public String getCity()
	{
		return data.city;
	}

	public void setCity(String city)
	{
		this.data.city = city;
	}

	public double getAddress()
	{
		return data.address;
	}

	public void setAddress(double address)
	{
		this.data.address = address;
	}
}
