package com.mrp.services;

import com.mrp.dtos.GameDTO;
import com.mrp.dtos.GameMinDTO;
import com.mrp.entities.Game;
import com.mrp.exceptions.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrp.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Jogo não encontrado com ID: " + id));
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        if (result.isEmpty()) throw new GameNotFoundException("Nenhum jogo encontrado");
        return result.stream().map(GameMinDTO::new).toList();
    }

}
