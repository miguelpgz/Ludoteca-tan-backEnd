package com.ccsw.tutorial.client;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.client.model.Client;

/**
 * @author ccsw
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

	// @Query("select g from Client g where (:name is g.name")
	// Client find(@Param("name") String name);
	Client findByName(String name);
}
