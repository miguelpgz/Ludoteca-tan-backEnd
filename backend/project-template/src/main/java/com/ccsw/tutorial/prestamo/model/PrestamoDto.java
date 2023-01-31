package com.ccsw.tutorial.prestamo.model;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * @author ccsw
 */
public class PrestamoDto {

	private Long id;

	private GameDto game;

	private ClientDto client;

	private Date fecha_prestamo;

	private Date fecha_devolucion;

	/**
	 * @return id
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * @param id new value of {@link #getId}.
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @return fecha prestamo
	 */
	public Date getFecha_prestamo() {

		return this.fecha_prestamo;
	}

	/**
	 * @param fecha_prestamo new value of {@link #getTitle}.
	 */
	public void setFecha_prestamo(Date fecha_prestamo) {

		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	/**
	 * @return game
	 */
	public GameDto getGame() {

		return this.game;
	}

	/**
	 * @param game new value of {@link #getCategory}.
	 */
	public void setGame(GameDto game) {

		this.game = game;
	}

	/**
	 * @return client
	 */
	public ClientDto getClient() {

		return this.client;
	}

	/**
	 * @param client new value of {@link #getAuthor}.
	 */
	public void setClient(ClientDto client) {

		this.client = client;
	}

}