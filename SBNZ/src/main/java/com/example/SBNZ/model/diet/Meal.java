package com.example.SBNZ.model.diet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.SBNZ.enums.diet.MealType;

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
	
    @Column(name = "name", unique=true, nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    private MealType mealType;
     
    @Column(name = "junkPercentage", nullable = false)
    private int junkPercentage;
   
    @ManyToMany(mappedBy = "meals")
    private List<Ingredient> ingredientList;
    
    @Column(name = "recipe", nullable = true)
    private String recipe;

    
}
