package br.edu.ifpb.dac.parking_space.presentation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.edu.ifpb.dac.parking_space.model.entity.Car;
import br.edu.ifpb.dac.parking_space.model.entity.Role;
import br.edu.ifpb.dac.parking_space.model.entity.User;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Integer id;

    @NotBlank(message = "É obrigatório informar o nome do usuário!")
    @Size(min = 3, max = 255, message = "Nome inválido! Deve possuir mais que 3 caracteres")
    private String name;

    @NotBlank(message = "É obrigatório informar a data de nascimento!")
    @Pattern(regexp = "^\\d\\d\\d\\d-\\d\\d-\\d\\d$",
            message = "A data deve ter formato 'yyyy-MM-dd'")
    private String birthDate;

    @NotNull(message = "É obrigatório informar o email!")
    private String email;

    @NotNull(message = "É obrigatório informar um número de telefone!")
    private String phoneNumber;

    @NotNull(message = "É obrigatório informar um número do apartamento!")
    private String apartmentNumber;

    @NotNull(message = "É obrigatório informar o bloco!")
    private String block;

    @NotNull(message = "É obrigatório informar uma senha!")
    private String password;

    private User user;

    private List<Role> roles;

    private Set<Car> cars;


    public UserDTO() { }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApartmentNumber() { return apartmentNumber; }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Set<Car> getCars() { return cars; }

    public void setCars(Set<Car> cars) { this.cars = cars; }

    public List<Role> getRoles() {return roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }
}