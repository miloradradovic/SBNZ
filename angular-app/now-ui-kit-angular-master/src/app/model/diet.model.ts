export interface DataInputModel {
    currentWeight:number,
    goalWeight:number,
    programDuration:number,
    fatPercentage: number,
    healthIssues: String[],
    junkFoodFrequency: String,
    dailyCalBurn: number
}

export interface MealModel{
    kCal: number,
    carbonHydrates: number,
    proteins: number,
    fats: number,
    name: String,
    mealType: String,
    junkPercentage: number,
    recipe: String
}

export interface DietModel{
    kCal: number,
    carbonHydrates: number,
    proteins: number,
    fats: number,
    meals: MealModel[]
}

