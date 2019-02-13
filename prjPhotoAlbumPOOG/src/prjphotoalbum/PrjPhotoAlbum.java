/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjphotoalbum;

import GUI.MainWindow;

/**
 *
 * @author morgana
 */
public class PrjPhotoAlbum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindow w = new MainWindow() ;
			w.setVisible(true);
		/*try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
			} 
			catch (UnsupportedLookAndFeelException e) {
				System.out.println("Look & Feel non supportato");
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			catch (InstantiationException e) {
				System.out.println("L'oggetto non puo' essere istanziato");
			}
			catch (IllegalAccessException e) {
				System.out.println("e"); //a cosa serve questa eccezione?Che stampa è una e?
			}
			
			WelcomeWindow w = new WelcomeWindow() ;
			w.setVisible(true);

		}*/
    }
    
}
