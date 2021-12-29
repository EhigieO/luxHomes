package com.luxhomes.luxhomes.home;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;


    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    public String addNewHome(Home home) {
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
}

