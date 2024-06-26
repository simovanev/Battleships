package com.exam.battleships.models.dtos;

public class BattleDto {
    private long attackerId;
    private long defenderId;

    public int getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(long attackerId) {
        this.attackerId = attackerId;
    }

    public int getDefenderId() {
        return defenderId;
    }

    public void setDefenderId(long defenderId) {
        this.defenderId = defenderId;
    }
}
