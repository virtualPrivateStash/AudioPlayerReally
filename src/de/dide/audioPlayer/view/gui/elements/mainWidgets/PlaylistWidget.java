package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import com.trolltech.qt.core.QTimer;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QWidget;

public class PlaylistWidget extends QWidget {

	private static PlaylistWidget playListWidget;
	
	private PlaylistWidget() {
		super();
//        setSegmentStyle(SegmentStyle.Filled);
		setMinimumHeight(100);
		QLineEdit textLine = new QLineEdit("oneLineOfTextBoi!", this);
		textLine.show();
		textLine.setMinimumHeight(300);
		setMinimumHeight(300);
		setMinimumWidth(300);
	}
	
	public static PlaylistWidget getInstance() {
		if (playListWidget == null) {
			playListWidget = new PlaylistWidget();
		}
		return playListWidget;
	}

}
