package com.revature.dndmonstercreator.monsterdetail;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterDetailRepository extends CrudRepository<MonsterDetail, Integer> {

}
