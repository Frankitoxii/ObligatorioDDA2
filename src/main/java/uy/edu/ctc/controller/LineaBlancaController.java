package uy.edu.ctc.controller;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.entity.LineaBlanca;
import uy.edu.ctc.repository.ElectrodomesticoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/lineaBlanca")
public class LineaBlancaController {
	
@Autowired
ElectrodomesticoRepository lineaBlancaRepository;

@GetMapping(value = "/list")
public List<Electrodomestico> readAll(){
	List<Electrodomestico> lineaBlanca = StreamSupport
			.stream(lineaBlancaRepository.findAll().spliterator(), false)
			.collect(Collectors.toList());
	return lineaBlanca;
}

@PostMapping
LineaBlanca createLineaBlanca(@RequestBody LineaBlanca lineaBlanca) {
	return lineaBlancaRepository.save(lineaBlanca);
}

@DeleteMapping("/delete/{id}")
public void delete(@PathVariable Long id) {
	lineaBlancaRepository.deleteById(id);
}
 
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody LineaBlanca lineaBlancaDetails, 
			@PathVariable Long id){
		Optional<Electrodomestico> lineaBlanca = lineaBlancaRepository.findById(id);
		if(!lineaBlanca.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		lineaBlanca.get().setNombre(lineaBlancaDetails.getNombre());
		lineaBlanca.get().setMarca	(lineaBlancaDetails.getMarca());
		lineaBlanca.get().setPrecio(lineaBlancaDetails.getPrecio());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(lineaBlancaRepository.save(lineaBlanca.get()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<Electrodomestico> lineaBlanca = lineaBlancaRepository.findById(id);
		if(!lineaBlanca.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lineaBlanca);
	}
}
