package uy.edu.ctc.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.ctc.entity.Electrodomestico;

public interface ElectrodomesticoService {
	public Iterable<Electrodomestico> findAll();
	public Page<Electrodomestico> findAll(Pageable pageable);
	public Optional<Electrodomestico> findById(Long Id);
	public Electrodomestico save(Electrodomestico Electrodomestico);
	public void deleteById(Long Id);
}
