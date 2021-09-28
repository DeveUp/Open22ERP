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

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.Serializable;
import java.net.URL;

import javafx.scene.layout.AnchorPane;

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

    public static AnchorPane loadViewFXML(AnchorPane panel, URL path) throws Exception {
    	Parent parent = FXMLLoader.load(path);
		if(panel != null) {
			if(panel.getChildren().size() == 0 || panel.getChildren().removeAll(panel.getChildren())) {
				panel.getChildren().addAll(parent);
			}
		}
		return panel;
    }  
    
    
    public static boolean isChain(String chain) {
    	return (chain != null && chain.length() > 0 && chain.trim().length() > 0);
    }
    
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
    
    public static Double parseDouble(String value) {
    	if(isDouble(value)) {
    		return Double.parseDouble(value);
    	}
		return 0.0;
    }
    
}
