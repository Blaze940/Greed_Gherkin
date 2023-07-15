package com.esgi.greedgherkin.domain;

public enum ScoreValue {
    SINGLE_ONE(100),
    SINGLE_FIVE(50),
    TRIPLE_ONE(1000),
    THREE_PAIRS(800),
    STRAIGHT(1200);

    private final int value;

    ScoreValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
