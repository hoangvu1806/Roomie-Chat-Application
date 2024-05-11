package com.hoangvu.swing;

import java.awt.*;

public class ActiveStatus extends Component {
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        repaint();
    }

    private boolean active;

    public ActiveStatus() {
        setPreferredSize(new Dimension(8,8));
    }

    @Override
    public void paint(Graphics g) {
        if (active){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(new Color(1, 196, 41, 165));
            g2d.fillOval(0, (getHeight()/2) - 4, 8, 8);
        }
    }
}
