package com.midominio.biblioteca1.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.midominio.biblioteca1.app.entity.Libro;

public interface ILibroRepository extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long>{
	
	    List<Libro> findByGenero(@Param("genero") String genero);
	/*    
	// Ejemplo 1: Obtener artículos por marca
    	@Query("SELECT a FROM Articulo a WHERE a.marca = :marca")
    	List<Articulo> findByMarca(@Param("marca") String marca);

	// Ejemplo 2: Obtener artículos por precio menor que un valor dado
    	@Query("SELECT a FROM Articulo a WHERE a.precio < :precio")
    	List<Articulo> findByPrecioLessThan(@Param("precio") Double precio);

    // Ejemplo 3: Obtener artículos por tipo y marca
    	@Query("SELECT a FROM Articulo a WHERE a.tipo = :tipo AND a.marca = :marca")
    	List<Articulo> findByTipoAndMarca(@Param("tipo") String tipo, @Param("marca") String marca);

    // Ejemplo 4: Obtener artículos por modelo que contiene una cadena específica
    	@Query("SELECT a FROM Articulo a WHERE a.modelo LIKE %:cadena%")
    	List<Articulo> findByModeloContaining(@Param("cadena") String cadena);

    // Ejemplo 5: Obtener artículos por cantidad de artículos entre un rango dado
    	@Query("SELECT a FROM Articulo a WHERE a.cantidadArticulos BETWEEN :min AND :max")
    	List<Articulo> findByCantidadArticulosBetween(@Param("min") Integer min, @Param("max") Integer max);

    // Ejemplo 6: Obtener el número total de artículos por tipo
    	@Query("SELECT COUNT(a) FROM Articulo a WHERE a.tipo = :tipo")
    	Long countByTipo(@Param("tipo") String tipo);

    // Ejemplo 7: Verificar si existe algún artículo con una marca específica
    	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Articulo a WHERE a.marca = :marca")
    	boolean existsByMarca(@Param("marca") String marca);
    	*/
}
