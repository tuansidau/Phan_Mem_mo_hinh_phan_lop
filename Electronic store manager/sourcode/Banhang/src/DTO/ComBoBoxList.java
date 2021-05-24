/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.Icon;

/**
 *
 * @author HOANG MINH HUY
 */
public class ComBoBoxList 
{
    private Icon img;
   private String name;

    public ComBoBoxList(Icon img, String name) {
        this.img = img;
        this.name = name;
    }
   public ComBoBoxList() {
        this.img = img;
        this.name = name;
    }

    public Icon getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setImg(Icon img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
