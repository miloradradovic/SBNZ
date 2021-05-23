package com.example.SBNZ.model.diet;

import java.util.ArrayList;

import javax.persistence.Column;

import com.example.SBNZ.enums.diet.Goal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diet {

	//output1
    private int kCal;
    
    //output2
    private int carbonHydrates;
    
    //output3
    private int proteins;
    
    //output4
    private int fats;
    
    //hidden
    private Goal goal;
    
    private ArrayList<Meal> meals = new ArrayList<Meal>();

	@Override
	public String toString() {
		return "Diet [kCal=" + kCal + ", carbonHydrates=" + carbonHydrates + ", proteins=" + proteins + ", fats=" + fats
				+ "]";
	}
    
}
