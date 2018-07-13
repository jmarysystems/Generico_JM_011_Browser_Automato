package browser_automato_menu_e_submenu;

import br.com.jmary.home.Home;
import br.com.jmary.utilidades.Exportando;
import br.com.jmary.utilidades.JOPM;
import br.com.jmary.utilidades.PopupMenu_Colar;
import browser_automato.BrowserFX;
import browser_automato.Email_Enviar;
import browser_automato.Executar_Acao;
import browser_automato.Google_Obter_Emails;
import browser_automato.Tabela_Automato;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ana
 */
public class Browser_Automato_Submenu_01 extends javax.swing.JPanel {
    
    Exportando Exportando;
    PopupMenu_Colar PopupMenu_Colar;
    Home Home;
        
    public Browser_Automato_Submenu_01( Home Home2 ) {
        Home = Home2;
        
        initComponents();
    }
    
    JPanel jp_AutomatoT; 
    List<String[]> elements;
    public void iniciarT(List<String[]> elements_recebido) {                                     
        elements = elements_recebido;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );             
            jp_AutomatoT = new JPanel( new BorderLayout() );  
            Home.adicionar_Tela_De_Trabalho("Autômato", jp_AutomatoT);
            abrir_browser();
            //automatoT();
        } catch( Exception e ){ e.printStackTrace(); } } }.start();
    }
    
    public void automatoT() {                                     
        new Thread() {   @Override public void run() { try {            
            //while(true){
                Thread.sleep( 30000 );                          
                jp_AutomatoT.removeAll();
                validate();
                Thread.sleep( 1 );
                abrir_browser();
            //}
        } catch( Exception e ){ e.printStackTrace(); } } }.start();
    }
    
    String[] strArray;
    String acao = "";
    public BrowserFX BrowserFXT;
    public void abrir_browser(){ try {
        
        BrowserFXT = new BrowserFX( tf_Endereco.getText().trim(),true,true,true, new JButton() );
        jp_AutomatoT.add( BrowserFXT, BorderLayout.CENTER ); 
        Thread.sleep( 30000 );  
        
        //codigo_fonte();
      
        preparar_lista();
        
        if( rb_auto.isSelected() == true ){
            automatoT();  
        }
    } catch( Exception e ){} }
    
    public void preparar_lista(){ try {
        
        for (int i = 0; i < elements.size(); i++){ 
            //strArray = elements.get(i);                    
            String tipo = ""; try{ tipo  = elements.get(i)[0].trim();            }catch( Exception e ){ System.out.println( "tipo - " ); e.printStackTrace();  }
            int   tempo = 1;  try{ tempo = Integer.parseInt(elements.get(i)[1]); }catch(Exception e){   System.out.println( "tempo - " ); e.printStackTrace(); }
            String acao = ""; try{ acao  = elements.get(i)[2].trim();            }catch( Exception e ){ System.out.println( "acao - " ); e.printStackTrace();  }
            
            if( tipo.equalsIgnoreCase("SCRIPT") ){
                Thread.sleep( tempo );                
                Executar_Acao Executar_Script = 
                        new Executar_Acao( BrowserFXT, elements.get(i)[2] );
            }
        }
          
    } catch( Exception e ){} } 
    
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////   

    List<String> elementsR;
    public void iniciarR(List<String> elementsR2) {                                     
        elementsR = elementsR2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );             
            
            for (Iterator<String> it = elementsR.iterator(); it.hasNext();) {
                jp_AutomatoT.removeAll();
                validate();
                Thread.sleep( 1000 );
                
                String busca = it.next().trim();
                abrir_browserR( busca );
                                                
                Thread.sleep( 50000 ); 
                abrir_EmailR();
                Thread.sleep( 10000 );
                                
                jp_AutomatoT.removeAll();
                validate();
                Thread.sleep( 1000 );
            }
        } catch( Exception e ){ } } }.start();
    }
    
    String link;
    public void abrir_browserR( String link2 ){ try { link = link2;        
        System.out.println( link );
        
        new Thread() {   @Override public void run() { try { 
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                BrowserFXT = new BrowserFX( link.trim(),true,true,true, new JButton() );
                jp_AutomatoT.add( BrowserFXT, BorderLayout.CENTER ); 
            }
        });
        } catch( Exception e ){ e.printStackTrace(); } } }.start();
        
    } catch( Exception e ){ e.printStackTrace(); } }
    
    String html_boo2;
    private void abrir_EmailR(){ try {        
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                try{           
                    String html_boo = (String) BrowserFXT.eng.executeScript("document.documentElement.outerHTML");                    
                    html_boo2 = html_boo.replace( ">", ">\n" );
                    //System.out.println(html_boo2);
                                                            
                }catch( Exception e ){ System.out.println( "codigo_fonte - " ); e.printStackTrace(); }  
            }
        });
        
        Google_Obter_Emails Google_Obter_Emails = new Google_Obter_Emails(html_boo2, this);
        
    } catch( Exception e ){} }       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel28 = new javax.swing.JPanel();
        JPOpcao_26 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        JPOpcao_27 = new javax.swing.JPanel();
        tf_Endereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rb_auto = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(561, 71));

        JPOpcao_26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_26.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_26MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_26MousePressed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel80.setText("Endereço.: ");

        javax.swing.GroupLayout JPOpcao_26Layout = new javax.swing.GroupLayout(JPOpcao_26);
        JPOpcao_26.setLayout(JPOpcao_26Layout);
        JPOpcao_26Layout.setHorizontalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPOpcao_26Layout.setVerticalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80)
        );

        JPOpcao_27.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_27.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_27MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_27MousePressed(evt);
            }
        });

        tf_Endereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_Endereco.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Endereco.setText("https://www.google.com.br");
        tf_Endereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_Endereco.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_Endereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_EnderecoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_EnderecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_EnderecoMouseExited(evt);
            }
        });
        tf_Endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_EnderecoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_27Layout = new javax.swing.GroupLayout(JPOpcao_27);
        JPOpcao_27.setLayout(JPOpcao_27Layout);
        JPOpcao_27Layout.setHorizontalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_Endereco, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_27Layout.setVerticalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/nuvem.png"))); // NOI18N
        jLabel1.setText("Iniciar Configuração");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setText("Browser Autômator - JMarySystems");

        rb_auto.setText("Auto");
        rb_auto.setToolTipText("Enviar Endereço de Html da Web Mais mostrar os controles");
        rb_auto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rb_autoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(JPOpcao_27, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JPOpcao_26, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rb_auto)
                        .addComponent(jLabel2)))
                .addGap(163, 163, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPOpcao_26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_auto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPOpcao_27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JPOpcao_26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseEntered

    private void JPOpcao_26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseExited

    private void JPOpcao_26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MousePressed

    private void tf_EnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_EnderecoMouseClicked
        try{
            PopupMenu_Colar = new PopupMenu_Colar(tf_Endereco);
        } catch( Exception e ){}
    }//GEN-LAST:event_tf_EnderecoMouseClicked

    private void tf_EnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_EnderecoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EnderecoMouseEntered

    private void tf_EnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_EnderecoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EnderecoMouseExited

    private void tf_EnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_EnderecoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EnderecoKeyReleased

    private void JPOpcao_27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseEntered

    private void JPOpcao_27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseExited

    private void JPOpcao_27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MousePressed

    
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed

        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );             
            Exportando = new Exportando("ABRINDO");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0); 
            Exportando.pbg.setMaximum( 100 );
            Exportando.pbg.setValue( 50 );
            
            configurar_tabela();
            
            Exportando.fechar();
        } catch( Exception e ){ Exportando.fechar(); e.printStackTrace(); } } }.start();
    }//GEN-LAST:event_jLabel1MousePressed

    private void rb_autoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_autoMousePressed

    }//GEN-LAST:event_rb_autoMousePressed

    private void configurar_tabela() {                                     

        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );             
            
            Tabela_Automato Tabela_Automato = new Tabela_Automato(Home, this);
            Home.adicionar_Tela_De_Trabalho("Configurar Ações", Tabela_Automato);
            
        } catch( Exception e ){ e.printStackTrace(); } //} }.start();
    } 
    
    JPanel jp_Automato; 
    private void iniciar() {                                     

        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );             
            jp_Automato = new JPanel( new BorderLayout() );  
            Home.adicionar_Tela_De_Trabalho("Autômato", jp_Automato);
            executar_acoes();
            //automato();
        } catch( Exception e ){ e.printStackTrace(); } } }.start();
    }
    
    public void automato() {                                     
        new Thread() {   @Override public void run() { try {            
            //while(true){
                Thread.sleep( 60000 );                          
                jp_Automato.removeAll();
                validate();
                executar_acoes();
            //}
        } catch( Exception e ){ e.printStackTrace(); } } }.start();
    } 
        
    BrowserFX BrowserFX;
    List<String> list_cmd;
    List<File> fileMails;
    public void executar_acoes(){        
        /*new Thread() {   @Override public void run() {*/ try { 

        String destinatario  = "jmarysystems0001@gmail.com";
        String assunto = "0123456789";
        String login   = "jmarysystems0001@gmail.com";
        String pass    = tf_Endereco.getText().trim();
        
        list_cmd = new ArrayList();
        list_cmd.add(destinatario);                               //Destinatário "jmarysystems@gmail.com"
        list_cmd.add( pass );                                  //Senha //"subzero3463"
        list_cmd.add( login );                    //E-mail //"subzero3463.01@gmail.com"  -  "pretim21@gmail.com"
        list_cmd.add( "Cleilson Henrique de Araujo" );          //nome do remetente do email //"subzero3463.01"
        list_cmd.add( assunto ); 
        
        fileMails = new ArrayList<File>();                       //lista contendo os arquivos anexos
        String arquivo1 = "/anexos/CLEILSON_HENRIQUE_DE_ARAUJO" + ".pdf";
        fileMails.add(new File(arquivo1));
                       
        BrowserFX = new BrowserFX( tf_Endereco.getText().trim(),true,true,true, new JButton() );
        jp_Automato.add( BrowserFX, BorderLayout.CENTER );        
        
        Thread.sleep( 60000 );     
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                BrowserFX.eng.executeScript( "document.getElementById('login-email').value = 'cleilsoninfo2@gmail.com'" );
                BrowserFX.eng.executeScript( "document.getElementById('login-password').value = '" + "282.23071354.282" + "'" );
                //BrowserFX.eng.executeScript( "document.querySelector('[name=signin]').click()" ); 
                BrowserFX.eng.executeScript( "document.getElementById('login-submit').click()" );
            }
        });
        
        Thread.sleep( 15000 ); 
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                //BrowserFX.eng.executeScript( "window.location.href = 'http://192.168.0.1/status.htm';" ); 
            }
        }); 
        
        Thread.sleep( 10000 ); 
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                String enderecoX = BrowserFX.eng.getLocation();
                System.out.println("enderecoX: " + enderecoX);
                String endereco = "http://192.168.0.1/status.htm?username='Admin'&password='23071354'";
                String html = (String) BrowserFX.eng.executeScript("document.documentElement.outerHTML");
                System.out.println(html);
                //webClient_HtmlUnit( html, list_cmd, fileMails );
            }
        });      
