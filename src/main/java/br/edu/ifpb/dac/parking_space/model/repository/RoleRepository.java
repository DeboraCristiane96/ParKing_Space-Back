package br.edu.ifpb.dac.parking_space.model.repository;

import br.edu.ifpb.dac.parking_space.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Optional<Role> findByName(String name);
    public boolean existsByName(String name);

}

