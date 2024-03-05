package org.example;

public class Game {
    private Frame[] frames = new Frame[10];
    private int currentFrameIndex = 0;

    public Game() {
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame();
        }
    }

    public void roll(int pins) {
        Frame currentFrame = frames[currentFrameIndex];
        currentFrame.addRoll(pins);

        if (currentFrame.isCompleted() && currentFrameIndex < frames.length - 1) {
            currentFrameIndex++;
        }
    }

    public int score() {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.score();
        }
        return totalScore;
    }
}