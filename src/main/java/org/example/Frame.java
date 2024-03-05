package org.example;

public class Frame {

    private Roll[] rolls = new Roll[2];
    private int currentRoll = 0;

    public Frame() {
        rolls[0] = new Roll(0);
        rolls[1] = new Roll(0);
    }

    public Boolean isStrike() {
        return rolls[0].getPins() == 10;
    }

    public Boolean isSpare() {
        return rolls[0].getPins() + rolls[1].getPins() == 10;
    }

    public boolean addRoll(int pins) {
        if (isStrike()) {
            return true;
        } else
        if (currentRoll < rolls.length) {
            rolls[currentRoll++] = new Roll(pins);
            return false;
        }
        return false;
    }

    public int score() {
        if (isStrike()) {
            return 10;
        } else if (isSpare()) {
            return 10;
        } else {
            return rolls[0].getPins() + rolls[1].getPins();
        }
    }

    public boolean isCompleted() {
        return currentRoll == rolls.length;
    }
}