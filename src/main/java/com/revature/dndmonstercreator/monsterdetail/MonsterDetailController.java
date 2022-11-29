package com.revature.dndmonstercreator.monsterdetail;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/monster")
public class MonsterDetailController {

    private final MonsterDetailService monsterDetailService;

    public MonsterDetailController(MonsterDetailService monsterDetailService) {
        this.monsterDetailService = monsterDetailService;
    }




}
