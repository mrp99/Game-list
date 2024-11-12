package com.mrp.controllers;

import com.mrp.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mrp.services.GameService;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
