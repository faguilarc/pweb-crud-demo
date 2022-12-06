package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.TownDto;

import java.util.List;

public interface TownService {
    List<TownDto> getTowns();

    TownDto getTownById(Integer townId);

    void createTown(TownDto town);
    void updateTown(TownDto town);
    void deleteTown(TownDto town);
}
