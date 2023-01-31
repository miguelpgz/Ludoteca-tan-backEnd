package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

/**
 * @author ccsw
 *
 */
public interface ClientService {

	/**
	 * Método para recuperar todas las {@link com.ccsw.tutorial.client.model.Client}
	 * 
	 * @return
	 */
	Client get(Long id);

	Client getClientByName(String name);

	List<Client> findAll();

	/**
	 * Método para crear o actualizar una
	 * {@link com.ccsw.tutorial.client.model.Client}
	 * 
	 * @param dto
	 * @return
	 */
	void save(Long id, ClientDto dto);

	/**
	 * Método para borrar una {@link com.ccsw.tutorial.client.model.Client}
	 * 
	 * @param id
	 */
	void delete(Long id);
}
