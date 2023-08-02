package com.midominio.biblioteca1.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 12)
	private String titulo;
	
	@NotEmpty
	private String autor;
	
	@NotEmpty
	private String genero;
	
	@Column(name = "numero_ejemplares")
	@NotNull	
	private int numEjemplares;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public Libro() {}
	
}
