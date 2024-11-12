package com.mrp.controllers;

import com.mrp.dtos.GameDTO;
import com.mrp.dtos.GameMinDTO;
import com.mrp.exceptions.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.mrp.services.GameService;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO game = gameService.findById(id);
        if (game == null) throw new GameNotFoundException
                (
                    "jogo com o ID" + id + "não encontrado."
                );
        return game;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> games = gameService.findAll();
        if (games.isEmpty()) throw new GameNotFoundException(
                "Nenhum jogo encontrado"
        );
        return games;
    }

    @ExceptionHandler(GameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleGameNotFoundException(GameNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(RuntimeException  ex) {
        return "Erro interno do servidor: " + ex.getMessage();
    }
}
