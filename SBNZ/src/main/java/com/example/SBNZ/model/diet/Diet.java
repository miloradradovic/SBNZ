package com.example.SBNZ.model.diet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.SBNZ.enums.diet.Goal;

import com.example.SBNZ.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diets")
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "kCal", nullable = false)
    private int kCal;

	@Column(name = "carbonHydrates", nullable = false)
    private int carbonHydrates;

	@Column(name = "proteins", nullable = false)
	private int proteins;

	@Column(name = "fats", nullable = false)
	private int fats;

	@Column(name = "calorieMin", nullable = false)
    private int calorieMin;

	@Column(name = "calorieMax", nullable = false)
    private int calorieMax;

	@Column(name = "recommendedTime", nullable = false)
    private int recommendedTime = 0;

	@Enumerated(EnumType.STRING)
    private Goal goal;

	@ManyToMany
	@JoinTable(
			name = "meal_diet",
			joinColumns = @JoinColumn(name = "diet_id"),
			inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals;

	@OneToOne(mappedBy = "diet")
	private User user;

    public Diet(Goal goal) {
    	this.goal = goal;
    }
    
    public Diet() {

    }

	public Diet(int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, Goal goal, List<Meal> meals) {
		this.kCal = kCal;
		this.carbonHydrates = carbonHydrates;
		this.proteins = proteins;
		this.fats = fats;
		this.calorieMin = calorieMin;
		this.calorieMax = calorieMax;
		this.recommendedTime = recommendedTime;
		this.goal = goal;
		this.meals = meals;
	}

	public Diet(int id, int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, Goal goal, List<Meal> meals) {
		this.id = id;
    	this.kCal = kCal;
		this.carbonHydrates = carbonHydrates;
		this.proteins = proteins;
		this.fats = fats;
		this.calorieMin = calorieMin;
		this.calorieMax = calorieMax;
		this.recommendedTime = recommendedTime;
		this.goal = goal;
		this.meals = meals;
	}

	public Diet(int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, Goal goal, List<Meal> meals, User user) {
		this.kCal = kCal;
		this.carbonHydrates = carbonHydrates;
		this.proteins = proteins;
		this.fats = fats;
		this.calorieMin = calorieMin;
		this.calorieMax = calorieMax;
		this.recommendedTime = recommendedTime;
		this.goal = goal;
		this.meals = meals;
		this.user = user;
	}

	public Diet(int id, int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, Goal goal, List<Meal> meals, User user) {
		this.id = id;
		this.kCal = kCal;
		this.carbonHydrates = carbonHydrates;
		this.proteins = proteins;
		this.fats = fats;
		this.calorieMin = calorieMin;
		this.calorieMax = calorieMax;
		this.recommendedTime = recommendedTime;
		this.goal = goal;
		this.meals = meals;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Diet [kCal=" + kCal + ", carbonHydrates=" + carbonHydrates + ", proteins=" + proteins + ", fats=" + fats
				+ ", calorieMin=" + calorieMin + ", calorieMax=" + calorieMax + ", goal=" + goal + ", meals=" + meals
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getkCal() {
		return kCal;
	}

	public void setkCal(int kCal) {
		this.kCal = kCal;
	}

	public int getCarbonHydrates() {
		return carbonHydrates;
	}

	public void setCarbonHydrates(int carbonHydrates) {
		this.carbonHydrates = carbonHydrates;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public int getFats() {
		return fats;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	
	
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public int getCalorieMin() {
		return calorieMin;
	}

	public void setCalorieMin(int calorieMin) {
		this.calorieMin = calorieMin;
	}

	public int getCalorieMax() {
		return calorieMax;
	}

	public void setCalorieMax(int calorieMax) {
		this.calorieMax = calorieMax;
	}

	public int getRecommendedTime() {
		return recommendedTime;
	}

	public void setRecommendedTime(int recommendedTime) {
		this.recommendedTime = recommendedTime;
	}
    
	
	
	
}
