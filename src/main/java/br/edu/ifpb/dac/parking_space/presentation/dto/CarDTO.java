package br.edu.ifpb.dac.parking_space.presentation.dto;

import br.edu.ifpb.dac.parking_space.model.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarDTO {

    private Integer id;

    @NotBlank(message = "É obrigatório informar qual é o modelo")
    private String model;

    @NotNull(message = "A placa do carro não pode ser nulo!")
    private String licensePlateCar;

    @NotBlank(message = "É obrigatório informar qual é o ano")
    private String year;

    @NotBlank(message = "É obrigatório informar qual a cor")
    private String color;

    @NotBlank(message = "É obrigatório informar qual é o nome do responsável")
    private User nameResponsibleCar;

    public CarDTO() {
    }

    public CarDTO(Integer id, @NotBlank(message = "É obrigatório informar qual é o modelo") String model, @NotNull(message = "A placa do carro não pode ser nulo!") String licensePlateCar, @NotBlank(message = "É obrigatório informar qual é o ano") String year, @NotBlank(message = "É obrigatório informar qual a cor") String color, @NotBlank(message = "É obrigatório informar qual é o nome do responsável") User nameRsponsibleCar) {
        this.id = id;
        this.model = model;
        this.licensePlateCar = licensePlateCar;
        this.year = year;
        this.color = color;
        this.nameResponsibleCar = nameResponsibleCar;
    }

    public CarDTO(@NotBlank(message = "É obrigatório informar qual é o modelo") String model, @NotNull(message = "A placa do carro não pode ser nulo!") String licensePlateCar, @NotBlank(message = "É obrigatório informar qual é o ano") String year, @NotBlank(message = "É obrigatório informar qual a cor") String color, @NotBlank(message = "É obrigatório informar qual é o nome do responsável") User nameResponsibleCar) {
        this.model = model;
        this.licensePlateCar = licensePlateCar;
        this.year = year;
        this.color = color;
        this.nameResponsibleCar = nameResponsibleCar;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getNameResponsibleCar() {
        return nameResponsibleCar;
    }

    public void setNameResponsibleCar(User nameResponsibleCar) {
        this.nameResponsibleCar = nameResponsibleCar;
    }
}