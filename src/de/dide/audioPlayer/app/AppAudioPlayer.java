package de.dide.audioPlayer.app;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QMainWindow;
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
	
	private AppAudioPlayer() {
		setMinimumHeight(800);
		setMinimumWidth(800);
		allWidget = new QWidget(this);
		setCentralWidget(allWidget);
		mainLayout = new QGridLayout(this);
		
		//ADD PLAYER PANEL
		player = AudioPlayer_Basic.getInstance();
		player.setParent(allWidget);
//		player.show();
		
		//ADD PLAYLIST PANEL BELOW
		PlaylistWidget playListPanel = PlaylistWidget.getInstance();
		playListPanel.setParent(allWidget);
			/*
			 * braucht folgendes:
			 * 
			 * Dateinnamen eines übergebenens Verzeichnisses (oder eines
			 * hartcodierten Pfades) in Array auslesen und für jeden .wav 
			 * Eintrag ein TextField erzeugen per Schleife.
			 * 
			 */
		
		//ADD ALL WIDGETS
		mainLayout.addWidget(player, 0, 0);
		mainLayout.addWidget(playListPanel, 1, 0);
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