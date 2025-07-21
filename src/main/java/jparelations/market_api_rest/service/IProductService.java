package jparelations.market_api_rest.service;

import jparelations.market_api_rest.controller.DTO.ProductDTO;
import jparelations.market_api_rest.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();

    List<ProductDTO> findByPriceInRange(BigDecimal minprice, BigDecimal maxPrice);

    ProductDTO findById(Long id);

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO productDTO);

    String delete(Long id);

}
