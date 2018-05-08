package pra;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener {
	 private TextField tfMouseX; // to display mouse-click-x
	   private TextField tfMouseY; // to display mouse-click-y
	 
	   // Constructor - Setup the UI components and event handlers
	   public MouseEventDemo() {
	      setLayout(new FlowLayout()); // "super" frame sets its layout to FlowLayout
	 
	      // Label (anonymous)
	      add(new Label("X-Click: ")); // "super" frame adds Label component
	 
	      // TextField
	      tfMouseX = new TextField(10); // 10 columns
	      tfMouseX.setEditable(false);  // read-only
	      add(tfMouseX);                // "super" frame adds TextField component
	 
	      // Label (anonymous)
	      add(new Label("Y-Click: ")); // "super" frame adds Label component
	 
	      // TextField
	      tfMouseY = new TextField(10);
	      tfMouseY.setEditable(false);  // read-only
	      add(tfMouseY);                // "super" frame adds TextField component
	 
	      addMouseListener(this);
	          // "super" frame (source) fires the MouseEvent.
	          // "super" frame adds "this" object as a MouseEvent listener.
	 
	      setTitle("MouseEvent Demo"); // "super" Frame sets title
	      setSize(350, 100);           // "super" Frame sets initial size
	      setVisible(true);            // "super" Frame shows
	   }
	 
	   public static void main(String[] args) {
	      new MouseEventDemo();  // Let the constructor do the job
	   }
	 
	   /* MouseEvent handlers */
	   // Called back upon mouse clicked
	   @Override
	   public void mouseClicked(MouseEvent evt) {
	      tfMouseX.setText(evt.getX() + "");
	      tfMouseY.setText(evt.getY() + "");
	   }
	 
	   // Not used - need to provide an empty body to compile.
	   @Override public void mousePressed(MouseEvent evt) { }
	   @Override public void mouseReleased(MouseEvent evt) { }
	   @Override public void mouseEntered(MouseEvent evt) { }
	   @Override public void mouseExited(MouseEvent evt) { }

}
