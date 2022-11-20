package br.edu.ifpb.dac.parking_space.business.service;

import br.edu.ifpb.dac.parking_space.model.entity.User;

public interface PasswordEnconderService {

    void encryptPassword(User user);
}
