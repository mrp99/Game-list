package com.mrp.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
@NoArgsConstructor
@Data
public class Belonging {

    //class auxiliar
    @EmbeddedId
    private BelongingPk id = new BelongingPk();
    private Integer position;

    public Belonging(Game game, GameList gameList, Integer position) {
        id.setGame(game);
        id.setList(gameList);
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                (obj instanceof Belonging
                        && Objects.equals(id, ((Belonging) obj).id));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
