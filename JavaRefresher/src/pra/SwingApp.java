package pra;
import java.awt.*;        
import java.awt.event.*; 
import javax.swing.*; 
public class SwingApp extends JFrame {
	private JTextField tf;
	private JButton btn;
	private int count=0;
	
	public SwingApp(){
		Container cp= getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Counter"));
		
		tf=new JTextField("0");
		tf.setEditable(false);
		add(tf);
		
		btn=new JButton("Count");
		cp.add(btn);
		 
		
		btn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	            ++count;
	            tf.setText(count + "");
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setTitle("Swing Counter"); // "super" JFrame sets title
	      setSize(300, 100);         // "super" JFrame sets initial size
	      setVisible(true); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new SwingApp();
			}
		});
	}

}
