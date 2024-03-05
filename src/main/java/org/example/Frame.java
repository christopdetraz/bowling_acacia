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
        // Un spare est quand la somme des quilles renversées dans les deux lancers est égale à 10
        return !isStrike() && (rolls[0].getPins() + rolls[1].getPins() == 10);
    }

    public boolean addRoll(int pins) {
        // Si c'est un strike, le frame est terminé, on ne peut pas ajouter un autre lancer
        if (isStrike()) {
            return false;
        } else {
            if (currentRoll < rolls.length) {
                rolls[currentRoll++] = new Roll(pins);
                return true;
            }
            return false;
        }
    }

    public int score() {
        // Le score de base est la somme des quilles renversées
        int score = rolls[0].getPins() + rolls[1].getPins();
        // Si c'est un strike ou un spare, le score est 10 (les bonus seront ajoutés dans la classe Game)
        if (isStrike() || isSpare()) {
            score = 10;
        }
        return score;
    }

    public boolean isCompleted() {
        // Un frame est complet si deux lancers ont été joués ou si le premier lancer est un strike
        return currentRoll == rolls.length || isStrike();
    }
}
