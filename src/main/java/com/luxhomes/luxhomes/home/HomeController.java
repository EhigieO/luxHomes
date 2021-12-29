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
        return homeService.saveHome(home);
    }

    @GetMapping(path = "/homes")
    public List<Home> homes(){
        return homeService.getAllHomes();
    }

    @DeleteMapping(path = "/{homeId}")
    public String deleteHome(@PathVariable Long homeId){
        return homeService.deleteHome(homeId);
    }

    @PutMapping(path = "/{homeId}")
    public void updateStudent(@PathVariable("homeId") Long homeId,
                              @RequestParam(required = false) Boolean availability,
                              @RequestParam(required = false) Double rentPerYear){
        homeService.updateHome(homeId, availability, rentPerYear);
    }
}
