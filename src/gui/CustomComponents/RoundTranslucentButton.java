package gui.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

//REFERENCE: https://java-swing-tips.blogspot.com/2013/01/make-translucent-jbutton.html

public class RoundTranslucentButton extends JButton {

    private static final Color TL = new Color(1f,1f,1f,.2f);
    private static final Color BR = new Color(0f,0f,0f,.4f);
    private static final Color ST = new Color(1f,1f,1f,.2f);
    private static final Color SB = new Color(1f,1f,1f,.1f);
    private Color ssc;
    private Color bgc;

    public RoundTranslucentButton(String label) {
        super(label);

        setBackground(Color.darkGray);
        setFocusable(false);

    /*
     These statements enlarge the button so that it
     becomes a circle rather than an oval.
    */
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
        setContentAreaFilled(false);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.darkGray);
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    // Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
        // If the button has changed size,  make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    @Override protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Shape area = new Ellipse2D.Float(0, 0, getWidth(), getHeight());

        ssc = TL;
        bgc = BR;
        ButtonModel m = getModel();
        if(m.isPressed()) {
            ssc = SB;
            bgc = ST;
        }else if(m.isRollover()) {
            ssc = ST;
            bgc = SB;
        }
        g2.setPaint(new GradientPaint(x, y, ssc, x, y+h, bgc, true));
        g2.fill(area);
        g2.setPaint(BR);
        g2.draw(area);
        g2.dispose();
        super.paintComponent(g);
    }

}
