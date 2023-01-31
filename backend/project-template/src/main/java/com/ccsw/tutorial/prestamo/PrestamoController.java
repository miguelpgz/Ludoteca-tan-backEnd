package com.ccsw.tutorial.prestamo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
@RequestMapping(value = "/prestamo")
@RestController
@CrossOrigin(origins = "*")
public class PrestamoController {

	@Autowired
	PrestamoService prestamoService;

	@Autowired
	BeanMapper beanMapper;

	/**
	 * Método para recuperar un listado paginado de
	 * {@link com.ccsw.tutorial.author.model.Prestamo}
	 * 
	 * @param dto
	 * @return
	 */

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Page<PrestamoDto> find(@RequestBody PrestamoSearchDto dto,
			@RequestParam(value = "gameId", required = false) Long gameId,
			@RequestParam(value = "clientId", required = false) Long clientId,
			@RequestParam(value = "fechaPrestamo", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaPrestamo) {

		Page<Prestamo> prestamos = prestamoService.find(dto, gameId, clientId, fechaPrestamo);

		return beanMapper.mapPage(prestamos, PrestamoDto.class);
	}

	/**
	 * Método para crear un préstamo {@link com.ccsw.tutorial.author.model.Prestamo}
	 * 
	 * @param id
	 */
	@RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamoDto data) {

		this.prestamoService.save(id, data);
	}

	/**
	 * Método para comprobar si un juego está reservado por otro cliente en el
	 * intervalo de tiempo correspondiente
	 */
	@RequestMapping(path = { "/check-availability" }, method = RequestMethod.POST)
	public boolean isPrestamoReserved(@RequestBody PrestamoDto data) {

		return this.prestamoService.isPrestamoReserved(data);
	}

	/**
	 * Método para comprobar si un cliente excede el número de juegos a alquilar en
	 * el intervalo de tiempo correspondiente
	 */

	@RequestMapping(path = { "/check-exceed" }, method = RequestMethod.POST)
	public boolean exceedPrestamos(@RequestBody PrestamoDto data) {

		return this.prestamoService.exceedPrestamos(data);
	}

	/**
	 * Método para eliminar un préstamo}
	 * 
	 * @param id PK de la entidad
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {

		this.prestamoService.delete(id);
	}

}
