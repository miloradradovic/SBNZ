package com.example.SBNZ.model.diet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.SBNZ.enums.diet.HealthIssue;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	
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
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @ManyToMany
    @JoinTable(
      name = "ingredient_meal", 
      joinColumns = @JoinColumn(name = "meal_id"), 
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Meal> meals = new HashSet<Meal>();
    
    @ElementCollection(targetClass = HealthIssue.class)
    @JoinTable(name = "healthIssues", joinColumns = @JoinColumn(name = "ingredient_id"))
    @Column(name = "healthIssueTypes", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<HealthIssue> healthIssueTypes = new HashSet<HealthIssue>();
}
