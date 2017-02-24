import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;


public class SoundImplementation implements ActionListener, MouseListener, KeyListener{

    public static SoundImplementation menu;
    public Render renderer;
    JFrame x;
    static String[] myString ={"a","","",""};
    JTextField textField;
	
    public SoundImplementation(){
	//window
	JFrame jframe = new JFrame("Start Menu");
	x=jframe;
        Timer timer = new Timer(20, this);
	
        textField = new JTextField();
	//xpos, ypos, width, and height
        textField.setBounds(380,545,10,2);
	jframe.add(textField);
	textField.setVisible(true);
	textField.addActionListener(this);
	textField.setActionCommand("x");
	
	renderer = new Render();
        jframe.add(renderer);
        jframe.addMouseListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 800);
        jframe.setVisible(true);
        jframe.setResizable(false);
        timer.start();
    }

    public void actionPerformed(ActionEvent e){
	renderer.repaint();
	/*
	  try{
	  if(e.getActionCommand().equals("x")){
	  String substr="";
	  System.out.println("L");
	  if(textField.getText().length()>4){
	  substr = textField.getText().substring(textField.getText().length() - 4);
	  System.out.println("@@");
	  if(substr.equals(".wav")){
	  System.out.println("aa");
	  Sound.clip.stop();
	  System.out.println("rr");
	  music(textField.getText());
	  }
	  }
	  }
	  }catch(Exception e1){
	  System.out.println("Enter valid");
	  System.out.println(textField.getText());
	  Sound.clip.stop();
	  //music(textField.getText());
	  }
	*/
	if(e.getActionCommand().equals("x")&&textField.getText()!=null)
	    textField.setText("debug-ster");//music(textField.getText());
    }

    public void repaint (Graphics g){
	//Parts of Menu
	Color background = new Color (0, 0, 0);
	g.setColor(background); 
	g.fillRect(0, 0, 800, 800);
	g.setColor(Color.WHITE);
	Font smenu=new Font ("Arial",Font.BOLD,80);
	g.setFont(smenu);
	g.drawString("MUSIC", 300, 150);
	Font mundane=new Font ("Arial",Font.BOLD,40);
	g.setFont(mundane);
	g.drawString("ANIMALS", 340, 265);
	String ei="EL PERD"+'\u00D3'+"N";
	g.drawString(ei, 310, 345);
	g.drawString("HEATHENS", 315, 415);
	g.drawString("DANGEROUS", 295, 490);
	g.drawString("EXIT", 382, 600);
	g.setFont(new Font("Helvetica", Font.PLAIN, 15));
	g.drawString("Song Length: " + (int) Sound.duration / 60 + "min " + Math.round(Sound.duration % 60) + " seconds", 320, 700);
	g.drawString("Current Progress: "+ (int) Sound.currentTime / 1000 / 60 + "min " + Math.round(Sound.currentTime / 1000 % 60) + " seconds", 320, 725);
    }

    public void music(String x){
	temp.clear(temp.mainWindowInstance);
	temp.j.dispose();
	myString[0]=x;
	temp.main(myString);
	
    }
    public static void main (String args []){
	menu=new SoundImplementation();
	try{
	    myString[1] = args[1];
	}catch(Exception e){
	    myString[0]="Animals";
	    temp.main(myString);
	}
	try{
	    myString[2] = args[2];
	    myString[3] = args[3];	
	}catch(Exception e){
	    myString[2]="black";
	    myString[3]="white";};
    }

    //Mouse
    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
	int ycor=e.getY();
	//System.out.println(xcor+","+ycor);

	//songs
	if(xcor >=335 && xcor<= 520 && ycor >=270 && ycor<= 300){
	    //x.dispose();
	    Sound.clip.stop();
	    music("animals");
	}
	if(xcor >=305 && xcor<= 550 && ycor >=340 && ycor<= 375){
	    //x.dispose();
	    Sound.clip.stop();
	    music("elperdon");
	}
	if(xcor >=310 && xcor<= 540 && ycor >=420 && ycor<= 450){
	    //x.dispose();
	    Sound.clip.stop();
	    music("heathens");
	}
	if(xcor >=290 && xcor<= 560 && ycor >=495 && ycor<= 525){
	    //x.dispose();
	    Sound.clip.stop();
	    music("dangerous");
	}

	//exit
	if(xcor >= 375 && xcor <= 475 && ycor >= 590 && ycor <= 625){
	    System.exit(0);
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    //Keyboard
    @Override
    public void keyPressed(KeyEvent e) {
	// TODO	
    }
    @Override
    public void keyReleased(KeyEvent e) {
	// TODO 	
    }
    @Override
    public void keyTyped(KeyEvent e) {
	// TODO	
    }

}
