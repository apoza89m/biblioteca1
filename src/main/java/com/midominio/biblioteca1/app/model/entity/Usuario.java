package com.midominio.biblioteca1.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Digits.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 12)
	private String nombre;
	
	@Email
	private String email;
		
	@Column(name = "fecha_alta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate fechaAlta;
	
	
	//private Iterable<Libro> prestamos;
	

	private Libro[] prestamos;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Libro[] getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Libro[] prestamos) {
		this.prestamos = prestamos;
	}

	public Usuario() {}
	
}
