package br.edu.ifpb.dac.parking_space.business.service;


import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.dac.parking_space.model.entity.Car;
import br.edu.ifpb.dac.parking_space.presentation.dto.CarDTO;
import org.springframework.stereotype.Service;

@Service
public class CarConverterService {

    public Car dtoToPlace(CarDTO dto) {

        if (dto != null) {
            Car entity = new Car(dto.getModel(), dto.getLicensePlateCar(), dto.getYear(), dto.getColor(),dto.getNameResponsibleCar());

            return entity;
        }

        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }

    public CarDTO carToDto(Car entity) {

        if (entity != null) {
            CarDTO dto = new CarDTO(entity.getModel(), entity.getLicensePlateCar(), entity.getYear(), entity.getColor(),entity.getNameResponsibleCar());

            return dto;
        }

        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }

    public List<Car> dtosToPlaces(List<CarDTO> dtoList) {

        if (dtoList != null) {
            List<Car> entityList = new ArrayList<>();

            Car entity = null;

            if (!dtoList.isEmpty()) {
                for (CarDTO dto: dtoList) {
                    entity = dtoToPlace(dto);
                    entityList.add(entity);
                }
            }

            return entityList;
        }

        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }

    public List<CarDTO> carsToDtos(List<Car> entityList) {
        if (entityList != null) {
            List<CarDTO> dtoList = new ArrayList<>();

            CarDTO dto = null;

            if (!entityList.isEmpty()) {
                for (Car car: entityList) {
                    dto = carToDto(car);
                    dtoList.add(dto);
                }
            }

            return dtoList;
        }

        throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
    }

}