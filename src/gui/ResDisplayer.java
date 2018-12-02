package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;

import static gui.Main.color;

public class ResDisplayer extends JPanel{
    private Restaurant r;
    private JPanel info;
    private JPanel dishList;
    private JPanel allgery;
    private ArrayList<JButton> btns;

    public ResDisplayer(Restaurant r){
        this.r = r;
        btns = new ArrayList<>();
        setVisible(true);
        setLayout(new BorderLayout());
        setSize(400,650);
        displayInfo();
        setUpInteraction();
    }

    private void displayInfo(){
        info = new JPanel();
        info.setVisible(true);
        info.setLayout(new GridLayout(1,2));
        dishList = new JPanel();
        setUpDishList();
        allgery = new JPanel();
        setUpAllergy();
        info.add(dishList);
        info.add(allgery);
        add(info,BorderLayout.CENTER);

    }

    private void setUpDishList(){
        dishList.setVisible(true);
        dishList.setSize(200,500);
        ResMenu menu = r.getResMenu();
        dishList.setLayout(new GridLayout(menu.getDishes().size(),1,2,2));
        ArrayList<Dish> dishes = (ArrayList<Dish>) menu.getDishes();
        for(Dish d: dishes){
            JButton name = new JButton(d.getName());
            btns.add(name);
            dishList.add(name);
        }

    }


    private void setUpInteraction(){
        for (JButton btn : btns){
            int index = btns.indexOf(btn);
            Dish dish = r.getResMenu().getDishes().get(index);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setVisible(false);
                    DishDisplayer dd = new DishDisplayer(dish);
                    add(dd,BorderLayout.CENTER);
                }
            });
        }
    }

    private void setUpAllergy(){
        ResMenu menu = r.getResMenu();
        ArrayList<Dish> dishes = (ArrayList<Dish>) menu.getDishes();
        allgery.setVisible(true);
        allgery.setSize(200,500);
        allgery.setLayout(new GridLayout(menu.getDishes().size(),1,2,2));
        for(Dish d:dishes){
            JPanel allgeryPanel = new JPanel();
            allgeryPanel.setBackground(color);
            allgeryPanel.setLayout(new GridLayout(1,8,1,1));
            allgeryPanel.setSize(allgery.getSize());

            ImageIcon icon = new ImageIcon("Graphics\\df.png");
            ImageIcon iconScaled = new ImageIcon(icon.getImage().getScaledInstance(30,
                    30, Image.SCALE_SMOOTH));
            JLabel label = new JLabel(iconScaled);

            allgeryPanel.add(label);
            allgery.add(allgeryPanel);
            allgeryPanel.setVisible(true);
        }


    }
}