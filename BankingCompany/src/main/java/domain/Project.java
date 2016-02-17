package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Project
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String projectName;

	private double progres;

	@ManyToMany
	@JoinTable(
			name = "pracownicy_w_projektach",  // new name for linked table
			joinColumns = {@JoinColumn(name = "projectID")},
			inverseJoinColumns = {@JoinColumn(name = "programerID")}
			)
	private List<Programer> programers;

	
	public Project(String projectName, double progres)
	{
		super();
		this.projectName = projectName;
		this.progres = progres;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public double getProgres()
	{
		return progres;
	}

	public void setProgres(double progres)
	{
		this.progres = progres;
	}

	public List<Programer> getProgramers()
	{
		return programers;
	}

	public void setProgramers(List<Programer> programers)
	{
		this.programers = programers;
	}

}
