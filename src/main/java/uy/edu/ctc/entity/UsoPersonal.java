package uy.edu.ctc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class UsoPersonal extends Electrodomestico{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int potencia;

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public UsoPersonal(String nombre, String marca, Double precio, int potencia) {
		super(nombre, marca, precio);
		this.potencia = potencia;
	}
	
	public UsoPersonal() {
		
	}
}
