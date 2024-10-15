package com.alohatech.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private long taskid;
   private String title;
   private String description;
   private String status;
public Task() {
	super();
}
public Task(long taskid, String title, String description, String status) {
	super();
	this.taskid = taskid;
	this.title = title;
	this.description = description;
	this.status = status;
}
public long getTaskid() {
	return taskid;
}
public void setTaskid(long taskid) {
	this.taskid = taskid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Task [taskid=" + taskid + ", title=" + title + ", description=" + description + ", status=" + status + "]";
}
   
   

}
