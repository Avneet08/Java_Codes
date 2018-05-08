package pra;
//Avneet Kaur
//2016233
//Section B
import java.awt.*;  
import java.awt.event.*;  
import java.awt.GridBagLayout;  
  
import javax.swing.*;  
public class GridBagLayoutExample extends JFrame  {  
private int countin=0;
private int countout=0;
int i=0;

    public static void main(String[] args) {  
            GridBagLayoutExample a = new GridBagLayoutExample();  
        }  
       public GridBagLayoutExample() {  
    	   GridBagLayout grid = new GridBagLayout();  
            GridBagConstraints gbc = new GridBagConstraints();  
            setLayout(grid);  
            setTitle("GridBag Layout Example");  
            GridBagLayout layout = new GridBagLayout();  
            this.setLayout(layout);  
            
            //Row1
		    gbc.fill = GridBagConstraints.HORIZONTAL;  
		    gbc.gridx = 0;  
		    gbc.gridy = 0;
		  gbc.weightx = 0.5;
		  gbc.gridwidth = 4; 
		  JTextField tf=new JTextField("IIITD Fruit stall");
		  tf.setHorizontalAlignment(SwingConstants.CENTER);
		  tf.setEditable(false);
		  this.add(tf,gbc); 
		  
		  //Row2 Column 1
		    gbc.fill = GridBagConstraints.HORIZONTAL;  
		    gbc.gridx = 0;  
		    gbc.gridy = 1; 
		    gbc.weightx = 0.5; 
		    gbc.gridwidth = 2; 
		    JTextField tf1=new JTextField("Inventory");
		    tf1.setHorizontalAlignment(SwingConstants.CENTER);
		  tf1.setEditable(false);
		  this.add(tf1,gbc); 
		  
		  //Row2 column2
		    gbc.fill = GridBagConstraints.HORIZONTAL;  
		    gbc.gridx = 2;  
		    gbc.gridy = 1; 
		    gbc.weightx = 0.5; 
		    gbc.gridwidth = 2;  
		    JTextField tf2=new JTextField("Users");
		    tf2.setHorizontalAlignment(SwingConstants.CENTER);
		    tf2.setEditable(false);
		  	this.add(tf2,gbc);  
		    
		  	//Row3 
		     gbc.fill = GridBagConstraints.HORIZONTAL;
		     
		     // R3 Column1
		    gbc.gridx = 0;  
		    gbc.gridy = 2;  
		    gbc.gridwidth = 1;  
		    JTextField tf3=new JTextField("Items");
		    tf3.setHorizontalAlignment(SwingConstants.CENTER);
		  tf3.setEditable(false);
		    this.add(tf3,gbc);
		    
		    //R3 Column2
		    gbc.gridx = 1;  
		    gbc.gridy = 2;  
		    gbc.gridwidth = 1;  
		    JTextField tf4=new JTextField("Quantity");
		    tf4.setHorizontalAlignment(SwingConstants.CENTER);
		  tf4.setEditable(false);
		  this.add(tf4,gbc); 
		  
		  //R3 Column3
		    gbc.gridx = 2;  
		    gbc.gridy = 2;  
		    gbc.gridwidth = 1;  
		    JTextField tf5=new JTextField("Items");
		    tf5.setHorizontalAlignment(SwingConstants.CENTER);
		  tf5.setEditable(false);
		  this.add(tf5,gbc);
		  
		  //R3 Column4
		    gbc.gridx = 3;  
		    gbc.gridy = 2;  
		     gbc.gridwidth = 1;  
		    JTextField tf6=new JTextField("Quantity");
		    tf6.setHorizontalAlignment(SwingConstants.CENTER);
		  tf6.setEditable(false);
		  this.add(tf6,gbc);
		  
		  //Row4 Apple
		    gbc.fill = GridBagConstraints.HORIZONTAL; 
		    //R4 Column1
		    gbc.gridx = 0;  
		    gbc.gridy = 3;  
		    gbc.gridwidth = 1;  
		    JTextField tf7=new JTextField("Apples");
		  tf7.setEditable(false);
		  this.add(tf7,gbc); 
		     
		  //R4 C2
		    gbc.gridx = 1;  
		    gbc.gridy = 3;  
		    gbc.gridwidth = 1;  
		    JTextField tf8=new JTextField("8");
		  tf8.setEditable(false);
		  this.add(tf8,gbc); 
		  
		  //R4 C3
		    gbc.gridx = 2;  
		    gbc.gridy = 3;  
		    gbc.gridwidth = 1;  
		    JTextField tf9=new JTextField("Apples");
		  tf9.setEditable(false);
		  this.add(tf9,gbc);
		  
		  //R4 C4
		    gbc.gridx = 3;  
		    gbc.gridy = 3;  
		     gbc.gridwidth = 1;  
		    JTextField tf10=new JTextField("2");
		  tf10.setEditable(true);
		  this.add(tf10,gbc);
		  
		  //R5 Mango
		  gbc.fill = GridBagConstraints.HORIZONTAL; 
		  //R5 C1
		    gbc.gridx = 0;  
		    gbc.gridy = 4;  
		    gbc.gridwidth = 1;  
		    JTextField tf11=new JTextField("Mango");
		  tf11.setEditable(false);
		  this.add(tf11,gbc); 
		    
		  //R5 C2
		    gbc.gridx = 1;  
		    gbc.gridy = 4;  
		    gbc.gridwidth = 1;  
		    JTextField tf12=new JTextField("3");
		  tf12.setEditable(false);
		  this.add(tf12,gbc); 
		  
		  //R5 C3
		    gbc.gridx = 2;  
		    gbc.gridy = 4;  
		    gbc.gridwidth = 1;  
		    JTextField tf13=new JTextField("Mango");
		  tf13.setEditable(false);
		  this.add(tf13,gbc);
		  
		  //R5 C4
		    gbc.gridx = 3;  
		    gbc.gridy = 4;  
		     gbc.gridwidth = 1;  
		    JTextField tf14=new JTextField("3");
		  tf14.setEditable(true);
		  this.add(tf14,gbc);
		    
		    //R6 Orange
		   gbc.fill = GridBagConstraints.HORIZONTAL;
		   //R6 C1
		    gbc.gridx = 0;  
		    gbc.gridy = 5;  
		    gbc.gridwidth = 1;  
		    JTextField tf15=new JTextField("Orange");
		  tf15.setEditable(false);
		  this.add(tf15,gbc); 
		     
		  //R6 C2
		    gbc.gridx = 1;  
		    gbc.gridy = 5;  
		    gbc.gridwidth = 1;  
		    JTextField tf16=new JTextField("8");
		  tf16.setEditable(false);
		  this.add(tf16,gbc); 
		  
		  //R6 C3
		    gbc.gridx = 2;  
		    gbc.gridy = 5;  
		    gbc.gridwidth = 1;  
		    JTextField tf131=new JTextField("Orange");
		  tf131.setEditable(false);
		  this.add(tf131,gbc);
		  
		  //R6 C4
		    gbc.gridx = 3;  
		    gbc.gridy = 5;  
		     gbc.gridwidth = 1;  
		    JTextField tf141=new JTextField("0");
		    tf141.setEditable(true);
		  	this.add(tf141,gbc);
		    
		    //R7 Banana
		    gbc.fill = GridBagConstraints.HORIZONTAL; 
		    //R7 C1
		    gbc.gridx = 0;  
		    gbc.gridy = 6;  
		    gbc.gridwidth = 1;  
		    JTextField tf111=new JTextField("Banana");
		    tf111.setEditable(false);
		    this.add(tf111,gbc); 
		    
		    //R7 C2
		    gbc.gridx = 1;  
		    gbc.gridy = 6;  
		    gbc.gridwidth = 1;  
		    JTextField tf121=new JTextField("2");
		    tf121.setEditable(false);
		    this.add(tf121,gbc); 
		    
		    //R7 C3
		    gbc.gridx = 2;  
		    gbc.gridy = 6;  
		    gbc.gridwidth = 1;  
		    JTextField tf1311=new JTextField("Banana");
		  tf1311.setEditable(false);
		  this.add(tf1311,gbc);
		  
		  //R7 C4
		    gbc.gridx = 3;  
		    gbc.gridy = 6;  
		     gbc.gridwidth = 1;  
		    JTextField tf1411=new JTextField("0");
		  tf1411.setEditable(true);
		  this.add(tf1411,gbc);
		  
		  //R8 pineapples
		    gbc.fill = GridBagConstraints.HORIZONTAL; 
		    //R8 C1
		    gbc.gridx = 0;  
		    gbc.gridy = 7;  
		    gbc.gridwidth = 1;  
		    JTextField tf1111=new JTextField("Pineapple");
		    tf1111.setEditable(false);
		    this.add(tf1111,gbc); 
		     
		    //R8 C2
		    gbc.gridx = 1;  
		    gbc.gridy = 7;  
		    gbc.gridwidth = 1;  
		    JTextField tf1211=new JTextField("1");
		    tf1211.setEditable(false);
		    this.add(tf1211,gbc); 
		    
		    //R8 C3
		    gbc.gridx = 2;  
		    gbc.gridy = 7;  
		    gbc.gridwidth = 1;  
		    JTextField tf13111=new JTextField("Pineapple");
		    tf13111.setEditable(false);
		    this.add(tf13111,gbc);
		    
		    //R8  C4
		    gbc.gridx = 3;  
		    gbc.gridy = 7;  
		     gbc.gridwidth = 1;  
		    JTextField tf14111=new JTextField("3");
		    tf14111.setEditable(true);
		    this.add(tf14111,gbc);
		    
		    //R9 Total of Inventory
		     gbc.fill = GridBagConstraints.HORIZONTAL; 
		     //R9 C1 Total of  Inventory
		    gbc.gridx = 0;  
		    gbc.gridy = 8;  
		    gbc.gridwidth = 1;  
		    JTextField tf17=new JTextField("Total");
		  tf17.setEditable(false);
		  this.add(tf17,gbc); 
		  
		  //R9 C2 Sum of the values changed when clicked submit button
		    gbc.gridx = 1;  
		    gbc.gridy = 8;  
		    gbc.gridwidth = 1; 
		    countin=Integer.parseInt(tf8.getText())+Integer.parseInt(tf12.getText())+Integer.parseInt(tf16.getText())+
		    		Integer.parseInt(tf121.getText())+Integer.parseInt(tf1211.getText());
		    JTextField tf19=new JTextField(countin+"");
		  tf19.setEditable(false);
		  this.add(tf19,gbc);
		  
		    //R9 C3 Total of User
		  	gbc.gridx = 2;  
		    gbc.gridy = 8;  
		    gbc.gridwidth = 1;  
		    JTextField tf18=new JTextField("Total");
		  tf18.setEditable(false);
		  this.add(tf18,gbc); 
		  
		  //R9 C4 Sum of all the values in User Click the submit button to show
		    gbc.gridx = 3;  
		    gbc.gridy = 8;  
		    gbc.gridwidth = 1; 
		    JTextField tf20=new JTextField(countout+"");
		    tf20.setEditable(false);
		    this.add(tf20,gbc);
		  
		    //Submit Button
		    gbc.gridx = 4;  
		    gbc.gridy = 8;  
		    gbc.gridwidth = 1; 
		    JButton b=new JButton("Submit");
		    this.add(b,gbc); 
		    
		    //Event Handler for the Button
		    b.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent evt) {
		        	 countout=Integer.parseInt(tf10.getText())+Integer.parseInt(tf14.getText())+Integer.parseInt(tf141.getText())+
		 		    		Integer.parseInt(tf1411.getText())+Integer.parseInt(tf14111.getText());
		            tf20.setText(countout + "");
		            
		            //Apples
		            
		           i=Integer.parseInt(tf8.getText())-Integer.parseInt(tf10.getText());
		           if(i>=0){
		           tf8.setText(i+"");
		           }
		           else{
		        	   tf10.setEditable(false);  
		           }
		           //Mango
		           int j=Integer.parseInt(tf12.getText())-Integer.parseInt(tf14.getText());
		           if(j>=0){
		           tf12.setText(j+"");
		           }
		           else{
		        	   tf14.setEditable(false);  
		           }
		           //Orange
		           int k=Integer.parseInt(tf16.getText())-Integer.parseInt(tf141.getText());
		           if(k>=0){
		           tf16.setText(k+"");
		           }
		           else{
		        	   tf141.setEditable(false); 
		           }
		           //Banana
		           int m=Integer.parseInt(tf121.getText())-Integer.parseInt(tf1411.getText());
		           if(m>=0){
		           tf121.setText(m+"");
		           }
		           else{
		        	   tf1411.setEditable(false);   
		           }
		           //pineapple
		           int n=Integer.parseInt(tf1211.getText())-Integer.parseInt(tf14111.getText());
		           if(n>=0){
		           tf1211.setText(n+"");
		           }
		           else{
		        	   tf14111.setEditable(false);  
		           }
		           
		           //Changing the total of the Inventory
		           countin=Integer.parseInt(tf8.getText())+Integer.parseInt(tf12.getText())+Integer.parseInt(tf16.getText())+
				    		Integer.parseInt(tf121.getText())+Integer.parseInt(tf1211.getText());
		           tf19.setText(countin+"");
		      
				}
		         
		        
		         
			});
		    
            setSize(400, 400);  
            setPreferredSize(getSize());  
            setVisible(true);  
            setDefaultCloseOperation(EXIT_ON_CLOSE);  
      
        }
	
       
      
}  