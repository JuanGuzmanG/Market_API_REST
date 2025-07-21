package jparelations.market_api_rest.controller;

import jparelations.market_api_rest.controller.DTO.MakerDTO;
import jparelations.market_api_rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/makers")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<MakerDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.makerService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<MakerDTO>> findAll() {
        return new ResponseEntity<>(this.makerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MakerDTO> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        return new ResponseEntity<>(this.makerService.save(makerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MakerDTO> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) {
        return new ResponseEntity<>(this.makerService.update(id, makerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.makerService.deleteById(id), HttpStatus.OK);
    }
}
