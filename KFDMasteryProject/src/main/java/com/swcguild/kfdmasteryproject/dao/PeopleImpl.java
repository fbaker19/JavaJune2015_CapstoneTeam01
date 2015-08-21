/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.Role;

import com.swcguild.kfdmasteryproject.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author apprentice
 */
public class PeopleImpl implements PeopleInterface{
    
    private static final String SQL_INSERT_USER ="INSERT INTO users (user_name, password) VALUES (?,?)";
    private static final String SQL_DELETE_USER ="DELETE FROM users WHERE user_id = ? ";
    private static final String SQL_UPDATE_USER ="UPDATE users SET user_name = ?, password =?  WHERE = user_id?";
    private static final String SQL_SELECT_USER = "SELECT * FROM users WHERE user_name=?";
    
    private static final String SQL_INSERT_ROLE ="INSERT INTO roles (role_name) VALUES (?)";
    private static final String SQL_DELETE_ROLE ="DELETE FROM roles WHERE role_id = ? ";
    private static final String SQL_UPDATE_ROLE ="UPDATE roles SET role_name = ? WHERE = role_id?";
    
    public JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public UserModel addUser(UserModel userModel) {
        jdbcTemplate.update(SQL_INSERT_USER,
                userModel.getUserName(),
                //userModel.getRoleId(),
                userModel.getPassword());
        
        userModel.setUserId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return userModel;
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }
    
    public UserModel getUserByName (String userName){
        try {
    return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userName);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        
    }

    @Override
    public void editUser(UserModel userModel) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                userModel.getUserName(),
                userModel.getPassword(),
                //userModel.getRoleId(),
                userModel.getUserId());
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
    
    private static final class UserMapper implements ParameterizedRowMapper<UserModel> {

        @Override
        public UserModel mapRow(ResultSet rs, int i) throws SQLException {
           
            UserModel userModel = new UserModel();
            userModel.setUserId(rs.getInt("user_id"));
            userModel.setUserName(rs.getString("user_name"));
            userModel.setPassword(rs.getString("password"));
            //userModel.setRoleId(rs.getInt("role_id"));

            return userModel;
        }

        
        }
    }
