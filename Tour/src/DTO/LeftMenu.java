/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


public class LeftMenu extends JPanel implements MouseListener{
    private JLabel lb,icon;
    private Color hover = new Color(100, 113, 140);
    private Color normal = new Color(240,240,240);
    //private Color normal = new Color(100, 113, 140);
    private boolean active ;
    private String name,img,imgActive,imgHover;
    private Dimension size = new Dimension();
    public LeftMenu(String name, Dimension size, String icon)
    {
        this.setLayout(null);
        
        lb = new JLabel(name);
        lb.setBounds(50, 1, 210, 45);
        lb.setFont(new Font("Time New Roman", Font.BOLD, 12));
        
        JLabel lbIcon = new JLabel();
        Icon Icon = new ImageIcon(this.getClass().getResource("/ICON/" + icon));
        lbIcon.setIcon(Icon);
        lbIcon.setBounds(20, 0, 30, 45);
        
        this.add(lb);
        this.add(lbIcon);
        this.setPreferredSize(size);
        this.setBorder(new MatteBorder(0, 1, 1, 1, new Color(0, 51, 255)));
        this.addMouseListener(this);
        init();
    }
        
    public void init()
    {
        if(active)
        {
            setBackground(Color.WHITE);
        }
        else
        {
            setBackground(normal);
        } 
    }
    public void setColorNormal(Color color)
    {
        this.normal = color;
        setBackground(normal);
        repaint();   
    }
   
    
    public void doActive()
    {
        active = true;
        lb.setForeground(new Color(0,0,0));
        setBackground(new Color(51,102,255));
    }
    public void noActive()
    {
        active = false;
        setBackground(normal);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!active)
        {
            setBackground(hover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(!active)
        {
            setBackground(normal);
        }
    }
}
