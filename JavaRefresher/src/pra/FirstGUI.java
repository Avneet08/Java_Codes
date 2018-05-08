package pra;
import java.awt.*;
import java.awt.event.*;


public class FirstGUI extends Frame implements ActionListener,WindowListener {
	private Label lblCount;
	private TextField tfCount;
	private Button btnCount;
	private int count=0;
	
	public FirstGUI(){
	setLayout(new FlowLayout());
	lblCount=new Label("Counter");
	add(lblCount);
	
	
	tfCount=new TextField("0",10);
	tfCount.setEditable(false);
	add(tfCount);
	
	btnCount=new Button("Count");
	add(btnCount);
	
	btnCount.addActionListener(this);
	addWindowListener(this);
	
	setTitle("AWT Counter");
	setSize(250,100);
	
	setVisible(true);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstGUI h=new FirstGUI();
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		++count;
		tfCount.setText(count+"");
	}
	 @Override
	   public void windowClosing(WindowEvent evt) {
	      System.exit(0);  // Terminate the program
	   }
	 
	   // Not Used, but need to provide an empty body to compile.
	   @Override public void windowOpened(WindowEvent evt) { }
	   @Override public void windowClosed(WindowEvent evt) { }
	   @Override public void windowIconified(WindowEvent evt) { }
	   @Override public void windowDeiconified(WindowEvent evt) { }
	   @Override public void windowActivated(WindowEvent evt) { }
	   @Override public void windowDeactivated(WindowEvent evt) { }
		
	}


