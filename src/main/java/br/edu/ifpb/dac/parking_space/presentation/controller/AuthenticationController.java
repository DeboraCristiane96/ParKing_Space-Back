package br.edu.ifpb.dac.parking_space.presentation.controller;

import br.edu.ifpb.dac.parking_space.business.service.AuthenticationService;
import br.edu.ifpb.dac.parking_space.business.service.TokenService;
import br.edu.ifpb.dac.parking_space.business.service.UserConverterService;
import br.edu.ifpb.dac.parking_space.business.service.UserService;
import br.edu.ifpb.dac.parking_space.presentation.dto.LoginDTO;
import br.edu.ifpb.dac.parking_space.presentation.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserConverterService userConverterService; // private ConverterSystemUser converterSystemUser;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/loginAuth")
    public ResponseEntity login(@RequestBody LoginDTO dto) {

        // System.out.println(dto.getRegistration());
         System.out.println(dto.getUsername());
         System.out.println(dto.getPassword());

        return ResponseEntity.ok().build();

//		try {

//			String token = authenticationService.login(dto.getUsername(), dto.getPassword());
//			User entity = userService.findByRegistration(dto.getRegistration());
//
//			User entity = userService.findByUserName(dto.getUsername());
//
//			UserDto userDto = userConverterService.userToDTO(entity);
//
//			TokenDto tokenDto = new TokenDto(token, userDto);
//
//			return new ResponseEntity(tokenDto, HttpStatus.OK);
//
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
    }

    @PostMapping("/isValidToken")

    public ResponseEntity isTokenValid(@RequestBody String token) {

        System.out.println("teste: " + token);
        try {
            boolean isTokenValid = tokenService.isValid(token);

            return new ResponseEntity(true, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


       @PostMapping("/isTokenValid") public ResponseEntity isTokenValid(@RequestBody TokenDTO dto) {

        try { boolean isTokenValid = tokenService.isValid(dto.getToken());

       return new ResponseEntity(isTokenValid, HttpStatus.OK);

      } catch (Exception e) { return
       ResponseEntity.badRequest().body(e.getMessage()); } }



}
