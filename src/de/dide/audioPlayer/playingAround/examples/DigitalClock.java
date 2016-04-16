package de.dide.audioPlayer.playingAround.examples;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class DigitalClock extends QLCDNumber {
    
	public DigitalClock() {
        setSegmentStyle(SegmentStyle.Filled);
        QTimer timer = new QTimer(this);
        timer.timeout.connect(this, "showTime()");
        timer.start(100);
        showTime();
        setWindowTitle(tr("Digital Clock"));
        resize(150, 60);
    }

    public void showTime() {
        QTime time = QTime.currentTime();
        StringBuffer text = new StringBuffer(time.toString("hh:mm"));
        if ((time.second() % 2) == 0)
//            text.setCharAt(2, ' ');
        display(text.toString());
        System.out.println(text.toString());
    }

    public static void main(String args[]) {
        QApplication.initialize(args);
        new DigitalClock().show();
        QApplication.execStatic();
    }
}