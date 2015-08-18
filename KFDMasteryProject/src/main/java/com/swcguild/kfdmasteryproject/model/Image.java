/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.model;

import java.util.Objects;
import org.hibernate.engine.jdbc.BinaryStream;

/**
 *
 * @author apprentice
 */
public class Image {
    
   private int image_id;
   private byte[] image;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    
   
   
    
}
