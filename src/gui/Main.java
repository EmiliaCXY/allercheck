package gui;

import model.ResManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    JPanel page;
    public static Color color = new java.awt.Color( 229,117,82);


    public Main(){
        super("AllerCheck");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 650);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(color);
        insertWelcomePage();
        insertBtn();
        setVisible(true);

    }

    private void insertWelcomePage(){
        page = new JPanel();
        page.setBackground(color);
        page.setVisible(true);
        page.setLayout(null);
        page.setSize(this.getWidth(), this.getHeight());

        ImageIcon welcomeImage = new ImageIcon("Graphics\\cutlery.png");
        ImageIcon welcomeImageScaled = new ImageIcon(welcomeImage.getImage().getScaledInstance(150,
                150, Image.SCALE_SMOOTH));
        JLabel welcome = new JLabel(welcomeImageScaled);
        welcome.setLocation(120,page.getHeight()/8);
        welcome.setSize(150,150);
        page.add(welcome);
        this.add(page, BorderLayout.CENTER);
    }

    public void insertBtn(){
        JButton btn = new JButton("AllerCheck");
        btn.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        btn.setSize(200,50);
        btn.setLocation(page.getWidth()/4, page.getHeight()/2);


        page.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.setVisible(false);
                remove(btn);
                ResList resList = new ResList();
                add(resList,BorderLayout.CENTER);

            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }

}
