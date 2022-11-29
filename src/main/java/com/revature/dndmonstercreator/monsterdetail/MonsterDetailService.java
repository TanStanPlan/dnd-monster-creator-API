package com.revature.dndmonstercreator.monsterdetail;


import com.revature.dndmonstercreator.monsterdetail.dto.requests.NewMonsterDetailCreationRequest;
import com.revature.dndmonstercreator.monsterdetail.dto.requests.UpdateMonsterDetailRequest;
import com.revature.dndmonstercreator.monsterdetail.dto.responses.MonsterDetailResponse;
import com.revature.dndmonstercreator.util.exceptions.InvalidUserInputException;
import com.revature.dndmonstercreator.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Predicate;

@Service
public class MonsterDetailService {

    private MonsterDetailRepository monsterDetailRepository;

    @Autowired
    public MonsterDetailService(MonsterDetailRepository monsterDetailRepository) {
        this.monsterDetailRepository = monsterDetailRepository;

    }
    @Transactional
    public MonsterDetailResponse CreateMonsterDetail(NewMonsterDetailCreationRequest newMonsterDetailCreationRequest) throws InvalidUserInputException {
        MonsterDetail newMonsterDetail = new MonsterDetail(newMonsterDetailCreationRequest);

        return new MonsterDetailResponse(monsterDetailRepository.save(newMonsterDetail));
    }

    @Transactional
    public void update(UpdateMonsterDetailRequest updateMonsterDetailRequest, int monsterDetailId) throws InvalidUserInputException{
        MonsterDetail foundMonsterDetail = monsterDetailRepository.findById(monsterDetailId).orElseThrow(ResourceNotFoundException::new);
        Predicate<String> notNullOrEmpty = (str) -> str != null && !str.trim().equals("");
        Predicate<Integer> notZero = (i) -> i == 0;

        if(notNullOrEmpty.test(updateMonsterDetailRequest.getName())){
            foundMonsterDetail.setName(updateMonsterDetailRequest.getName());
        }
        if(notZero.test(updateMonsterDetailRequest.getArmorClass())){
            foundMonsterDetail.setArmorClass(updateMonsterDetailRequest.getArmorClass());
        }
        if(notZero.test(updateMonsterDetailRequest.getHitPoints())){
            foundMonsterDetail.setHitPoints(updateMonsterDetailRequest.getHitPoints());
        }
        if(notZero.test(updateMonsterDetailRequest.getSpeed())){
            foundMonsterDetail.setSpeed(updateMonsterDetailRequest.getSpeed());
        }
        if(notNullOrEmpty.test(updateMonsterDetailRequest.getSize())){
            foundMonsterDetail.setSize(updateMonsterDetailRequest.getSize());
        }
        if(notNullOrEmpty.test(updateMonsterDetailRequest.getAlignment())){
            foundMonsterDetail.setAlignment(updateMonsterDetailRequest.getAlignment());
        }
        if(notNullOrEmpty.test(updateMonsterDetailRequest.getChallengeRating())){
            foundMonsterDetail.setChallengeRating(updateMonsterDetailRequest.getChallengeRating());
        }
        if(notZero.test(updateMonsterDetailRequest.getStrength())){
            foundMonsterDetail.setStrength(updateMonsterDetailRequest.getStrength());
        }
        if(notZero.test(updateMonsterDetailRequest.getDexterity())){
            foundMonsterDetail.setDexterity(updateMonsterDetailRequest.getDexterity());
        }
        if(notZero.test(updateMonsterDetailRequest.getConstitution())){
            foundMonsterDetail.setConstitution(updateMonsterDetailRequest.getConstitution());
        }
        if(notZero.test(updateMonsterDetailRequest.getIntelligence())){
            foundMonsterDetail.setIntelligence(updateMonsterDetailRequest.getIntelligence());
        }
        if(notZero.test(updateMonsterDetailRequest.getWisdom())){
            foundMonsterDetail.setWisdom(updateMonsterDetailRequest.getWisdom());
        }
        if(notZero.test(updateMonsterDetailRequest.getCharisma())){
            foundMonsterDetail.setCharisma(updateMonsterDetailRequest.getCharisma());
        }

    }

    @Transactional
    public Optional<MonsterDetail> findByUser(int id) { return monsterDetailRepository.findByUser(id);}



}
