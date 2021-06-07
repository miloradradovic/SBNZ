package com.example.SBNZ.model.training.cep;

public class CEPOutput {

    private int type; // 1 - high, 2 - low, 3 - dangerous exercise

    public CEPOutput() {
    }

    public CEPOutput(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
