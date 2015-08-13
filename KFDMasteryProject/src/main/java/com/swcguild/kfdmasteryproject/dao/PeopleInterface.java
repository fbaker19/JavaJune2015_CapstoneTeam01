/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Role;
import com.swcguild.kfdmasteryproject.model.User;

/**
 *
 * @author apprentice
 */
public interface PeopleInterface {
    
    public User addUser(User user);
    public void deleteUser(int userId);
    public void editUser(User user); 
    
        
    public Role addRole(Role role);
    public void deleteRole(int roleId);
    public void editRole(Role role); 
}
