package com.example.SBNZ.model.training;

import java.util.*;

import com.example.SBNZ.enums.diet.Goal;
import com.example.SBNZ.enums.training.Muscle;

import javax.persistence.*;

@Entity
@Table(name = "trainings")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "trainingId")
    private List<Session> sessionList = new ArrayList<>();

	@Column(name = "restTime", nullable = false)
	private int restTime;

	@Column(name = "numberOfSessions", nullable = false)
	private int numberOfSessions;

	@Enumerated(EnumType.STRING)
	private Goal goal;

	@ElementCollection(targetClass = Muscle.class)
	@JoinTable(name = "muscles_training", joinColumns = @JoinColumn(name = "training_id"))
	@Column(name = "muscleList", nullable = false)
	@Enumerated(EnumType.STRING)
    private List<Muscle> muscles = new ArrayList<Muscle>();

	public Training() {
		
	}

	public Training(int restTime, int numberOfSessions) {
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
	}

	public Training(int restTime, int numberOfSessions, Goal goal) {
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
		this.goal = goal;
	}

	public Training(List<Session> sessionList, int restTime, int numberOfSessions) {
		this.sessionList = sessionList;
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
	}

	public Training(List<Session> sessionList, int restTime, int numberOfSessions, Goal goal, List<Muscle> muscles) {
		this.sessionList = sessionList;
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
		this.goal = goal;
		this.muscles = muscles;
	}

	public Training(int id, List<Session> sessionList, int restTime, int numberOfSessions, Goal goal, List<Muscle> muscles) {
		this.id = id;
		this.sessionList = sessionList;
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
		this.goal = goal;
		this.muscles = muscles;
	}

	public void addSession(List<Exercise> exercises) {
		Random rand = new Random();
		int randomIndex = -1;
		if (exercises.size() == 1) {
			randomIndex = 0;
		}else {
			randomIndex = rand.nextInt(exercises.size() - 1);
		}
		Exercise exerciseByIndex = exercises.get(randomIndex);
		Session session = null;
		if (goal == Goal.MASS_GAIN) {
			session = new Session(exerciseByIndex, 30, 4, 0);
		}else {
			session = new Session(exerciseByIndex, 0, 4, 30);
		}
		sessionList.add(session);
		muscles.addAll(exerciseByIndex.getMuscleList());

		/*
		this.sessionList.add(session);
		for(Muscle m: session.getExercise().getMuscleList()) {
			this.muscles.add(m);
		}
		 */

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public List<Session> getSessionList() {
		return sessionList;
	}
	public void setSessionList(List<Session> sessionList) {
		this.sessionList = sessionList;
	}
	public int getRestTime() {
		return restTime;
	}
	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}
	public int getNumberOfSessions() {
		return numberOfSessions;
	}
	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}

    public List<Muscle> getMuscles() {
		return muscles;
	}

	public void setMuscles(List<Muscle> muscles) {
		this.muscles = muscles;
	}

}
