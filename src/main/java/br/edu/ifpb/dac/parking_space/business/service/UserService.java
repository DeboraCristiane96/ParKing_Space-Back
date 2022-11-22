package br.edu.ifpb.dac.parking_space.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.parking_space.model.entity.User;
import br.edu.ifpb.dac.parking_space.model.repository.UserRepository;
import br.edu.ifpb.dac.parking_space.presentation.exception.MissingFieldException;
import br.edu.ifpb.dac.parking_space.presentation.exception.ObjectAlreadyExistsException;
import br.edu.ifpb.dac.parking_space.presentation.exception.ObjectNotFoundException;

@Service

public interface UserService extends UserDetailsService {


    public User save(User user);
    public User update(User user);
    public void delete(Integer id);
    public User findById(Integer id);
    public User findByEmail(String email);
    public User finsByUserName(String userName);
    public Iterable<User> findAll();
    public List<User> find(User filter);
    Optional<Object> findByRegistration(long parseLong);
    public void deleteById(Integer id);
}
