package jparelations.market_api_rest.repository;

import jparelations.market_api_rest.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

/*    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minprice AND :maxprice")
    List<Product> findByPriceInRange(BigDecimal minprice, BigDecimal maxprice);

    List<Product> findProductByPriceBetween(BigDecimal minprice, BigDecimal maxprice);*/
}
