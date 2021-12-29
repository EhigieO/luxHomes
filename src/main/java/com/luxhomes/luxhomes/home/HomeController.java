package com.luxhomes.luxhomes.home;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/lux-homes")
@AllArgsConstructor
public class HomeController {
    private final HomeService homeService;


    @PostMapping(path = "/add-home")
    public String addHome(@RequestBody Home home){
        return homeService.addNewHome(home);
    }

    @GetMapping(path = "/homes")
    public List<Home> homes(){
        return homeService.getAllHomes();
    }

    @DeleteMapping(path = "/delete-home")
    public String deleteHome(@RequestParam Long HomeId){
        return homeService.deleteHome(HomeId);
    }

}
