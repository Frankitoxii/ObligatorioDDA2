package uy.edu.ctc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.entity.UsoPersonal;
import uy.edu.ctc.repository.ElectrodomesticoRepository;

@RestController
@RequestMapping("/usoPersonal")
public class UsoPersonalController {
	
		
	@Autowired
	ElectrodomesticoRepository usoPersonalRepository;

	@GetMapping
	List<Electrodomestico> getUsoPersonal() {
	    return usoPersonalRepository.findAll();
	}

	@PostMapping
	UsoPersonal createUsoPersonal(@RequestBody UsoPersonal usoPersonal) {
		return usoPersonalRepository.save(usoPersonal);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		usoPersonalRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody UsoPersonal usoPersonalDetails, 
			@PathVariable Long id){
		Optional<Electrodomestico> usoPersonal = usoPersonalRepository.findById(id);
		if(!usoPersonal.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usoPersonal.get().setNombre(usoPersonalDetails.getNombre());
		usoPersonal.get().setMarca	(usoPersonalDetails.getMarca());
		usoPersonal.get().setPrecio(usoPersonalDetails.getPrecio());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usoPersonalRepository.save(usoPersonal.get()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<Electrodomestico> usoPersonal = usoPersonalRepository.findById(id);
		if(!usoPersonal.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usoPersonal);
	}
}
