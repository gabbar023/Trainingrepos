package com.rakuten.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.MovieDAO;
import com.rakuten.training.domain.Movie;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
		SpringApplication.run(MoviesApplication.class, args);
		testFullMovieDAO(springContainer);
		
	}
	public static void testFullMovieDAO(ApplicationContext springContainer) {

		MovieDAO dao = springContainer.getBean(MovieDAO.class);

		Movie m1 = new Movie("Avengers","Movie based on Superheroes created by Marvel ",1,20,"action");
		Movie saved = dao.save(m1);
		System.out.println("Saved Product with id : " + saved.getId());
		List<Movie> all = dao.findAll();
		System.out.println("there are " + all.size() + " Movies.");
		List<Movie> m=dao.findByNameLike("Avengers");
			System.out.println(m.size());

	}

}
