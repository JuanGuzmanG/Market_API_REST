package jparelations.market_api_rest.controller;

import jparelations.market_api_rest.controller.DTO.ProductDTO;
import jparelations.market_api_rest.model.Product;
import jparelations.market_api_rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/all")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find/price-range")
    public ResponseEntity<List<ProductDTO>> findByPriceInRange(@RequestParam BigDecimal minprice, @RequestParam BigDecimal maxPrice) {
        return new ResponseEntity<>(this.productService.findByPriceInRange(minprice, maxPrice), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.save(productDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.update(id, productDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.delete(id), HttpStatus.OK);
    }
}
