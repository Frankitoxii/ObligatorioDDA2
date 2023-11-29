package uy.edu.ctc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.repository.ElectrodomesticoRepository;


public class ElectrodomesticoServiceImpl implements ElectrodomesticoService{
	   private final ElectrodomesticoRepository  electrodomesticoRepository;

	    @Autowired
	    public ElectrodomesticoServiceImpl(ElectrodomesticoRepository electrodomesticoRepository) {
	        this.electrodomesticoRepository = electrodomesticoRepository;
	    }

	    @Override
	    public Iterable<Electrodomestico> findAll() {
	        return electrodomesticoRepository.findAll();
	    }

	    @Override
	    public Page<Electrodomestico> findAll(Pageable pageable) {
	        return electrodomesticoRepository.findAll(pageable);
	    }

	    @Override
	    public Optional<Electrodomestico> findById(Long id) {
	        return electrodomesticoRepository.findById(id);
	    }

	    @Override
	    public Electrodomestico save(Electrodomestico Electrodomestico) {
	        return electrodomesticoRepository.save(Electrodomestico);
	    }

	    @Override
	    public void deleteById(Long id) {
	    	electrodomesticoRepository.deleteById(id);
	    }
}
