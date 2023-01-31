package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
public interface PrestamoService {

	Page<Prestamo> findPage(PrestamoSearchDto dto);

	List<Prestamo> findAll();

	Page<Prestamo> find(PrestamoSearchDto dto, Long gameId, Long clientId, Date fecha);

	void save(Long id, PrestamoDto data);

	boolean isPrestamoReserved(PrestamoDto data);

	boolean exceedPrestamos(PrestamoDto data);

	void delete(Long id);

}
