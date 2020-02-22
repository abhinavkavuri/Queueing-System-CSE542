import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class ReservationQueue {
   private JFrame mainFrame;
   
   private JLabel headerLabel;
   private JList<String> queueLabel;
   
   private JPanel buttonPanel;

   public ReservationQueue(){
      prepareGUI();
   } 
   public static void main(String[] args){
	   ReservationQueue Student = new ReservationQueue();  
	   Student.showEventDemo();       
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Queueing System");
      mainFrame.setSize(1000,800); 
      mainFrame.setLayout(new GridLayout(5, 5));

      headerLabel = new JLabel("",JLabel.CENTER );
      
      DefaultListModel<String> l1 = new DefaultListModel<>();  
      l1.addElement("Item1");  
      l1.addElement("Item2");  
      l1.addElement("Item3");  
      l1.addElement("Item4");
      
      queueLabel = new JList<>(l1);
      DefaultListCellRenderer renderer = (DefaultListCellRenderer) queueLabel.getCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(buttonPanel);
      mainFrame.add(queueLabel);
      mainFrame.setVisible(true);  
   }
   private void showEventDemo(){
      headerLabel.setText("Welcome to Queueing System !"); 
      headerLabel.setFont(new Font("Serif", Font.PLAIN, 32));

      JButton addButton = new JButton("+ Add Entry");
      addButton.setForeground(Color.WHITE);
      addButton.setBackground(Color.BLACK);
      addButton.setFont(new Font("Roboto", Font.BOLD, 14));
      
      
      JButton removeButton = new JButton(" - Remove Entry");
      removeButton.setForeground(Color.WHITE);
      removeButton.setBackground(Color.RED);
      removeButton.setFont(new Font("Roboto", Font.BOLD, 14));
      
      JButton pauseButton = new JButton(" > Pause Entry");
      pauseButton.setForeground(Color.BLACK);
      //pauseButton.setBackground(Color.CYAN);
      pauseButton.setFont(new Font("Roboto", Font.BOLD, 14));
      
  JButton unpauseButton = new JButton(" < Unpause Entry");
      unpauseButton.setForeground(Color.BLACK);
      unpauseButton.setFont(new Font("Roboto", Font.BOLD, 14));
      
      addButton.setActionCommand("ADD");
      removeButton.setActionCommand("REMOVE");
      pauseButton.setActionCommand("PAUSE");
      unpauseButton.setActionCommand("UNPAUSE");

      addButton.addActionListener(new ButtonClickListener()); 
      removeButton.addActionListener(new ButtonClickListener()); 
      pauseButton.addActionListener(new ButtonClickListener()); 
      unpauseButton.addActionListener(new ButtonClickListener()); 

      buttonPanel.add(addButton);
      buttonPanel.add(removeButton);
      buttonPanel.add(pauseButton);  
      buttonPanel.add(unpauseButton);

      mainFrame.setVisible(true);  
   }
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         
         if( command.equals( "ADD" ))  {
            
         } else if( command.equals( "REMOVE" ) )  {
             
         }else if( command.equals( "PAUSE" ) )  {
             
          } else {
            
         }  	
      }		
   }
}