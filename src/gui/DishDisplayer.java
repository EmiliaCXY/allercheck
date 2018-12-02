package gui;

import model.Dish;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static gui.Main.color;

public class DishDisplayer extends JPanel {
    private Dish dish;
    private GridBagConstraints gc;
    private JPanel heading;
    private JPanel allegent;
    private JPanel ingre;

    public DishDisplayer(Dish d){
        setVisible(true);
        dish = d;
        setLayout(new GridLayout(4,1,5,5));
        gc = new GridBagConstraints();
        setUpHeading();
        setUpAllegent();
        setUpIngre();
    }

    private void setUpHeading(){
        heading = new JPanel();
        heading.setBackground(color);
        JLabel name = new JLabel(dish.getName());
        name.setFont(new Font("Tekton pro", Font.BOLD,24));
        heading.setLayout(new BorderLayout());
        heading.add(name,BorderLayout.CENTER);

        ImageIcon icon = new ImageIcon("Graphics\\dish.png");
        ImageIcon iconScaled = new ImageIcon(icon.getImage().getScaledInstance(50,
                50, Image.SCALE_SMOOTH));
        JLabel dishLabel = new JLabel(iconScaled);
        heading.add(dishLabel,BorderLayout.EAST);

        heading.setVisible(true);

        add(heading);
    }

    private void setUpAllegent(){
        allegent = new JPanel();
        allegent.setLayout(new GridLayout(1,5,0,0));
        ImageIcon icon = new ImageIcon("Graphics\\df.png");
        ImageIcon iconScaled = new ImageIcon(icon.getImage().getScaledInstance(30,
                30, Image.SCALE_SMOOTH));
        ImageIcon icon2 = new ImageIcon("Graphics\\gf.png");
        ImageIcon icon2Scaled = new ImageIcon(icon2.getImage().getScaledInstance(30,
                30, Image.SCALE_SMOOTH));
        JLabel iconLabel = new JLabel(iconScaled);
        JLabel iconLabel2 = new JLabel(icon2Scaled);
        allegent.add(iconLabel);
        allegent.add(iconLabel2);
        allegent.setVisible(true);

        add(allegent);
    }

    private void setUpIngre(){
        ingre = new JPanel();
        ingre.setLayout(new GridLayout(5,2,2,2));
        List<String> ingredients = dish.getIngredients();
        for(String i:ingredients){
            JLabel iLabel = new JLabel(i);
            iLabel.setFont(new Font("Tekton pro", Font.BOLD,20));
            ingre.add(iLabel,gc);
        }
        ingre.setVisible(true);

        add(ingre);
    }
}