//////////////////////////////////////////////////////////////          
            automato();
//////////////////////////////////////////////////////////////   
        } catch( Exception e ){
//////////////////////////////////////////////////////////////           
            automato();
//////////////////////////////////////////////////////////////   
            System.out.println("Erro - " + e.getMessage());
            /*
            e.printStackTrace(); JOPM JOPM = new JOPM( "MÉTODO: " + "criar_mensagem_e_setar_remetentes()\n"
                    ,"\nErro ao tentar criar_mensagem_e_setar_remetentes" 
                    ,this.getClass().getName() ); 
            */
        } //} }.start();                 
    }
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPOpcao_26;
    private javax.swing.JPanel JPOpcao_27;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JRadioButton rb_auto;
    public javax.swing.JTextField tf_Endereco;
    // End of variables declaration//GEN-END:variables
    
    String ip = "";
    public void webClient_HtmlUnit(String html, List<String> list_cmd, List<File> fileMails){  
        /*new Thread() {   @Override public void run() {*/ try { 
        ip = "";    
   
        StringTokenizer st1=new StringTokenizer(html,"\n");
        for (int i = 0; st1.hasMoreTokens(); i++) {
            String row = ""; try{ row = st1.nextToken(); }catch( Exception e ){} 
            if(i == 227 ){
                
                //System.out.println(i + " - " + row);
                StringTokenizer st2=new StringTokenizer(row,"</b>");
                for (int j = 0; st2.hasMoreTokens(); j++) {
                    String row_parte = ""; try{ row_parte = st2.nextToken(); }catch( Exception e ){} 
                    //System.out.println(j + " - " + row_parte);
                    if(j == 2 ){
                        ip = row_parte.trim();
                        System.out.println(j + " - " + row_parte);
                        Email_Enviar Email_Enviar = new Email_Enviar( list_cmd, fileMails, ip, this ); 
                    }
                }
            }
        }        
        
        } catch( Exception e ){ e.printStackTrace(); JOPM JOPM = new JOPM( "MÉTODO: " + "criar_mensagem_e_setar_remetentes()\n"
                    ,"\nErro ao tentar criar_mensagem_e_setar_remetentes" 
                    ,this.getClass().getName() ); 
        } //} }.start(); 
    }
    
}