package com.hoangvu.swing;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
}
