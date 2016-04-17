package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import com.trolltech.qt.core.QTime;
import com.trolltech.qt.core.QTimer;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QLCDNumber;
import com.trolltech.qt.gui.QLCDNumber.SegmentStyle;

import de.dide.audioPlayer.playingAround.examples.DigitalClock;

public class TimeOfSongDisplay extends QLCDNumber{

	private static TimeOfSongDisplay timeDisplay;
	
	private TimeOfSongDisplay() {
		super();
//        setSegmentStyle(SegmentStyle.Filled);
        QTimer timer = new QTimer(this);
        timer.timeout.connect(this, "showTime()");
        timer.start(1000);
        showTime();
        setWindowTitle(tr("Digital Clock"));
	}
	
	public static TimeOfSongDisplay getInstance() {
		if (timeDisplay == null) {
			timeDisplay = new TimeOfSongDisplay();
		}
		return timeDisplay;
	}
	
    public void showTime() {
        QTime time = QTime.currentTime();
        StringBuffer text = new StringBuffer(time.toString("hh:mm"));
        if ((time.second() % 2) == 0)
            text.setCharAt(2, ' ');
        display(text.toString());
    }

}