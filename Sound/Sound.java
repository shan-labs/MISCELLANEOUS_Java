import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Can't play .mp3 or new files
//use link for conversions, will try to make it automated:
//http://audio.online-convert.com/convert-to-wav
   
// To play sound using Clip, the process need to be 'alive'.
// Hence, we use a Swing application.
public class Sound extends JFrame implements ActionListener{
    //for layout purposes
    private Container pane; //pane
    private JButton pm; //play music
    private JButton sm; //stop music
    private JLabel fn; //filename
    private JLabel EQUAL; //playing or what happened
    private JTextField t; //text for fn
    private JTextField output; //text for EQUAL
    //for music
    Clip clip;
    
    // Constructor
    public Sound() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Music Player");
        this.setSize(600,400);
	this.setLocation(100,100);
	this.setResizable(false);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	fn = new JLabel("Song Name:",null,JLabel.CENTER);
	EQUAL = new JLabel("Now Playing:",null,JLabel.CENTER);
        output = new JTextField(15);
	output.setEditable(false);
	t = new JTextField(15);
	pm = new JButton("Play Music");
	pm.addActionListener(this);
	pm.setActionCommand("1");
	sm = new JButton("Stop Music");
	sm.addActionListener(this);
	sm.setActionCommand("2");

	pane.add(fn);
	pane.add(t);
	pane.add(EQUAL);
	pane.add(output);
	pane.add(pm);
	pane.add(sm);

    }

    public Sound(String x) {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Music Player");
        this.setSize(0,0);
	this.setLocation(100,100);
	this.setResizable(false);
	play(x);
    }

    public void actionPerformed(ActionEvent e){
	boolean type=false;
	if(e.getActionCommand().equals("1")){
	    output.setText(t.getText());
	    try{
		String substr="";
		if(t.getText().length()>4)
		    substr = t.getText().substring(t.getText().length() - 4);
		if(t.getText().charAt(t.getText().length() - 4)=='.'){
		    if(!substr.equals(".wav")){
			type=true;
			throw new IllegalArgumentException();
		    }
		}
		if (clip==null||!clip.isRunning()){
		    play(t.getText());
		}
		else{
		    clip.stop();
		    play(t.getText());
		}
	    }catch(Exception e1){
		output.setText("Please enter valid file");
		//e1.printStackTrace();
		if(type)
		    output.setText("Please enter .wav file");
	    }
	}
	else if(e.getActionCommand().equals("2")){
	    output.setText("");
	    if (clip.isRunning())
		clip.stop();
	}
    }
    
    
    public void play(String filename){
	try {
	    // Open an audio input stream.
	    URL url = this.getClass().getClassLoader().getResource(filename);
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	    // Get a sound clip resource.
	    clip= AudioSystem.getClip();
	    // Open audio clip and load samples from the audio input stream.
	    clip.open(audioIn);
	    clip.start();
	    /*
	    // start()
	    clip.start();  // play once
	    // Loop()
	    clip.loop(0);  // repeat none (play once), can be used in place of start().
	    clip.loop(5);  // repeat 5 times (play 6 times)
	    clip.loop(Clip.LOOP_CONTINUOUSLY);  // repeat forever
	    */
	} catch (UnsupportedAudioFileException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	}
    }
   
    public static void main(String[] args) {
	//Sound w= new Sound(args[0]); //precondition, playable file
	Sound w= new Sound();
	w.setVisible(true);
    }
}
