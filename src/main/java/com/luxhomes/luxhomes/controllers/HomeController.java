package com.luxhomes.luxhomes.controllers;

import com.luxhomes.luxhomes.dtos.addHome.AddHomeDto;
import com.luxhomes.luxhomes.services.HomeService;
import com.luxhomes.luxhomes.models.Home;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/lux/")
@AllArgsConstructor
public class HomeController {
    private final HomeService homeService;


    @GetMapping(path = "/homes")
    public List<Home> homes(){
        return homeService.getAllHomes();
    }

    @DeleteMapping(path = "/{homeId}")
    public String deleteHome(@PathVariable Long homeId){
        return homeService.deleteHome(homeId);
    }

    @PutMapping(path = "/{homeId}")
    public void updateHome(@PathVariable("homeId") Long homeId,
                              @RequestParam(required = false) Boolean availability,
                              @RequestParam(required = false) Double rentPerYear){
        homeService.updateHome(homeId, availability, rentPerYear);
    }
    @PostMapping(path = "/home/add_new_home")
    public String addHome(@RequestBody final AddHomeDto addHomeDto){
        return homeService.addNewHome(addHomeDto);
    }
}
