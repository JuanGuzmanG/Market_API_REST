package jparelations.market_api_rest.repository;

import jparelations.market_api_rest.model.Maker;
import org.springframework.data.repository.CrudRepository;

public interface MakerRepository extends CrudRepository<Maker, Long> {
}
