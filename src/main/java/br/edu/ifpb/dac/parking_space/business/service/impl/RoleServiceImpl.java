package br.edu.ifpb.dac.parking_space.business.service.impl;

import br.edu.ifpb.dac.parking_space.business.service.RoleService;
import br.edu.ifpb.dac.parking_space.model.entity.Role;
import br.edu.ifpb.dac.parking_space.model.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createDefaultValues() {
        for(AVALIABLE_ROLES avaliableRoles : AVALIABLE_ROLES.values()){
            Role role =  findByName(avaliableRoles.name());

            if(role == null){
                role = new Role();
                role.setName(avaliableRoles.name());
                roleRepository.save(role);
            }
        }
    }

    @Override
    public Role findByName(String name) {
        if(name == null){
            throw new IllegalStateException("Name connt be null");
        }
        Optional<Role> optional = roleRepository.findByName(name);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Role findDefault() {
        return findByName(AVALIABLE_ROLES.USER.name());
    }
}
