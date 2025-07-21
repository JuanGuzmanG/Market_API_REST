package jparelations.market_api_rest.service.Impl;

import jparelations.market_api_rest.controller.DTO.MakerDTO;
import jparelations.market_api_rest.model.Maker;
import jparelations.market_api_rest.persitence.IMakerDAO;
import jparelations.market_api_rest.service.IMakerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<MakerDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return makerDAO.findAll()
                .stream()
                .map(product -> modelMapper.map(product, MakerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MakerDTO findById(Long id) {
        if(this.makerDAO.findById(id).isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this.makerDAO.findById(id).get(), MakerDTO.class);
        }
        return new MakerDTO();
    }

    @Override
    public MakerDTO save(MakerDTO maker) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Maker makerEntity = modelMapper.map(maker, Maker.class);
            this.makerDAO.save(makerEntity);
            return maker;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving maker: " + e.getMessage());
        }
    }

    @Override
    public MakerDTO update(Long id, MakerDTO makerDTO) {
        if(this.makerDAO.findById(id).isPresent()){
            Maker maker = this.makerDAO.findById(id).get();
            maker.setName(makerDTO.getName());
            maker.getProducts().clear();
            maker.getProducts().addAll(makerDTO.getProducts());
            this.makerDAO.update(maker);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(maker, MakerDTO.class);
        } else {
            throw new UnsupportedOperationException("Maker with ID " + id + " not found.");
        }
    }

    @Override
    public String deleteById(Long id) {
        if(this.makerDAO.findById(id).isPresent()){
            this.makerDAO.deleteById(id);
            return "Maker with ID " + id + " deleted successfully.";
        } else {
            throw new UnsupportedOperationException("Maker with ID " + id + " not found.");
        }
    }
}
