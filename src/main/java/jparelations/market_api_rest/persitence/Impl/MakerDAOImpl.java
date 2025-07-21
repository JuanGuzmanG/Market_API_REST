package jparelations.market_api_rest.persitence.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jparelations.market_api_rest.model.Maker;
import jparelations.market_api_rest.persitence.IMakerDAO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Maker> findAll() {
        return this.em.createQuery("from Maker", Maker.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maker> findById(Long id) {
        return Optional.ofNullable(this.em.find(Maker.class, id));
    }

    @Override
    @Transactional
    public void save(Maker maker) {
        this.em.persist(maker);
    }

    @Override
    @Transactional
    public void update(Maker maker) {
        this.em.merge(maker);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.em.remove(em.find(Maker.class, id));
    }
}
