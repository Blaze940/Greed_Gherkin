package com.esgi.greedgherkin.domain;

public enum ScoreCombo {
    TRIPLE_OF_A_KIND_MULTIPLIER(100),
    FOUR_OF_A_KIND_MULTIPLIER(2),
    FIVE_OF_A_KIND_MULTIPLIER(4),
    SIX_OF_A_KIND_MULTIPLIER(8);

    private final int value;

    ScoreCombo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
