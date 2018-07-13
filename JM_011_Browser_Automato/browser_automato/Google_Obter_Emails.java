package browser_automato;

import browser_automato_menu_e_submenu.Browser_Automato_Submenu_01;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NewUser
 */
public class Google_Obter_Emails {
    
    Browser_Automato_Submenu_01 Browser_Automato_Submenu_01;
    String html;
    
    public Google_Obter_Emails(String html2, Browser_Automato_Submenu_01 Browser_Automato_Submenu_012) {
        html = html2;
        
        Browser_Automato_Submenu_01 = Browser_Automato_Submenu_012;
        
        executar_google();
    }
            
    private void executar_google(){ try {        
        
        InputStream stream = new ByteArrayInputStream( html.getBytes() );
        InputStreamReader isr = new InputStreamReader( stream );
        BufferedReader br = new BufferedReader( isr );      
        while(br.ready()){
            String linha = br.readLine();
            inicio( linha );   
        }
        br.close();                   
          
    } catch( Exception e ){ e.printStackTrace(); } }
    
    int cont = 0;
    int contador = 0;
    int contlinha = 0;
    StringBuilder sb = new StringBuilder();
    boolean tag_1 = false;  
    private void inicio( String linha ) {        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
                                
            if( linha.trim().contains( "@" ) ){                
                tag_1 = true;
                System.out.println(linha);
            }
                        
        } catch( Exception e ){ e.printStackTrace(); } //} }.start();
    }
    
     private void link( String linha ) {        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
        
            if( linha.trim().contains( "<a href=\"/url?q=" ) ){ 
                String linha_new = linha.replace( "<a href=\"/url?q=", " " );
                retirar_link(linha_new);
                //System.out.println(linha);
            }
                                            
        } catch( Exception e ){ e.printStackTrace(); } //} }.start();
    }
     
    List<String[]> link_s = new ArrayList<String[]>();    
    private void retirar_link(String linha){ try {        
        
        String[] strArray = linha.split("/");     
        link_sem_repeticao.add( strArray[0] + "//" + strArray[1] + strArray[2] );
        //System.out.println( strArray[0] + "//" + strArray[1] + strArray[2] );
        listar_links();
          
    } catch( Exception e ){ e.printStackTrace(); } } 
    
    //LinkedHashSet<String> link_sem_repeticao = new LinkedHashSet<>();
    List<String> link_sem_repeticao = new ArrayList<String>();  
    private void listar_links(){ try {        
        /*
        for (Iterator<String> it = link_sem_repeticao.iterator(); it.hasNext();) {
                
            String busca = it.next().trim();
            System.out.println( busca );
        }
        */
        
        Browser_Automato_Submenu_01.iniciarR( link_sem_repeticao );
          
    } catch( Exception e ){ e.printStackTrace(); } }    
    
}
