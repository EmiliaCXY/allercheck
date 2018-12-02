package gui;

import model.ResManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;

public class ResList extends JPanel{
    private JPanel displayer;
    private ResManager restaurants;
    private ArrayList<JButton> buttons;
    public static Color color = new java.awt.Color( 229,117,82);

    public ResList(){
        setVisible(true);
        setSize(400,650);
        setLayout(new BorderLayout());
        restaurants = new ResManager();
        buttons = new ArrayList<>();
        try {
            restaurants.load();
        } catch (Exception e) {
            System.out.println("error in loading");
        }
        insertDisplayer();
        setInteraction();
    }



    private void insertDisplayer(){
        displayer = new JPanel();
        displayer.setBackground(Color.white);
        displayer.setSize(400,650);
        displayer.setVisible(true);
        displayer.setLayout(new GridLayout(10,1,2,2));

        JLabel heading = new JLabel("Restaurant List");
        heading.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        heading.setForeground(color);
        displayer.add(heading);
        for(model.Restaurant r: restaurants) {
            JButton r1 = new JButton(r.getName());
            displayer.add(r1);
            buttons.add(r1);
        }
        add(displayer,BorderLayout.CENTER);
    }

    private void setInteraction(){
        for(JButton btn:buttons){
            int index = buttons.indexOf(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayer.setVisible(false);
                    Restaurant r = restaurants.get(index);
                    ResDisplayer res = new ResDisplayer(r);
                    add(res,BorderLayout.CENTER);
                }
            });
        }

    }
}