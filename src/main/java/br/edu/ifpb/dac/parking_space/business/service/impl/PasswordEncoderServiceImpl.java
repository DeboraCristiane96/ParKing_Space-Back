package br.edu.ifpb.dac.parking_space.business.service.impl;

import br.edu.ifpb.dac.parking_space.business.service.PasswordEnconderService;
import br.edu.ifpb.dac.parking_space.model.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEnconderService {
    //Criptograga a senha do usuário no banco de dados
    @Override
    public void encryptPassword(User user) {
        if(user.getPassword() != null){
            String encryptedPassword = encode(user.getPassword());
            user.setPassword(encryptedPassword);
        }
    }
}
