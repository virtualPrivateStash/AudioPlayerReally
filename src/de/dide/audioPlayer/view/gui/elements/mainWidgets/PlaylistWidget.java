package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import java.io.File;

import com.trolltech.qt.gui.QLCDNumber.SegmentStyle;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QSizePolicy;
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

		File folderPath = new File("/home/xy/PROG/workspaces/java/AudioPlayerReally/sounds/sampleFolder1");
		String[] fileNames = folderPath.list();
		int size = fileNames.length;
		QLineEdit[] lines = new QLineEdit[size];
		for (int i = 0; i < size; i++) {
			QLineEdit line = new QLineEdit(fileNames[i], this);
			line.setStyleSheet("QLineEdit {margin: 0px, padding: 0px, color: green;}");
//			line.setTextMargins(0, 0, 0, 0);
//			line.setContentsMargins(0, 0, 0, 0);
			line.setMinimumSize(0, 20);
			line.setFrame(false);
			line.setSizePolicy(QSizePolicy.Policy.Expanding, 
					QSizePolicy.Policy.Expanding);
			lines[i] = line;
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
