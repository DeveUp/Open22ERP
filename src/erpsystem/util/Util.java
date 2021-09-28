/*
 * The MIT License
 *
 * Copyright 2015 Diego Geronimo D' Onofre.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package erpsystem.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.Serializable;

import static javax.swing.JOptionPane.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class Util implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void msg(String s)
    {
        showMessageDialog(null, s);
    }
    
	/**
	 * Verifica se é um valor inteiro válido.
	 */
    public static boolean isInt(String value)
    {
        try{
            Integer.parseInt(value);
            return true;
        }
        catch ( Exception e ){
            return false;
        }
    }
    
    /**
	 * Verifica se é um Double válido.
     */
    public static boolean isDouble(String value)
    {
        try{
            Double.parseDouble(value);
            return true;
        }
        catch ( Exception e ){
            return false;
        }
    }
    
    /**
     * Utilize este método para ter o Point que adiciona o a Janela no centro.
     */
    public static Point getCenterPoint( final int w, final int h )
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        final int x = ( int ) ( d.getWidth() / 2 ) - ( w / 2 );
        final int y = ( int ) ( d.getHeight() / 2 ) - ( h / 2 );
        return new Point( x, y );
    }     
    
    /** 
     * Verifica se o char é de valor de preço.
     */
    public static boolean isValidPriceChar(char charValue)
    {
        String s =  String.valueOf(charValue);
        int value = isInt(s) ? Integer.parseInt(s):-1;
        
        if ( value >= 0 && value <= 9  )
            return true;
        else if ( charValue == '.' )
            return true;
        
        return false;
    }
    
    public static DefaultTableCellRenderer getDefaultCellRenderer(){
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER); 
        return cellRender;
    }
    
}
