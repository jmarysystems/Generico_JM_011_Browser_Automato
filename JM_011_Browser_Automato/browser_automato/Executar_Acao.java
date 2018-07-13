/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser_automato;

import br.com.jmary.home.imagens.Imagens_Internas;
import br.com.jmary.utilidades.JOPM;
import javafx.application.Platform;
import javax.swing.ImageIcon;

/**
 *
 * @author NewUser
 */
public class Executar_Acao {
    
    BrowserFX BrowserFXT;
    String script;
    
    public Executar_Acao(BrowserFX BrowserFXT2, String script2) {
        
        BrowserFXT = BrowserFXT2;
        script = script2;
        
        executar_Script();
    }
    
    private void executar_Script(){ try {        
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                try{           
                    System.out.println( "executar_Script(); - " + script );
                    BrowserFXT.eng.executeScript( script );
                }catch( Exception e ){ System.out.println( "class Executar_Script - " ); e.printStackTrace(); }  
            }
        });
          
    } catch( Exception e ){ 
        Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            //ImageIcon icon = new ImageIcon( clazzHome.getResource( imgURLIcon ) );
                    JOPM JOptionPaneMod = new JOPM( 1, "ERRO AO EXECUTAR AÇÃO\n"
                            + "\nERRO AO EXECUTAR SCRIPT:"
                            + script
                            + "\nOK Para Prosseguir"
                            ,"Class: " + this.getClass().getName(), 
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
    } }
    
}
