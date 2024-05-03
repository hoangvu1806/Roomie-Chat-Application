
package com.hoangvu.swing;


import javax.swing.*;

public class Progress extends JProgressBar {
    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }

    private ProgressType progressType = ProgressType.NON;
    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    public static enum ProgressType {
        NON, DOWNLOAD, CANCEL, FILE;
    }

}
