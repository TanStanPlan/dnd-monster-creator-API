package com.revature.dndmonstercreator.monsterdetail;

import com.revature.dndmonstercreator.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "monster_details")
public class MonsterDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monster_detail_id")
    private int id;

    private String name;

    @Column(name = "armor_class")
    private int armorClass;

    @Column(name = "hit_points")
    private int hitPoints;

    private int speed;

    private String size;

    private String alignment;

    @Column(name = "challenge_rating")
    private String challengeRating;

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

}
