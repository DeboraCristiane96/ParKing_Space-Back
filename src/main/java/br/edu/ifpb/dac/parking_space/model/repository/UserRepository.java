package br.edu.ifpb.dac.parking_space.model.repository;

import br.edu.ifpb.dac.parking_space.model.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByName(String name);
    public boolean existsByName(String name);
    public User exixtsById();
    public Optional<User> findByRegistration(Long registration);
    public boolean existsByRegistration(Long registration);
}