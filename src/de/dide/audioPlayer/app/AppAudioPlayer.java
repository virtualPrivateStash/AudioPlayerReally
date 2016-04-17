package de.dide.audioPlayer.app;

import java.io.File;

import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QWidgetItem;

import de.dide.audioPlayer.view.gui.elements.mainWidgets.AudioPlayer_Basic;
import de.dide.audioPlayer.view.gui.elements.mainWidgets.PlaylistWidget;


/**
 * Komplementärfarbe für Eclipse-Schrift für Variablen: #6E425D
 */
public class AppAudioPlayer extends QMainWindow {

	private static AppAudioPlayer mainWindow;
	private static QWidget allWidget;
	private static AudioPlayer_Basic player;
	private QGridLayout mainLayout;

	
	
	public static final int SIZE_APP_MIN = 800;
	public static final int SIZE_APP_MAX = 1200;
	public static final int SIZE_APP_DEFAULT = 900;
	
	public static final int SIZE_WIDGET_MIN = 200;
	public static final int SIZE_WIDGET_MAX = SIZE_APP_MAX;
	public static final int SIZE_WIDGET_DEFAULT = 600;
	
	public static final int FONTSIZE_DEFAULT = 12;
	public static final int FONTSIZE_SMALL = 9;
	public static final int FONTSIZE_LARGE = 16;
	
	
	
	
	private AppAudioPlayer() {
		setMinimumHeight(SIZE_WIDGET_DEFAULT);
		setMinimumWidth(SIZE_WIDGET_DEFAULT);
		allWidget = new QWidget();
		setCentralWidget(allWidget);
//		Or alternate way is to use QWidget with parent 0 as a main window, 
//		and pass the pointer as a parameter to the creation of layout
//		(or use setLayout(...)) 
		mainLayout = new QGridLayout();
		System.out.println("columnStretch 0: " + mainLayout.columnStretch(0));
		System.out.println("columnStretch 1: " + mainLayout.columnStretch(1));
		
		System.out.println("columnCount : " + mainLayout.columnCount());
		System.out.println("rowCount : " + mainLayout.rowCount());
		//ADD PLAYER PANEL
		player = AudioPlayer_Basic.getInstance();
		player.setParent(allWidget);
		
		//ADD PLAYLIST PANEL BELOW
		PlaylistWidget playListPanel = PlaylistWidget.getInstance();
		playListPanel.setParent(allWidget);
		playListPanel.setSizePolicy(QSizePolicy.Policy.Expanding, 
				QSizePolicy.Policy.Expanding);

		/*
		 * braucht folgendes:
		 * 
		 * Dateinnamen eines übergebenens Verzeichnisses (oder eines
		 * hartcodierten Pfades) in Array auslesen und für jeden .wav 
		 * Eintrag ein TextField erzeugen per Schleife.
		 * 
		 */
		
		//ADD ALL WIDGETS
		mainLayout.addWidget(player, 0, 0, 1, 1);
//		mainLayout.addLayout(layout_playList, 10, 0, 1, 2, Qt.AlignmentFlag.AlignCenter);
		mainLayout.addWidget(playListPanel, 1, 0, 1, -1);
		mainLayout.setColumnStretch(0, 10000000);
		System.out.println("columnStretch 0 post: " + mainLayout.columnStretch(0));
		System.out.println("columnStretch 1 post: " + mainLayout.columnStretch(1));
		
		allWidget.setLayout(mainLayout);
	}
	
	public static AppAudioPlayer getInstance() {
		if (mainWindow == null) {
			mainWindow = new AppAudioPlayer();
		}
		return mainWindow;
	}
	
	public static void main(String[] args) {
		QApplication.initialize(args);
		mainWindow = getInstance();
		mainWindow.show();
		QApplication.execStatic();
	}

}