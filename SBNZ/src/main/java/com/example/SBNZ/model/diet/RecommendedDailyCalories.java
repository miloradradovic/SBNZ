package com.example.SBNZ.model.diet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dailyCalories")
public class RecommendedDailyCalories {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "weightFrom", nullable = false)
	private int weightFrom;
	
	@Column(name = "weightTo", nullable = false)
	private int weightTo;
	
	@Column(name = "kCal", nullable = false)
	private int kCal;

}
