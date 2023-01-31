package com.ccsw.tutorial.prestamo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Prestamo")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@Column(name = "fecha_prestamo", nullable = false)
	private Date fecha_prestamo;

	@Column(name = "fecha_devolucion", nullable = false)
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
	 * @return fechaReserva
	 */
	public Date getFecha_prestamo() {

		return this.fecha_prestamo;
	}

	/**
	 * @param fechaReserva new value of {@link #getTitle}.
	 */
	public void setFecha_prestamo(Date fecha_prestamo) {

		this.fecha_prestamo = fecha_prestamo;
	}

	/**
	 * @return fechaDevolucion
	 */

	/**
	 * @return game
	 */
	public Game getGame() {

		return this.game;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	/**
	 * @param game new value of {@link #getCategory}.
	 */
	public void setGame(Game game) {

		this.game = game;
	}

	/**
	 * @return client
	 */
	public Client getClient() {

		return this.client;
	}

	/**
	 * @param client new value of {@link #getAuthor}.
	 */
	public void setClient(Client client) {

		this.client = client;
	}

}
