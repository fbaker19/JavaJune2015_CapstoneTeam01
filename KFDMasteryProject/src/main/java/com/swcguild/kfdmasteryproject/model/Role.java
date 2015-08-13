/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Role {
  private int roleId;
  private String RoleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.roleId;
        hash = 29 * hash + Objects.hashCode(this.RoleName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (!Objects.equals(this.RoleName, other.RoleName)) {
            return false;
        }
        return true;
    }
    
    
    
}
