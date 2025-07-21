package jparelations.market_api_rest.persitence;

import jparelations.market_api_rest.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal minprice, BigDecimal maxPrice);

    Optional<Product> findById(Long id);

    void save(Product product);

    void update(Product product);

    void deleteById(Long id);

}
