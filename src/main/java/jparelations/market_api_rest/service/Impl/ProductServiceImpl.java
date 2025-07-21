package jparelations.market_api_rest.service.Impl;
import jparelations.market_api_rest.controller.DTO.ProductDTO;
import jparelations.market_api_rest.model.Product;
import jparelations.market_api_rest.persitence.IProductDAO;
import jparelations.market_api_rest.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<ProductDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return productDAO.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByPriceInRange(BigDecimal minprice, BigDecimal maxPrice) {
        return List.of();
    }

    @Override
    public ProductDTO findById(Long id) {
        if(this.productDAO.findById(id).isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this.productDAO.findById(id).get(), ProductDTO.class);
        }
        return new ProductDTO();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Product product = modelMapper.map(productDTO, Product.class);
            this.productDAO.save(product);
            return productDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving product: " + e.getMessage());
        }
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        if(this.productDAO.findById(id).isPresent()){
            Product product = this.productDAO.findById(id).get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            this.productDAO.update(product);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(product, ProductDTO.class);
        }
        throw new UnsupportedOperationException("Product with ID " + id + " not found.");
    }

    @Override
    public String delete(Long id) {
        if(this.productDAO.findById(id).isPresent()){
            this.productDAO.deleteById(id);
            return "Product with ID " + id + " deleted successfully.";
        }
        throw new UnsupportedOperationException("Product with ID " + id + " not found.");
    }
}
