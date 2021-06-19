export interface TrainingModel {
    sessions: SessionModel[],
    restTime: number,
    numberOfSession: number,
    muscles: String[]
}

export interface SessionModel {
    exerciseDTO: ExerciseModel,
    weight: number,
    repetitions: number,
    duration: number
}

export interface ExerciseModel {
    name: String,
    description: String,
    difficulty: String,
    exerciseCategory: String,
    muscleList: String[]
}

export interface InputDataTraining {
    currentWeight:number,
    goalWeight:number,
    programDuration:number,
    difficulty: String,
    injuries: String[],
    equipment: boolean
}