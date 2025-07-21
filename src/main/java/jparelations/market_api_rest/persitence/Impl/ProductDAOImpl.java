package jparelations.market_api_rest.persitence.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jparelations.market_api_rest.model.Product;
import jparelations.market_api_rest.persitence.IProductDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByPriceInRange(BigDecimal minprice, BigDecimal maxPrice) {
        return this.em.createQuery("SELECT p FROM Product p " +
                        "WHERE p.price " +
                        "BETWEEN :minPrice AND :maxPrice", Product.class)
                .setParameter("minPrice", minprice)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(this.em.find(Product.class, id));
    }

    @Override
    @Transactional
    public void save(Product product) {
        this.em.persist(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        this.em.merge(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.em.remove(this.em.find(Product.class, id));
    }
}
