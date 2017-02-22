import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Sound extends JFrame {
   
    // Constructor
    public Sound() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Test Sound Clip");
	this.setSize(300, 200);
	this.setVisible(true);
   
	try {
	    // Open an audio input stream.
	    URL url = this.getClass().getClassLoader().getResource("ElPerdon.wav");
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	    // Get a sound clip resource.
	    Clip clip = AudioSystem.getClip();
	    // Open audio clip and load samples from the audio input stream.
	    clip.open(audioIn);
	    clip.start();
	} catch (UnsupportedAudioFileException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	}
    }
   
    public static void main(String[] args) {
	new Sound();
    }
}
