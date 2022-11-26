package com.revature.dndmonstercreator.monsterdetail.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMonsterDetailCreationRequest {

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
}
