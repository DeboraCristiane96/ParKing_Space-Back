package br.edu.ifpb.dac.parking_space.business.service;

import br.edu.ifpb.dac.parking_space.model.entity.Role;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {

    public Collection<Role> getAuthorities();

    public String getPassword();

    public String getUsername();

    public boolean isAccountaNonExpired();

    public boolean isAccountNonLocked();

    public boolean isEnabled();

}
