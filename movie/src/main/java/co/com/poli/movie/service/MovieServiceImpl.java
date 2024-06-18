package co.com.poli.movie.service;


import co.com.poli.movie.model.Showtime;
import co.com.poli.movie.persistence.entity.Movie;
import co.com.poli.movie.persistence.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;



    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ExpressionException("Movie not found"));
    }

}
