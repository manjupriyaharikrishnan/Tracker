package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT,value="/vehicles")
    public void load(@RequestBody List<Vehicle> vehicles) {
        vehicleService.load(vehicles);
    }

    @RequestMapping(method = RequestMethod.POST,value="/readings")
    public void update(@RequestBody Reading reading){
        //System.out.println(reading);
        vehicleService.updateReading(reading);
    }

}
