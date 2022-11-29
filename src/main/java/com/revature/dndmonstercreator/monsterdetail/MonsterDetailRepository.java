package com.revature.dndmonstercreator.monsterdetail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterDetailRepository extends CrudRepository<MonsterDetail, Integer> {

    @Query(value = "FROM MonsterDetail WHERE user_id= :userId")
    Optional<MonsterDetail> findByUser(int userId);

}
