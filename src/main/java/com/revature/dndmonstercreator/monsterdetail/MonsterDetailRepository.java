package com.revature.dndmonstercreator.monsterdetail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterDetailRepository extends CrudRepository<MonsterDetail, Integer> {

    @Query(value = "SELECT MonsterDetail WHERE user_id= :user_id")
    Optional<MonsterDetail> findByUser(int user_id);

}
