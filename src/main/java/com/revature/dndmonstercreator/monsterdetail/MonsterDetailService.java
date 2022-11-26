package com.revature.dndmonstercreator.monsterdetail;


import com.revature.dndmonstercreator.monsterdetail.dto.requests.NewMonsterDetailCreationRequest;
import com.revature.dndmonstercreator.monsterdetail.dto.responses.MonsterDetailResponse;
import com.revature.dndmonstercreator.util.exceptions.InvalidUserInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
