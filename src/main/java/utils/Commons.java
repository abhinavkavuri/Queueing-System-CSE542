package utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/
public class Commons {

    public static JButton defineButton(Font font, Color bColor, Color fColor, String placeholder, int x, int y, int width, int height){
        JButton button  = new JButton(placeholder);
        button.setBounds(x, y, width, height);
        if(font != null)    button.setFont(font);
        if(bColor != null)  button.setBackground(bColor);
        if(fColor != null)  button.setForeground(fColor);
        button.setOpaque(true);
        return  button;
    }

    public static JLabel defineLabel(String placeholder, Font font, int x, int y, int width, int height){
        JLabel label = new JLabel(placeholder);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        return label;
    }

    public static  JPanel definePanel(EmptyBorder border){
        JPanel panel = new JPanel();
        panel.setBorder(border);
        panel.setLayout(null);
        return  panel;
    }

    public static  JTextField defineTextField(Font font, String placeholder, int x, int y, int width,int height, int columns){
        JTextField field = new JTextField();
        field.setBounds(x, y, width, height);
        field.setToolTipText(placeholder);
        field.setFont(font);
        field.setColumns(columns);
        return field;
    }
}
