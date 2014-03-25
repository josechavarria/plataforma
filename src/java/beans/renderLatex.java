/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 * esta classe contem o metodo responsavel por gerar uma imagem de acordo com uma string latex
 * @author josechavarria
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



import org.scilab.forge.jlatexmath.*;


public  class renderLatex {
	
	private JTextArea latexSource;
	private JButton btnRender;
	private JPanel drawingArea;

    /**
     * retorna uma imagem relativa a uma string latex
     * @param latex
     * @return
     */
    @SuppressWarnings("empty-statement")
	public   BufferedImage renderLatex( String latex){
	BufferedImage image=null;	
            try {
			// get the text
			
                           
			
			// create a formula
			TeXFormula formula = new TeXFormula(latex);
			
			// render the formla to an icon of the same size as the formula.
			TeXIcon icon = formula
					.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20) ;
			icon.setForeground(new Color(0,0,0));
			// insert a border 
			icon.setInsets(new Insets(5, 5, 5, 5));

			// now create an actual image of the rendered equation
			 image = new BufferedImage(icon.getIconWidth(),
					icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = image.createGraphics();
                      
                        g2.setColor(new Color(0,0,0,0));
              
                      
                    
			
			g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
			JLabel jl = new JLabel();
			jl.setForeground(new Color(0, 0, 0));
			icon.paintIcon(jl,g2, 0, 0);
			// at this point the image is created, you could also save it with ImageIO
			
			// now draw it to the screen	
                        
			
		} catch (ParseException ex) {
			
			
                        image=null;
		}
                    return image;
	}

	

	
		
	}