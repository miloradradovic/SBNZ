package com.example.SBNZ.model.diet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.diet.MealType;
import com.example.SBNZ.enums.training.Muscle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "kCal", nullable = false)
    private int kCal;
    
    @Column(name = "carbonHydrates",  nullable = false)
    private int carbonHydrates;
    
    @Column(name = "proteins", nullable = false)
    private int proteins;
    
    @Column(name = "fats", nullable = false)
    private int fats;
	
    @Column(name = "name", unique=true, nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    private MealType mealType;
     
    @Column(name = "junkPercentage", nullable = false)
    private int junkPercentage;
   
    @ElementCollection(targetClass = HealthIssue.class, fetch = FetchType.EAGER)
    @JoinTable(name = "healthIssueTypes", joinColumns = @JoinColumn(name = "meal_id"))
    @Column(name = "healthIssueTypes", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<HealthIssue> healthIssueTypes;
    
    
    @Column(name = "recipe", nullable = true)
    private String recipe;

	public Meal(int kCal, int carbonHydrates, int proteins, int fats, String name, MealType mealType, int junkPercentage, Set<HealthIssue> healthIssueTypes, String recipe) {
		this.kCal = kCal;
		this.carbonHydrates = carbonHydrates;
		this.proteins = proteins;
		this.fats = fats;
		this.name = name;
		this.mealType = mealType;
		this.junkPercentage = junkPercentage;
		this.healthIssueTypes = healthIssueTypes;
		this.recipe = recipe;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public MealType getMealType() {
		return mealType;
	}


	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}


	public int getJunkPercentage() {
		return junkPercentage;
	}


	public void setJunkPercentage(int junkPercentage) {
		this.junkPercentage = junkPercentage;
	}


	public Set<HealthIssue> getHealthIssueTypes() {
		return healthIssueTypes;
	}


	public void setHealthIssueTypes(Set<HealthIssue> healthIssueTypes) {
		this.healthIssueTypes = healthIssueTypes;
	}


	public String getRecipe() {
		return recipe;
	}


	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}


	@Override
	public String toString() {
		return "Meal [id=" + id + ", kCal=" + kCal + ", carbonHydrates=" + carbonHydrates + ", proteins=" + proteins
				+ ", fats=" + fats + ", name=" + name + ", mealType=" + mealType + ", junkPercentage=" + junkPercentage
				+ ", healthIssueTypes=" + healthIssueTypes + ", recipe=" + recipe + "]";
	}

    
    
    
}
