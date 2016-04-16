package de.dide.audioPlayer.view.gui;

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
		QVBoxLayout layoutColPlayButtons = new QVBoxLayout(this);
		playPause = new QPushButton("playPause");
		stop = new QPushButton("stop");
		song_prev = new QPushButton("song_prev");
		song_next = new QPushButton("song_next");
		layoutColPlayButtons.addWidget(playPause);
		layoutColPlayButtons.addWidget(stop);
		layoutColPlayButtons.addWidget(song_prev);
		layoutColPlayButtons.addWidget(song_next);
		
		QHBoxLayout layoutTimeDisplay = new QHBoxLayout();
		butt1 = new QPushButton("butt1");
		butt2 = new QPushButton("butt2");
		layoutTimeDisplay.addWidget(butt1);
		layoutTimeDisplay.addWidget(butt2);
		
		layout.addLayout(layoutColPlayButtons);
		layout.addLayout(layoutTimeDisplay);

		
	}
	
	public static AudioPlayer_Basic getInstance() {
		if (player == null) {
			player = new AudioPlayer_Basic();
		}
		return player;
	}
	
	
	
}
