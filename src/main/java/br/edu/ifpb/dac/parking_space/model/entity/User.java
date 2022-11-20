package br.edu.ifpb.dac.parking_space.model.entity;

import br.edu.ifpb.dac.parking_space.business.service.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "NAME_USER", nullable = false)
    private String name;

    @Column(name = "BIRTH_DATE", nullable = false)
    private String birthDate;

    @Column(name = "EMAIL_USER", nullable = true)
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phoneNumber;

    @Column(name = "APARTMENT_NUMBER", nullable = false,length = 30)
    private String apartmentNumber;

    @Column(name = "BLOCK", nullable = false, length = 20)
    private String block;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "USER_REGISTRATION", nullable = false)
    private Long registration;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToMany
    private Set<Car> cars;

    public User() { }

    public User(String name, String birthDate, String email, String phoneNumber, String apartmentNumber, String block, String password, Long registration) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.apartmentNumber = apartmentNumber;
        this.block = block;
        this.password = password;
        this.registration = registration;
    }

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

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Long getRegistration() { return registration; }

    public void setRegistration(Long registration) { this.registration = registration; }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountaNonExpired() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Role> getRoles() { return roles; }

    public Set<Car> getCars() { return cars; }

    public void setCars(Set<Car> cars) { this.cars = cars; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", block='" + block + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", cars=" + cars +
                '}';
    }
    @Override
    public Collection<Role> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setRoles(List<Role> roles) {
    }
}
