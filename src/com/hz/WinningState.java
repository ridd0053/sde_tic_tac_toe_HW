package com.hz;

public class WinningState {

    private String name;
    private int fieldOne;
    private int fieldTwo;
    private int fieldThree;

    public WinningState(String name, int fieldOne, int fieldTwo, int fieldThree) {
        this.name = name;
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.fieldThree = fieldThree;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAchieved() {

        boolean allFieldMatches = fieldOne == fieldTwo
                && fieldOne == fieldThree;

        boolean fieldsAreNotDefaults = fieldOne != -1;

        return allFieldMatches && fieldsAreNotDefaults;
    }
}
