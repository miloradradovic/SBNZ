package com.example.SBNZ.model.diet;

import com.example.SBNZ.enums.diet.MealType;

public class SearchDiet {

	private String mealType;
	private int kcalFrom;
	private int kcalTo;
	private int proteinFrom;
	private int proteinTo;
	private int fatFrom;
	private int fatTo;
	private int carbsFrom;
	private int carbsTo;
	
	public SearchDiet(String mealType, int kcalFrom, int kcalTo, int proteinFrom, int proteinTo, int fatFrom,
			int fatTo, int carbsFrom, int carbsTo) {
		super();
		this.mealType = mealType;
		this.kcalFrom = kcalFrom;
		this.kcalTo = kcalTo;
		this.proteinFrom = proteinFrom;
		this.proteinTo = proteinTo;
		this.fatFrom = fatFrom;
		this.fatTo = fatTo;
		this.carbsFrom = carbsFrom;
		this.carbsTo = carbsTo;
	}

	
	
	public int getFatFrom() {
		return fatFrom;
	}



	public void setFatFrom(int fatFrom) {
		this.fatFrom = fatFrom;
	}



	public int getFatTo() {
		return fatTo;
	}



	public void setFatTo(int fatTo) {
		this.fatTo = fatTo;
	}



	public SearchDiet() {
		super();
	}
	
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public int getKcalFrom() {
		return kcalFrom;
	}
	public void setKcalFrom(int kcalFrom) {
		this.kcalFrom = kcalFrom;
	}
	public int getKcalTo() {
		return kcalTo;
	}
	public void setKcalTo(int kcalTo) {
		this.kcalTo = kcalTo;
	}
	public int getProteinFrom() {
		return proteinFrom;
	}
	public void setProteinFrom(int proteinFrom) {
		this.proteinFrom = proteinFrom;
	}
	public int getProteinTo() {
		return proteinTo;
	}
	public void setProteinTo(int proteinTo) {
		this.proteinTo = proteinTo;
	}
	public int getCarbsFrom() {
		return carbsFrom;
	}
	public void setCarbsFrom(int carbsFrom) {
		this.carbsFrom = carbsFrom;
	}
	public int getCarbsTo() {
		return carbsTo;
	}
	public void setCarbsTo(int carbsTo) {
		this.carbsTo = carbsTo;
	}
	
	
	
}
