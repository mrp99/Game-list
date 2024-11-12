package com.mrp.services;

import com.mrp.dtos.GameListDTO;
import com.mrp.entities.GameList;
import com.mrp.exceptions.GameNotFoundException;
import com.mrp.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        if (result.isEmpty()) throw new GameNotFoundException(
                "Nenhuma Lista de jogos foi encontrado."
        );
        return  result.stream().map(GameListDTO::new).toList();
    }
}
