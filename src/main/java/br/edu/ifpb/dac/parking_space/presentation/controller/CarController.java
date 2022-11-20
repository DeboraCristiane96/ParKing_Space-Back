package br.edu.ifpb.dac.parking_space.presentation.controller;


import java.util.List;
import java.util.Optional;

import br.edu.ifpb.dac.parking_space.business.service.CarService;
import br.edu.ifpb.dac.parking_space.model.entity.Car;
import br.edu.ifpb.dac.parking_space.presentation.dto.CarDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity <Object> seveCar(@RequestBody CarDTO cardto){
        if(carService.existsByLincensePlateCar(cardto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CREATED).body("Conflict: This license plate has already been registered");}
        var car  = new Car();
        BeanUtils.copyProperties(cardto,car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car)); }

    @GetMapping
    public ResponseEntity <List<Car>> getAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll()); }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Object> getOneCar(@PathVariable (value = "id") Integer id){
        Optional<Car> carOptional = carService.findById(id);
        if(!carOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found."); }
        return ResponseEntity.status(HttpStatus.OK).body(carOptional.get()); }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Object> deleteCar(@PathVariable (value = "id") Integer id){
        Optional<Car> carOptional = carService.findById(id);
        if(!carOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found."); }
        carService.deleteCar(carOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully."); }

    @PutMapping
    public ResponseEntity <Object> updateCar(@PathVariable (value = "id") Integer id, @RequestBody CarDTO cardto) {
        Optional<Car> carOptional = carService.findById(id);
        if (!carOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
        }
        var car = carOptional.get();
        car.setLicensePlateCar(cardto.getLicensePlateCar());
        car.setModel(cardto.getModel());
        car.setColor(cardto.getColor());
        car.setYear(cardto.getYear());
        return ResponseEntity.status(HttpStatus.OK).body(carService.saveCar(car)); }

}

