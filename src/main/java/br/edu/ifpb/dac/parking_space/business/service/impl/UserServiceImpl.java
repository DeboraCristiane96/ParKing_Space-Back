package br.edu.ifpb.dac.parking_space.business.service.impl;

import br.edu.ifpb.dac.parking_space.business.service.PasswordEnconderService;
import br.edu.ifpb.dac.parking_space.business.service.RoleService;
import br.edu.ifpb.dac.parking_space.business.service.UserService;
import br.edu.ifpb.dac.parking_space.model.entity.Role;
import br.edu.ifpb.dac.parking_space.model.entity.User;
import br.edu.ifpb.dac.parking_space.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEnconderService passwordEncoderService;

    @Override
    public User save(User user) {
        if(user == null){

        }
        return null;
    }
//O usuário já está no banco de dados. Pode ser que você possa tentar atualizá-lo
    @Override
    public User update(User user) {
        if(user.getId()!= null){
            throw new IllegalStateException("User is already in the database. May be you can try update it");
        }
        //antes de salvar é preciso criptografar
        passwordEncoderService.encryptPassword(user);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findDefault());
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) { }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User finsByUserName(String userName) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public List<User> find(User filter) {
        return null;
    }

    @Override
    public Optional<Object> findByRegistration(long parseLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }

    //
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = finsByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("Could not find any user with username$",username));
        }
        return (UserDetails) user;
    }
}
