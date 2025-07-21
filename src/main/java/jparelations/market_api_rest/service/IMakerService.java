package jparelations.market_api_rest.service;

import jparelations.market_api_rest.controller.DTO.MakerDTO;
import jparelations.market_api_rest.model.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    List<MakerDTO> findAll();

    MakerDTO findById(Long id);

    MakerDTO save(MakerDTO maker);

    MakerDTO update(Long id, MakerDTO makerDTO);

    String deleteById(Long id);
}
