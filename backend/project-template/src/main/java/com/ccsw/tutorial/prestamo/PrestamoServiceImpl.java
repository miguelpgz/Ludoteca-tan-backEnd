package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired
	PrestamoRepository prestamoRepository;

	@Autowired
	PrestamoService prestamoService;

	@Autowired
	GameService gameService;

	@Autowired
	ClientService clientService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page<Prestamo> findPage(PrestamoSearchDto dto) {

		return this.prestamoRepository.findAll(dto.getPageable());
	}

	@Override
	public List<Prestamo> findAll() {

		return (List<Prestamo>) this.prestamoRepository.findAll();
	}

	@Override
	public Page<Prestamo> find(PrestamoSearchDto dto, Long gameId, Long clientId, Date fecha) {

		return this.prestamoRepository.find(dto.getPageable(), gameId, clientId, fecha);
	}

	@Override
	public void save(Long id, PrestamoDto dto) {

		Prestamo prestamo = null;

		if (id == null)
			prestamo = new Prestamo();
		else
			prestamo = this.prestamoRepository.findById(id).orElse(null);

		BeanUtils.copyProperties(dto, prestamo, "id", "game", "client");

		prestamo.setClient(clientService.get(dto.getClient().getId()));
		prestamo.setGame(gameService.get(dto.getGame().getId()));

		this.prestamoRepository.save(prestamo);
	}

	@Override
	public boolean isPrestamoReserved(PrestamoDto dto) {

		List<Prestamo> prestamos = this.prestamoRepository.findPrestamosByJuegoAndFechas(dto.getGame().getId(),
				dto.getFecha_prestamo(), dto.getFecha_devolucion());

		// Si la lista no está vacía quiere decir que el juego está prestado en el
		// intervalo de tiempo definido
		return !prestamos.isEmpty();
	}

	@Override
	public boolean exceedPrestamos(PrestamoDto dto) {

		int numPrestamos = this.prestamoRepository.countPrestamosByClientIdAndFechaInicioFechaFin(
				dto.getClient().getId(), dto.getFecha_prestamo(), dto.getFecha_devolucion());

		// si excede el número de préstamos
		if (numPrestamos >= 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void delete(Long id) {

		System.out.println("id" + id);
		this.prestamoRepository.deleteById(id);
		;

	}

}
