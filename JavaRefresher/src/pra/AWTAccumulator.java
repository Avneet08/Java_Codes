package pra;
import java.awt.*;
import java.awt.event.*;
public class AWTAccumulator extends Frame implements ActionListener {
	private Label lblIn;
	private Label lblOut;
	private TextField tfIn;
	private TextField tfOut;
	private int sum=0;
	
	public AWTAccumulator(){
		setLayout(new FlowLayout());
		
		lblIn=new Label("Enter an Integer");
		add(lblIn);
		
		tfIn=new TextField(10);
		add(tfIn);
		tfIn.addActionListener(this);
		
		lblOut=new Label("Accumulated sum is");
		add(lblOut);
		
		tfOut=new TextField(10);
		tfOut.setEditable(false);
		add(tfOut);
		
		setTitle("AWT Accumulator");
		setSize(350,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AWTAccumulator acc=new AWTAccumulator();
		}
	@Override
	public void actionPerformed(ActionEvent evt){
		int numIn=Integer.parseInt(tfIn.getText());
		sum+=numIn;
		tfIn.setText("");
		System.out.println(sum-numIn);
		tfOut.setText(sum+"");
	}

}
