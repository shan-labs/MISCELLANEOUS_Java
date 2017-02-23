import javax.swing.JFrame;
public class temp extends JFrame{
    public static Sound mainWindowInstance;
    public static JFrame j;
    public static temp objectname;
    
    public temp(String x) {
	JFrame jf=new JFrame("c");
	j=jf;
        this.setTitle("Music Player");
        this.setSize(0,0);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        clear(mainWindowInstance);
	x+=".wav";
	mainWindowInstance=new Sound(x);
	jf.setVisible(true);
    }
    
    public static void clear(Sound x){
	if(x!=(Sound)null){
	    x.stopper();
	    x=(Sound)null;
	}
    }
    public static void namer(String x){
	mainWindowInstance=new Sound(x);
    }

    public static void main(String[] args) {
	
        objectname = new temp(args[0]);
    }
}
