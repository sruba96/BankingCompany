package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Guy
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name = "guyId")
	private List<Phone> phones;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Phone> getPhones()
	{
		return phones;
	}

	public void setPhones(List<Phone> phones)
	{
		this.phones = phones;
	}
	
	
}
