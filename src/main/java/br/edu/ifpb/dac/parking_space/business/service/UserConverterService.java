package br.edu.ifpb.dac.parking_space.business.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.dac.parking_space.model.entity.User;
import br.edu.ifpb.dac.parking_space.model.entity.Role;
import br.edu.ifpb.dac.parking_space.presentation.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserConverterService {

        public User dtoToUser(UserDTO dto) {
            if (dto != null) {
                User entity = new User();

                entity.setId(dto.getId());
                entity.setName(dto.getName());
                entity.setBirthDate(dto.getBirthDate());
                entity.setEmail(dto.getEmail());
                entity.setPhoneNumber(dto.getPhoneNumber());
                entity.setApartmentNumber(dto.getApartmentNumber());
                entity.setBlock(dto.getBlock());
                entity.setPassword(dto.getPassword());

                return entity;
            }
            throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
        }

        public UserDTO userToDto(User entity) {

            if (entity != null) {

                UserDTO dto = new UserDTO();

                dto.setName(entity.getName());
                dto.setEmail(entity.getEmail());
                dto.setBirthDate(entity.getBirthDate());
                dto.setEmail(entity.getEmail());
                dto.setPhoneNumber(entity.getPhoneNumber());
                dto.setApartmentNumber(entity.getApartmentNumber());
                dto.setBlock(entity.getBlock());
                dto.setPassword(entity.getPassword());
                dto.setRoles((List<Role>) entity.getAuthorities());

                return dto;
            }

            throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
        }

        public List<User> dtosToUsers(List<UserDTO> dtoList) {

            if (dtoList != null) {
                List<User> entityList = new ArrayList<>();

                User entity = null;

                if (dtoList != null && !dtoList.isEmpty()) {
                    for (UserDTO dto : dtoList) {
                        entity = dtoToUser(dto);
                        entityList.add(entity);
                    }
                }

                return entityList;
            }

            throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
        }

        public List<UserDTO> usersToDtos(List<User> entityList) {
            if (entityList != null) {
                List<UserDTO> dtoList = new ArrayList<>();

                UserDTO dto = null;

                if (entityList != null && !entityList.isEmpty()) {
                    for (User user: entityList) {
                        dto = userToDto(user);
                        dtoList.add(dto);
                    }
                }

                return dtoList;
            }

            throw new IllegalArgumentException("Não foi possível converter pois o objeto é nulo");
        }


}


