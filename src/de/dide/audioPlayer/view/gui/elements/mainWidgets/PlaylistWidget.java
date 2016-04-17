package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import java.io.File;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QLCDNumber.SegmentStyle;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QPalette.ColorRole;
import com.trolltech.qt.gui.QScrollArea;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

import de.dide.audioPlayer.app.AppAudioPlayer;

public class PlaylistWidget extends QWidget {

	private static PlaylistWidget playListWidget;
	private QVBoxLayout layout;
	
	private PlaylistWidget() {
		super();
		setStyleSheet("PlaylistWidget { fill: both;}");
		layout = new QVBoxLayout();
		setSizePolicy(QSizePolicy.Policy.Expanding, 
					QSizePolicy.Policy.Expanding);
		setMinimumSize(AppAudioPlayer.SIZE_WIDGET_DEFAULT, 
				AppAudioPlayer.SIZE_WIDGET_DEFAULT);
		layout.setSpacing(0);
		layout.setMargin(0);
		layout.setContentsMargins(0, 0, 0, 0);
		System.out.println("sizeHint von layout: " + layout.sizeHint());

		

		File folderPath = new File("/home/xy/PROG/workspaces/java/AudioPlayerReally/sounds/sampleFolder1");
		String[] fileNames = folderPath.list();
		int size = fileNames.length;
		QLineEdit[] lines = new QLineEdit[size];
		for (int i = 0; i < size; i++) {
			QLineEdit line = new QLineEdit(fileNames[i], this);
			line.setStyleSheet("QLineEdit {margin: 0px, padding: 0px, color: green;}");
//			line.setTextMargins(0, 0, 0, 0);
//			line.setContentsMargins(0, 0, 0, 0);
			line.setMinimumSize(AppAudioPlayer.SIZE_WIDGET_MAX, 40);
			line.setFrame(false);
			line.setSizePolicy(QSizePolicy.Policy.Expanding, 
					QSizePolicy.Policy.Expanding);
			lines[i] = line;
			layout.addWidget(lines[i]);
		}
		QWidget listWidget = new QWidget();
		listWidget.setLayout(layout);
		listWidget.setMinimumSize(AppAudioPlayer.SIZE_WIDGET_DEFAULT, AppAudioPlayer.SIZE_WIDGET_DEFAULT);
		listWidget.setSizePolicy(QSizePolicy.Policy.Expanding, 
				QSizePolicy.Policy.Expanding);
		System.out.println("sizeHint von listWidget: " + listWidget.sizeHint());
		QScrollArea scroller = new QScrollArea(this);
		scroller.setBackgroundRole(ColorRole.Dark);
		scroller.setVisible(true);
		scroller.setVerticalScrollBarPolicy(Qt.ScrollBarPolicy.ScrollBarAsNeeded);
		scroller.setMinimumSize(AppAudioPlayer.SIZE_WIDGET_MAX, AppAudioPlayer.SIZE_WIDGET_MAX);
		scroller.setSizePolicy(QSizePolicy.Policy.Expanding, 
				QSizePolicy.Policy.Expanding);
		scroller.setWidget(listWidget);
		System.out.println("sizeHint von scroller: " + scroller.sizeHint());
	}
	
	public static PlaylistWidget getInstance() {
		if (playListWidget == null) {
			playListWidget = new PlaylistWidget();
		}
		return playListWidget;
	}

}
