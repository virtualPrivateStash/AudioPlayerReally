package de.dide.audioPlayer.app;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QMainWindow;

import de.dide.audioPlayer.view.gui.elements.mainWidgets.AudioPlayer_Basic;

public class AppAudioPlayer extends QMainWindow {

	private static AppAudioPlayer mainWindow;
	private static AudioPlayer_Basic player;
	
	public static AppAudioPlayer getInstance() {
		if (mainWindow == null) {
			mainWindow = new AppAudioPlayer();
		}
		return mainWindow;
	}
	
	public static void main(String[] args) {
		QApplication.initialize(args);
		mainWindow = getInstance();
		QGridLayout mainLayout = new QGridLayout(mainWindow);
		player = AudioPlayer_Basic.getInstance();
		player.show();
		mainLayout.addWidget(player, 0, 0);
		mainWindow.setLayout(mainLayout);
		QApplication.execStatic();
	}

}