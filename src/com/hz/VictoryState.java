package com.hz;

public class VictoryState {

    private String name;
    private int fieldOne;
    private int fieldTwo;
    private int fieldThree;

    public VictoryState(String name, int fieldOne, int fieldTwo, int fieldThree) {
        this.name = name;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVictorious() {

        boolean allFieldMatches = fieldOne == fieldTwo
                && fieldOne == fieldThree;

        boolean fieldsAreNotDefaults = fieldOne != -1;

        return allFieldMatches && fieldsAreNotDefaults;
    }
}
