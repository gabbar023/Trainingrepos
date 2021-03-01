package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Movie;


@Repository
@Transactional
public class MovieDAOJpaImpln implements MovieDAO
{
	@Autowired
	EntityManager em;
	
	@Override
	public Movie save(Movie toBeSaved) 
	{
		em.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public Movie findById(int id) {
		return em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findAll() {
		Query q = em.createQuery("select m from Movie as m");
		List<Movie> all = q.getResultList();
		return all;
	}

	@Override
	public List<Movie> findByNameLike(String name) {
		Query q = em.createQuery("select m from Movie m where m.name like fnParam");
		q.setParameter("fnParam", name);
		List<Movie> all = q.getResultList();
		return all;
	}

	@Override
	public void deleteById(int id) {
		Movie c = em.find(Movie.class, id);
		em.remove(c);
		
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		Query q = em.createQuery("select m from Movie m where m.genre=:fnParam");
		q.setParameter("fnParam", genre);
		List<Movie> all = q.getResultList();
		return all;
	}

	@Override
	public List<Movie> findByNumSongsGreaterThan(int num) {
		Query q = em.createQuery("select m from Movie m where m.numSongs>:fnParam");
		q.setParameter("fnParam", num);
		List<Movie> all = q.getResultList();
		return all;
	}
	
}
