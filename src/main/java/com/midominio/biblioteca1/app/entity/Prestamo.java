package com.midominio.biblioteca1.app.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	
	// [<<<---START]
	// RELACION LINEA DE PEDIDO Y ARTICULO MUCHOS A 1 (UNIDIRECCIONAL LINEA -> ARTICULO)  	
	// Artículo de la línea
	// El enlace se produce utilizando el campo tienda de la clase Pedido y es bidireccional
	// Descarga los elementos relacionados de forma NO perezosa
	// El borrado se produce en cascada
	/*
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="libro_id")
	private Libro libro;
	*/
	


}
