package br.edu.udc.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class ActivityLog extends AbstractEntity{

	@ManyToOne( fetch = FetchType.EAGER, optional = false )
	private User createdBy;
	
	@Column( nullable=false )
	@Enumerated(EnumType.ORDINAL)
	private ActivityType activityType;
	
	@ManyToOne( fetch = FetchType.EAGER, optional = false )
	private Activity activity;
	
	@ManyToOne( fetch = FetchType.EAGER, optional = true )
	private User relatedUser;

	public ActivityLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivityLog(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result
				+ ((activityType == null) ? 0 : activityType.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((relatedUser == null) ? 0 : relatedUser.hashCode());
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
		ActivityLog other = (ActivityLog) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (activityType != other.activityType)
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (relatedUser == null) {
			if (other.relatedUser != null)
				return false;
		} else if (!relatedUser.equals(other.relatedUser))
			return false;
		return true;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getRelatedUser() {
		return relatedUser;
	}

	public void setRelatedUser(User relatedUser) {
		this.relatedUser = relatedUser;
	}
	
	
	
}
