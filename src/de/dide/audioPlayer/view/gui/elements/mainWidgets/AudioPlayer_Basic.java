package de.dide.audioPlayer.view.gui.elements.mainWidgets;

import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class AudioPlayer_Basic extends QWidget{

	private static AudioPlayer_Basic player;
	private QPushButton playPause;
	private QPushButton stop;
	private QPushButton song_prev;
	private QPushButton song_next;

	private QPushButton butt1;
	private QPushButton butt2;
	
	
	private AudioPlayer_Basic() {
		super();
//		QGridLayout layout = new QGridLayout(this);
		QHBoxLayout layout = new QHBoxLayout(this);
		
		//ADD BUTTONS FOR PLAYBACK
		QVBoxLayout layoutColPlayButtons = new QVBoxLayout();
		playPause 	= new QPushButton("playPause");
		stop 		= new QPushButton("stop");
		song_prev 	= new QPushButton("song_prev");
		song_next 	= new QPushButton("song_next");
		layoutColPlayButtons.addWidget(playPause);
		layoutColPlayButtons.addWidget(stop);
		layoutColPlayButtons.addWidget(song_prev);
		layoutColPlayButtons.addWidget(song_next);
		
		//ADD TIME DISPLAY
//		QHBoxLayout layoutTimeDisplay = new QHBoxLayout();
		TimeOfSongDisplay timeDisplay = TimeOfSongDisplay.getInstance();
//		layoutTimeDisplay.addWidget(timeDisplay);
		
		//ADD TRACK INFO DISPLAY PANEL
		
		//ALL ALL WIDGETS (AND LAYOUTS) TO LAYOUT
		layout.addLayout(layoutColPlayButtons);
		layout.addWidget(timeDisplay);
		
	}
	
	public static AudioPlayer_Basic getInstance() {
		if (player == null) {
			player = new AudioPlayer_Basic();
		}
		return player;
	}
	
	
	
}
