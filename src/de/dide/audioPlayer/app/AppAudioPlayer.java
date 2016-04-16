package de.dide.audioPlayer.app;

import com.trolltech.qt.gui.QApplication;

import de.dide.audioPlayer.view.gui.AudioPlayer_Basic;

public class AppAudioPlayer {

	private static AudioPlayer_Basic player;
	
	
	public static void main(String[] args) {
		QApplication.initialize(args);
		player = AudioPlayer_Basic.getInstance();
		player.show();
		QApplication.execStatic();
		
	}
}
