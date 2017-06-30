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
@RequestMapping(value="/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.POST,value="/readings", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody Reading reading)
    {
        vehicleService.updateReading(reading);

    }


    @RequestMapping(method = RequestMethod.PUT,value = "/vehicles",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void load(@RequestBody List<Vehicle> vehicles) {
      vehicleService.load(vehicles);
    }
}
