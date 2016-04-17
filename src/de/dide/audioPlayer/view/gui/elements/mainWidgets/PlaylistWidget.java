package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import java.io.File;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class PlaylistWidget extends QWidget {

	private static PlaylistWidget playListWidget;
	private QVBoxLayout layout;
	
	private PlaylistWidget() {
		super();
		layout = new QVBoxLayout();
		layout.setSpacing(0);
		layout.setMargin(0);
		layout.setContentsMargins(0, 0, 0, 0);
		
		setLayout(layout);
//        setSegmentStyle(SegmentStyle.Filled);

		File folderPath = new File("/home/xy/PROG/workspaces/java/AudioPlayerReally/sounds/sampleFolder1");
		String[] fileNames = folderPath.list();
		int size = fileNames.length;
		QLineEdit[] lines = new QLineEdit[size];
		for (int i = 0; i < size; i++) {
			lines[i] = new QLineEdit(fileNames[i], this);
			lines[i].setStyleSheet("QLineEdit {margin: 0px, padding: 0px, color: green;}");
//			lines[i].setTextMargins(0, 0, 0, 0);
//			lines[i].setContentsMargins(0, 0, 0, 0);
			layout.addWidget(lines[i]);
		}

	}
	
	public static PlaylistWidget getInstance() {
		if (playListWidget == null) {
			playListWidget = new PlaylistWidget();
		}
		return playListWidget;
	}

}
