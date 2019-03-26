package org.ibra.quickstart.service;

import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.ibra.quickstart.model.Task;

@ApplicationScoped
public class TaskService {

	@Inject
	EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public Task createTask() {
		
		Task task = new Task();
		task.setNumber("Task-".concat(String.valueOf((new Random().nextInt(100) + 1))));
		task.setTitle("Random Task");
		task.setDescription("This task is generated randomly");
		
		em.persist(task);
		
		return task;
	}
	
	@Transactional(value=TxType.NOT_SUPPORTED)
	public List<Task> fetchAll() {
		
		return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
	}
}
