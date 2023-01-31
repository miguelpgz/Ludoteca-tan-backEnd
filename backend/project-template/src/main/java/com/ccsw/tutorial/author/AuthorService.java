package com.ccsw.tutorial.author;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.author.model.Author;
import com.ccsw.tutorial.author.model.AuthorDto;
import com.ccsw.tutorial.author.model.AuthorSearchDto;

/**
 * @author ccsw
 */
public interface AuthorService {

	/**
	 * Recupera un {@link com.ccsw.tutorial.author.model.Author} a través de su ID
	 * 
	 * @param id
	 * @return
	 */
	Author get(Long id);

	List<Author> findAll();

	Page<Author> findPage(AuthorSearchDto dto);

	/**
	 * Método para crear o actualizar un
	 * {@link com.ccsw.tutorial.author.model.Author}
	 * 
	 * @param id
	 * @param data
	 */
	void save(Long id, AuthorDto data);

	/**
	 * Método para crear o actualizar un
	 * {@link com.ccsw.tutorial.author.model.Author}
	 * 
	 * @param id
	 */
	void delete(Long id);

}
