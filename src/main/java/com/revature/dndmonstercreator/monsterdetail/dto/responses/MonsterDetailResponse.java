package com.revature.dndmonstercreator.monsterdetail.dto.responses;

import com.revature.dndmonstercreator.monsterdetail.MonsterDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonsterDetailResponse {

    private int id;

    private String name;

    private int armorClass;

    private int hitPoints;

    private int speed;

    private String size;

    private String alignment;

    private String challengeRating;

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    public MonsterDetailResponse(MonsterDetail monsterDetail) {
        this.id = monsterDetail.getId();
        this.name = monsterDetail.getName();
        this.armorClass = monsterDetail.getArmorClass();
        this.hitPoints = monsterDetail.getHitPoints();
        this.speed = monsterDetail.getSpeed();
        this.size = monsterDetail.getSize();
        this.alignment = monsterDetail.getAlignment();
        this.challengeRating = monsterDetail.getChallengeRating();
        this.strength = monsterDetail.getStrength();
        this.dexterity = monsterDetail.getDexterity();
        this.constitution = monsterDetail.getConstitution();
        this.intelligence = monsterDetail.getIntelligence();
        this.wisdom = monsterDetail.getWisdom();
        this.charisma = monsterDetail.getCharisma();
    }
}
