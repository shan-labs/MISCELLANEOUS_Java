import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Arrays; 


public class SoundImplementation implements ActionListener, MouseListener{

    public static SoundImplementation menu;
    public boolean starter =false;
    public boolean exit =false;
    public Render renderer;
    JFrame x;
    static String[] myString ={"a","0","",""};
	
    public SoundImplementation(){
	//window
	JFrame jframe = new JFrame("Start Menu");
	x=jframe;
        Timer timer = new Timer(20, this);
	renderer = new Render();
        jframe.add(renderer);
        jframe.addMouseListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 800);
        jframe.setVisible(true);
        jframe.setResizable(false);
        timer.start();
        //music("animals");
    }

    public void actionPerformed(ActionEvent e){
	renderer.repaint();
    }

    public void repaint (Graphics g){
	//Parts of Menu
	Color background = new Color (0, 0, 0);
	g.setColor(background); 
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.WHITE);
        Font smenu=new Font ("Arial",Font.BOLD,80);
        g.setFont(smenu);
        g.drawString("START MENU", 180, 150);
	Font small=new Font ("Arial",Font.BOLD,20);
        g.setFont(small);
	g.drawString("dang", 650, 300);
	g.drawString("el perdonL", 620, 340);
	g.drawString("DANG", 641, 380);
        Font mundane=new Font ("Arial",Font.BOLD,40);
	g.setFont(mundane);
	g.drawString("El Perdon HAA", 250, 300);
        g.drawString("Heathens LOOL", 250, 400);
        g.drawString("Heathens LOL", 275, 500);
	g.drawString("EXIT", 382, 600);
	//System.out.println(Arrays.toString(myString));
    }

    public void music(String x){
	//temp.getter().dispose();
        //temp.objectname.reset();
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
    
    @Override
    public void mouseClicked(MouseEvent e){
	int xcor=e.getX();
        int ycor=e.getY();
	//System.out.println(xcor+","+ycor);

	//unseeded sudoku puzzle
        if(xcor >=245 && xcor<= 595 && ycor >=290 && ycor<= 330){
	    //x.dispose();
	    music("elperdon");
	}
	//seeded sudoku puzzle
	if(xcor >=650 && xcor<= 710 && ycor >=305 && ycor<= 325){
	    //x.dispose();
	    music("Dangerous");
	}
	//solver
	if(xcor >=245 && xcor<= 610&& ycor >=390 && ycor<= 420){
	    //x.dispose();
	    music("Heathens");
	}
	//Difficulty window
	if(xcor >=620 && xcor<= 740 && ycor >=350 && ycor<= 365){
	    //x.dispose();
	    music("elperdon");
	}//Settings window
	if(xcor >=640 && xcor<= 720 && ycor >=390 && ycor<= 405){
	    //x.dispose();
	    music("Dangerous");
	}
	    
	//instructions
	if(xcor >= 275 && xcor<= 570 && ycor >= 490 && ycor<= 517){
	    //x.dispose();
	    music("Heathens");
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

}
