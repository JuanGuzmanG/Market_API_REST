package jparelations.market_api_rest.persitence;

import jparelations.market_api_rest.model.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void update(Maker maker);

    void deleteById(Long id);
}
