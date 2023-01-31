package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.prestamo.model.Prestamo;

/**
 * @author ccsw
 */
public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

	Page<Prestamo> findAll(Pageable pageable);

	// Query para aplicar los filtros correspondientes

	@Query("SELECT p FROM Prestamo p WHERE (:gameId IS NULL OR p.game.id = :gameId) AND (:clientId IS NULL OR p.client.id = :clientId) AND (:fechaPrestamo IS NULL OR (p.fecha_prestamo <= :fechaPrestamo AND p.fecha_devolucion > :fechaPrestamo))")
	Page<Prestamo> find(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId,
			@Param("fechaPrestamo") Date fechaPrestamo);

	// Query para comprobar si el juego está prestado en un tiempo determinado
	@Query("SELECT p FROM Prestamo p WHERE p.game.id = :juegoId "
			+ "AND ((p.fecha_prestamo >= :fechaPrestamo AND p.fecha_prestamo <= :fechaDevolucion) "
			+ "OR (p.fecha_devolucion >= :fechaPrestamo AND p.fecha_devolucion <= :fechaDevolucion))")
	List<Prestamo> findPrestamosByJuegoAndFechas(@Param("juegoId") Long juegoId,
			@Param("fechaPrestamo") Date fechaPrestamo, @Param("fechaDevolucion") Date fechaDevolucion);

	// Query para obtener el número de préstamos de un cliente en un tiempo
	// determinado
	@Query("SELECT count(p) FROM Prestamo p WHERE p.client.id = :clientId AND (:fechaInicio BETWEEN p.fecha_prestamo AND p.fecha_devolucion OR :fechaFin BETWEEN p.fecha_prestamo AND p.fecha_devolucion)")
	int countPrestamosByClientIdAndFechaInicioFechaFin(@Param("clientId") Long clientId,
			@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

}
