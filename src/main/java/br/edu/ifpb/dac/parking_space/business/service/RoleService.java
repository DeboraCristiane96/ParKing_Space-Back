package br.edu.ifpb.dac.parking_space.business.service;
import br.edu.ifpb.dac.parking_space.model.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    public enum AVALIABLE_ROLES { ADMIN, USER }

    public void createDefaultValues();

    public Role findByName(String name);

    public Role findDefault();

}