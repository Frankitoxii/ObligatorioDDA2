package uy.edu.ctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import uy.edu.ctc.entity.Electrodomestico;

@NoRepositoryBean
public interface ElectrodomesticoRepository extends JpaRepository<Electrodomestico, Long>{

}
