import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends Frame implements ActionListener{
	private Button[] btnNumbers;  // Array of 10 numeric Buttons
	   private Button btnEqual, btnPoint,btndivide,btnmultiply,btnplus,btnminus;
	   private TextField t;
	   static double a=0,b=0,result=0;
	    static int operator=0;
	   public Calculator(){
		   // Set up display panel
		      Panel panelDisplay = new Panel(new FlowLayout());
		      t = new TextField("0", 20);
		      panelDisplay.add(t);
		 
		      // Set up button panel
		      Panel panelButtons = new Panel(new GridLayout(4, 4));
		      btnNumbers = new Button[10];  // Construct an array of 10 numeric Buttons
		      btnNumbers[1] = new Button("1");  // Construct Button "1"
		      panelButtons.add(btnNumbers[1]);  // The Panel adds this Button
		      btnNumbers[2] = new Button("2");
		      panelButtons.add(btnNumbers[2]);
		      btnNumbers[3] = new Button("3");
		      panelButtons.add(btnNumbers[3]);
		      
		      btndivide = new Button("/");
		      panelButtons.add(btndivide);
		      
		      btnNumbers[4] = new Button("4");
		      panelButtons.add(btnNumbers[4]);
		      btnNumbers[5] = new Button("5");
		      panelButtons.add(btnNumbers[5]);
		      btnNumbers[6] = new Button("6");
		      panelButtons.add(btnNumbers[6]);
		      
		      btnmultiply=new Button("*");
		      panelButtons.add(btnmultiply);
		      
		      btnNumbers[7] = new Button("7");
		      panelButtons.add(btnNumbers[7]);
		      btnNumbers[8] = new Button("8");
		      panelButtons.add(btnNumbers[8]);
		      btnNumbers[9] = new Button("9");
		      panelButtons.add(btnNumbers[9]);
		      
		      btnplus=new Button("+");
		      panelButtons.add(btnplus);
		      
		            // You should use a loop for the above statements!!!
		      btnPoint = new Button(".");
		      panelButtons.add(btnPoint);
		      btnNumbers[0] = new Button("0");
		      panelButtons.add(btnNumbers[0]);
		      btnEqual = new Button("=");
		      panelButtons.add(btnEqual);
		      
		      btnminus=new Button("-");
		      panelButtons.add(btnminus);
		 
		      setLayout(new BorderLayout());  // "super" Frame sets to BorderLayout
		      add(panelDisplay, BorderLayout.NORTH);
		      add(panelButtons, BorderLayout.CENTER);
		 
		      addWindowListener(new WindowAdapter() {
		          @Override
		          public void windowClosing(WindowEvent evt) {
		             System.exit(0);  // Terminate the program
		          }
		       });
		      
		      btnNumbers[0].addActionListener(this);
		      btnNumbers[1].addActionListener(this);
		      btnNumbers[2].addActionListener(this);
		      btnNumbers[3].addActionListener(this);
		      btnNumbers[4].addActionListener(this);
		      btnNumbers[5].addActionListener(this);
		      btnNumbers[6].addActionListener(this);
		      btnNumbers[7].addActionListener(this);
		      btnNumbers[8].addActionListener(this);
		      btnNumbers[9].addActionListener(this);
		      btnminus.addActionListener(this);
		      btnplus.addActionListener(this);
		      btndivide.addActionListener(this);
		      btnmultiply.addActionListener(this);
		      btnEqual.addActionListener(this);
		        
		      setTitle("BorderLayout Demo"); // "super" Frame sets title
		      setSize(200, 200);             // "super" Frame sets initial size
		      setVisible(true);              // "super" Frame shows
	   }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Calculator(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==btnNumbers[1])
	            t.setText(t.getText().concat("1"));
	        
	        if(e.getSource()==btnNumbers[2])
	            t.setText(t.getText().concat("2"));
	        
	        if(e.getSource()==btnNumbers[3])
	            t.setText(t.getText().concat("3"));
	        
	        if(e.getSource()==btnNumbers[4])
	            t.setText(t.getText().concat("4"));
	        
	        if(e.getSource()==btnNumbers[5])
	            t.setText(t.getText().concat("5"));
	        
	        if(e.getSource()==btnNumbers[6])
	            t.setText(t.getText().concat("6"));
	        
	        if(e.getSource()==btnNumbers[7])
	            t.setText(t.getText().concat("7"));
	        
	        if(e.getSource()==btnNumbers[8])
	            t.setText(t.getText().concat("8"));
	        
	        if(e.getSource()==btnNumbers[9])
	            t.setText(t.getText().concat("9"));
	        
	        if(e.getSource()==btnNumbers[0])
	            t.setText(t.getText().concat("0"));
	        
	        if(e.getSource()==btnPoint)
	            t.setText(t.getText().concat("."));
	        if(e.getSource()==btnplus)
	        {
	            a=Double.parseDouble(t.getText());
	            operator=1;
	            t.setText("");
	        } 
	        if(e.getSource()==btnminus)
	        {
	            a=Double.parseDouble(t.getText());
	            operator=2;
	            t.setText("");
	        }
	        
	        if(e.getSource()==btnmultiply)
	        {
	            a=Double.parseDouble(t.getText());
	            operator=3;
	            t.setText("");
	        }
	        
	        if(e.getSource()==btndivide)
	        {
	            a=Double.parseDouble(t.getText());
	            operator=4;
	            t.setText("");
	        }
	        
	        if(e.getSource()==btnEqual)
	        {
	            b=Double.parseDouble(t.getText());
	        
	            switch(operator)
	            {
	                case 1: result=a+b;
	                    break;
	        
	                case 2: result=a-b;
	                    break;
	        
	                case 3: result=a*b;
	                    break;
	        
	                case 4: result=a/b;
	                    break;
	        
	                default: result=0;
	            }
	        
	            t.setText(""+result);
	        }
	        
	}

}
