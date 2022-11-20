package br.edu.ifpb.dac.parking_space.business.service;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.dac.parking_space.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
// métodos que são necessários para manipular o tokem
public interface TokenService {

    String generate(User user);

    Claims getClaims(String token) throws ExpiredJwtException;

    boolean isValid(String token);

    String getUserName(String token);

    Integer getUserId(String token);

    String get(HttpServletRequest request);
}