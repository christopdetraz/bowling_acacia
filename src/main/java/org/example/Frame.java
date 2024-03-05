package org.example;

public class Frame {

    private Roll[] rolls = new Roll[2];
    private int currentRoll = 0;

    public Frame() {
        rolls[0] = new Roll(0);
        rolls[1] = new Roll(0);
    }

    public void addRoll(int pins) {
        if (currentRoll < rolls.length) {
            rolls[currentRoll++] = new Roll(pins);
        }
    }

    public int score() {
        return rolls[0].getPins() + rolls[1].getPins();
    }

    public boolean isCompleted() {
        return currentRoll == rolls.length;
    }
}