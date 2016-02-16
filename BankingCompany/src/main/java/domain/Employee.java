package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.model.relational.Database;

@Entity
public class Employee
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	@Column(name="firstName", length=10, nullable=true, unique=false)
	private String firstName;
	
	@Transient //This field will not add to database
	private long ignored;
	
	@Column
	private String lastName;
	private double salary;

	
	@Temporal(TemporalType.DATE) // Temporal responsible for convert util.Date to sql.Date
	private Date date;
	
	private java.sql.Date sqlDate;
	
	
	public java.sql.Date getSqlDate()
	{
		return sqlDate;
	}

	public void setSqlDate(java.sql.Date sqlDate)
	{
		this.sqlDate = sqlDate;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

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

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

}
