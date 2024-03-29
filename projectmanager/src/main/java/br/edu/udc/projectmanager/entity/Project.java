package br.edu.udc.projectmanager.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Project extends AbstractEntity {
	
	@NotNull
	@Column( nullable = false, length = 50, unique = true )
	private String name;
	
	@Column( nullable = true )
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar initialDate;
	
	@Column( nullable = true )
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finalDate;
	
	@Column( nullable=false )
	@Enumerated(EnumType.ORDINAL)
	private ProjectStatus status;
	
	@NotNull
	@ManyToOne( fetch = FetchType.EAGER )
	private User projectManager;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "project" )
	private Set<Activity> activities = new HashSet<Activity>();
	
	@ManyToMany( fetch = FetchType.EAGER )
	private Set<User> members = new HashSet<User>();
	
	@OneToMany( cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "project" )
	private Set<Milestone> milestones = new HashSet<Milestone>();

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((finalDate == null) ? 0 : finalDate.hashCode());
		result = prime * result
				+ ((initialDate == null) ? 0 : initialDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((projectManager == null) ? 0 : projectManager.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (finalDate == null) {
			if (other.finalDate != null)
				return false;
		} else if (!finalDate.equals(other.finalDate))
			return false;
		if (initialDate == null) {
			if (other.initialDate != null)
				return false;
		} else if (!initialDate.equals(other.initialDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectManager == null) {
			if (other.projectManager != null)
				return false;
		} else if (!projectManager.equals(other.projectManager))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Calendar initialDate) {
		this.initialDate = initialDate;
	}

	public Calendar getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Calendar finalDate) {
		this.finalDate = finalDate;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public Set<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(Set<Milestone> milestones) {
		this.milestones = milestones;
	}
	
	
	
}
