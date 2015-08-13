/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Role;
import com.swcguild.kfdmasteryproject.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class PeopleImpl implements PeopleInterface{
    
    private static final String SQL_INSERT_USER ="INSERT INTO users (user_name, password) VALUES (?,?)";
    private static final String SQL_DELETE_USER ="DELETE FROM users WHERE user_id = ? ";
    private static final String SQL_UPDATE_USER ="UPDATE users SET user_name = ?, password =?  WHERE = user_id?";

    private static final String SQL_INSERT_ROLE ="INSERT INTO roles (role_name) VALUES (?)";
    private static final String SQL_DELETE_ROLE ="DELETE FROM roles WHERE role_id = ? ";
    private static final String SQL_UPDATE_ROLE ="UPDATE roles SET role_name = ? WHERE = role_id?";
    
    public JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public User addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUserName(),
                user.getPassword());
        
        user.setUserId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return user;
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    @Override
    public void editUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUserName(),
                user.getPassword(),
                user.getUserId());
    }

    @Override
    public Role addRole(Role role) {
          jdbcTemplate.update(SQL_INSERT_ROLE,
                role.getRoleName());
          
        role.setRoleId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return role;
    }

    @Override
    public void deleteRole(int roleId) {
        jdbcTemplate.update(SQL_DELETE_ROLE, roleId);
    }

    @Override
    public void editRole(Role role) {
        jdbcTemplate.update(SQL_UPDATE_ROLE,
                role.getRoleId(),
                role.getRoleName());
    }
    
}
