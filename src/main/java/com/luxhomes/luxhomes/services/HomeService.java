package com.luxhomes.luxhomes.services;

import com.luxhomes.luxhomes.models.Home;
import com.luxhomes.luxhomes.models.Review;
import com.luxhomes.luxhomes.repositories.HomeRepository;
import com.luxhomes.luxhomes.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeService {

    private final ReviewService reviewService;
    private final HomeRepository homeRepository;


    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    public Home findHomeById(Long homeId){
        Optional<Home> home = homeRepository.findHomeById(homeId);
        return home.orElse(null);
    }
    public String saveHome(Home home) {
        homeRepository.save(home);
        return "home saved";
    }

    public String deleteHome(Long homeId) {
        boolean exists = homeRepository.existsById(homeId);
        if (!exists){
            throw new IllegalStateException("home with id " + homeId + " does not exist");
        }
        homeRepository.deleteById(homeId);
        return "home deleted";
    }

    @Transactional
    public String updateHome(Long homeId, Boolean availability, Double rentPerYear) {
        Home home = homeRepository.findById(homeId).orElseThrow(() -> new IllegalStateException(
                "home with id " + homeId +" does not exists"));

        if(!Objects.equals(home.getAvailability(), availability)){
            home.setAvailability(availability);
        }
        if (rentPerYear != null && rentPerYear > 0 && !Objects.equals(home.getRentPerYear(), rentPerYear)){
            home.setRentPerYear(rentPerYear);
        }
        return "homeUpdated";
    }
    public String addReview(Long homeId,Review review){
        Home home = findHomeById(homeId);
        if (home == null) throw new NoSuchElementException("Home does not exist");
        reviewService.addReview(review);
        home.getReviews().add(review);
        saveHome(home);
        return "home review added";
    }
}

