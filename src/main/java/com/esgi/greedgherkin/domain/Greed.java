package com.esgi.greedgherkin.domain;


public class Greed {

    private int[] diceValueCounter ;

    public int score (int[] dice){
        initDiceValueCounter(dice);
        int totalScore = 0;

        //Check for special score
        totalScore += specialScore();
        if(totalScore > 0){
            return totalScore;
        }

        //Check for multiplied combo values
        totalScore += multipliedComboValues();

        //Check for singles 1 and 5
        if(diceValueCounter[1] <= 2){
            totalScore += diceValueCounter[1] * ScoreValue.SINGLE_ONE.getValue();
        }
        if (diceValueCounter[5] <= 2){
            totalScore += diceValueCounter[5] * ScoreValue.SINGLE_FIVE.getValue();
        }

        return totalScore;
    }


    //////////////////////////PRIVATE METHODS//////////////////////////
    private int specialScore(){
        int score = 0;
        //Check for straight
        if(isStraight()){
            score += ScoreValue.STRAIGHT.getValue();
            return score;
        }

        //Check for three pairs
        if(isThreePairs()){
            score += ScoreValue.THREE_PAIRS.getValue();
            return score;
        }

        //Check for six of a kind
        if(isSixOfAKind()){
            for(int i = 1; i < diceValueCounter.length; i++){
                if(diceValueCounter[i] == 6){
                    switch (i) {
                        case 1 -> score += ScoreValue.TRIPLE_ONE.getValue() * ScoreCombo.SIX_OF_A_KIND_MULTIPLIER.getValue();
                        case 2, 3, 4, 5, 6 ->
                                score += i * ScoreCombo.TRIPLE_OF_A_KIND_MULTIPLIER.getValue() * ScoreCombo.SIX_OF_A_KIND_MULTIPLIER.getValue();
                        default -> throw new IllegalStateException("Unexpected value: " + i);
                    }
                }
            }
            return score;
        }

        return score;
    }

    private int multipliedComboValues(){
        int score = 0;
        for(int i = 1; i < diceValueCounter.length; i++){
            if(diceValueCounter[i] == 3){
                switch (i) {
                    case 1 -> score += ScoreValue.TRIPLE_ONE.getValue() ;
                    case 2, 3, 4, 5, 6 ->
                            score += i * ScoreCombo.TRIPLE_OF_A_KIND_MULTIPLIER.getValue();
                    default -> throw new IllegalStateException("Unexpected value: " + i);
                }
            }

            if(diceValueCounter[i] == 4){
                switch (i) {
                    case 1 -> score += ScoreValue.TRIPLE_ONE.getValue() * ScoreCombo.FOUR_OF_A_KIND_MULTIPLIER.getValue();
                    case 2, 3, 4, 5, 6 ->
                            score += i * ScoreCombo.FOUR_OF_A_KIND_MULTIPLIER.getValue();
                    default -> throw new IllegalStateException("Unexpected value: " + i);
                }
            }

            if(diceValueCounter[i] == 5){
                switch (i) {
                    case 1 -> score += ScoreValue.TRIPLE_ONE.getValue() * ScoreCombo.FIVE_OF_A_KIND_MULTIPLIER.getValue();
                    case 2, 3, 4, 5, 6 ->
                            score += i * ScoreCombo.FIVE_OF_A_KIND_MULTIPLIER.getValue();
                    default -> throw new IllegalStateException("Unexpected value: " + i);
                }
            }
        }
        return score;
    }

    private void initDiceValueCounter(int [] dice){
        if(!isDiceValid(dice)){
            throw new IllegalArgumentException("Dice values must be between 1 and 6");
        }

        //First index is 0 and never used
        this.diceValueCounter = new int[]{0,0,0,0,0,0,0};

        for (int die : dice) {
            this.diceValueCounter[die]++;
        }
    }

    //Check if dice has good value (1 to 6)
    private boolean isDiceValid(int [] dice){
        for (int die : dice) {
            if(die < 1 || die > 6){
                return false;
            }
        }
        return true;
    }

    private boolean isStraight(){
        for (int i = 1; i < diceValueCounter.length; i++) {
            if(diceValueCounter[i] != 1){
                return false;
            }
        }
        return true;
    }

    private boolean isThreePairs(){
        int pairCounter = 0;
        for (int i = 1; i < diceValueCounter.length; i++) {
            if(diceValueCounter[i] == 2){
                pairCounter++;
            }
        }

        return pairCounter == 3;
    }

    private boolean isSixOfAKind(){
        for (int i = 1; i < diceValueCounter.length; i++) {
            if(diceValueCounter[i] == 6){
                return true;
            }
        }
        return false;
    }
}
