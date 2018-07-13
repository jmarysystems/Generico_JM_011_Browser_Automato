
package browser_automato;

import Sons.Som;
import br.com.jmary.home.Home;
import br.com.jmary.home.imagens.Imagens_Internas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import br.com.jmary.home.jpa.DB;
import br.com.jmary.utilidades.Arquivo_Ou_Pasta;
import br.com.jmary.utilidades.Exportando;
import br.com.jmary.utilidades.ImportarExportarExcel;
import br.com.jmary.utilidades.JFileChooserJM;
import br.com.jmary.utilidades.JOPM;
import browser_automato_menu_e_submenu.Browser_Automato_Submenu_01;
import home_controle_menus_norte.imagens.Imagens_Menu_Norte;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import usuarios_do_sistema_03_cadastro_automatizado_ajuda.Usuarios_Do_Sistema_03_Cadastro_Automatizado_Ajuda;
import usuarios_do_sistema_excel.Usuarios_Do_Sistema_Excel_Modelo;
import usuarios_do_sistema_imprimir.Usuarios_Do_Sistema_Imprimir_01_Controle;
import visualizador_imagens.Visualizador_Interno;

/**
 *
 * @author AnaMariana
 */
public class Tabela_Automato extends javax.swing.JPanel {   
    
    Som tocarSon = new Som();
    int resposta = 0;
    boolean respondeuCerto = false;
    JPanel PerguntaX = new JPanel();
    
    Browser_Automato_Submenu_01 Browser_Automato_Submenu_01;
    
    Home Home;
    
    /** Creates new form SombraVendas
     * @param Home2
     * @param Browser_Automato_Submenu_01R */
    public Tabela_Automato( Home Home2, Browser_Automato_Submenu_01 Browser_Automato_Submenu_01R ) {
        initComponents();
        
        Home = Home2;
        
        Browser_Automato_Submenu_01 = Browser_Automato_Submenu_01R;
        
        PerguntaX = Pergunta;
        
        //Home.ControleTabs.removerTabSemControleSelecionadoPeloNome(jTabbedPane1,Pergunta);
        inserirTab_Interna_Ajuda();
        
        setarUrl_e_ImageIcon_Seta_Inicio();
        tabelaInicio();   
        
        setar_DefaultTableModel_tbPreferedSize(1);  
        setar_DefaultTableModel_tmPesquisa(1);
        
        inicio_scripts();
    }
    
    private ListSelectionModel               lsmPesquisa;
    public DefaultTableModel                tmPesquisa = new DefaultTableModel( null, new String[]{ 
                "TIPO", "TEMPO", "AÇÃO"           
            } );
    
    private void inicio_scripts(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            /*
            String script1 = "window.location.href='https://www.google.com/'" ;
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "60000", script1 });
            
            String script12 = "window.location.href='https://www.yahoo.com'" ;
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "60000", script12 });
            */
            
            String script1 = "window.location.href='https://www.google.com.br/search?num=999&q=distribuidora messejana'" ;
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "10000", script1 });
            
            /*
            String script2 = "document.getElementById('lst-ib').value = '" + "distribuidora messejana" + "'";
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "10000", script2 }); 
            */
            
            /*
            String script3 = "document.getElementById('login-submit').click()" ;
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "10000", script3 });
            */
            
            /*
            String script3 = "document.querySelector('[name=btnK]').click()" ;
            tmPesquisa.addRow(new Object[]{ "SCRIPT", "10000", script3 });
            */
            
            
        } catch( Exception e ){  } } }.start();                 
    }
    
    private void inserirTab_Interna_Ajuda(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////         
            int img_Atual = 1;
            int quantidade_de_arquivos_ajuda = 2;    //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////             
            
            JScrollPane sc = new JScrollPane();
            sc.setViewportView( new Visualizador_Interno(Home,img_Atual,quantidade_de_arquivos_ajuda,Usuarios_Do_Sistema_03_Cadastro_Automatizado_Ajuda.class) );
            
//            //Home.ControleTabs.AddTabSemControleNovoSemThread(jTabbedPane1, "Ajuda", "ajuda.gif", sc);
            
            Thread.sleep( 5 ); 
            //Adicionando pergunta após a ajuda
//            //Home.ControleTabs.AddTabSemControleNovoSemThread(jTabbedPane1, "Cadastrar Usuário", "livroTp.gif", PerguntaX);
                        
        } catch( Exception e ){  } } }.start();                 
    }
    
    private void inserirTab_Externa_PPT(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////         
            String endereco_Externo_da_Pasta = System.getProperty("user.dir") + "\\00_Externo\\Cencosud\\Documentos\\"
                    + "Elenco\\Consultar\\IMG_PPT\\";  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////             
            int img_Atual = 0; 
            
            JScrollPane sc = new JScrollPane();
            //sc.setViewportView( new Visualizador_Externo(Home,img_Atual,endereco_Externo_da_Pasta) );
            
            Home.ControleTabs.AddTabsAoHome("PPT", "livroTp.gif", sc );
       
        } catch( Exception e ){  } } }.start();                 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Pergunta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPesquisa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        JPOpcao_26 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        JPOpcao_27 = new javax.swing.JPanel();
        tf_Tempo = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jp_Opcoes_Tabela = new javax.swing.JPanel();
        jp_Opcoes = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lb_Exportar_Exel = new javax.swing.JLabel();
        lb_Impressora = new javax.swing.JLabel();
        lbFiltro1 = new javax.swing.JLabel();
        lbFiltro2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbLinha_Tabela = new javax.swing.JLabel();
        lbColuna_Tabela = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(832, 504));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1170, 1202));

        jScrollPane2.setBorder(null);

        tbPesquisa.setModel(tmPesquisa);
        tbPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPesquisaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbPesquisa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Browser Autômato - JMarySystems");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/seta_para_cima.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(jTextPane1);

        jPanel14.setBackground(new java.awt.Color(0, 0, 102));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cole Aqui");
        jLabel16.setToolTipText("Cole o Texto ao Lado e Click em Importar Texto ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jmary/home/imagens/livroTp.gif"))); // NOI18N
        jButton6.setText("Cadastrar Ação");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SCRIPT", "MOUSE", "TECLADO" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

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
        jLabel80.setText("Tempo:");

        javax.swing.GroupLayout JPOpcao_26Layout = new javax.swing.GroupLayout(JPOpcao_26);
        JPOpcao_26.setLayout(JPOpcao_26Layout);
        JPOpcao_26Layout.setHorizontalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPOpcao_26Layout.setVerticalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        tf_Tempo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_Tempo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Tempo.setText("60000");
        tf_Tempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_Tempo.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_Tempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_TempoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_TempoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_TempoMouseExited(evt);
            }
        });
        tf_Tempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_TempoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_27Layout = new javax.swing.GroupLayout(JPOpcao_27);
        JPOpcao_27.setLayout(JPOpcao_27Layout);
        JPOpcao_27Layout.setHorizontalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_Tempo, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_27Layout.setVerticalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jmary/home/imagens/livroTp.gif"))); // NOI18N
        jButton8.setText("Limpar Ações");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(JPOpcao_26, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JPOpcao_27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8))
                .addGap(29, 29, 29))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JPOpcao_27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPOpcao_26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_Opcoes.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("IMPORTAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 0, 51));
        jPanel10.setPreferredSize(new java.awt.Dimension(130, 43));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("OPÇÕES");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(253, 254, 247));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/android_24.png"))); // NOI18N
        jLabel8.setToolTipText("IMPORTAR DA MEMÓRIA");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel8))
        );

        jPanel13.setBackground(new java.awt.Color(253, 254, 247));

        lb_Exportar_Exel.setForeground(new java.awt.Color(0, 102, 0));
        lb_Exportar_Exel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/xlsx.png"))); // NOI18N
        lb_Exportar_Exel.setToolTipText("EXPORTAR PARA EXCEL");
        lb_Exportar_Exel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_Exportar_Exel.setEnabled(false);
        lb_Exportar_Exel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_Exportar_ExelMousePressed(evt);
            }
        });

        lb_Impressora.setForeground(new java.awt.Color(0, 102, 0));
        lb_Impressora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/printv.png"))); // NOI18N
        lb_Impressora.setToolTipText("IMPRIMIR ");
        lb_Impressora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_Impressora.setEnabled(false);
        lb_Impressora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_ImpressoraMousePressed(evt);
            }
        });

        lbFiltro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/filtro2.png"))); // NOI18N
        lbFiltro1.setToolTipText("FILTRAR COLUNA - PELO ITEM SELECIONADO");
        lbFiltro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFiltro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFiltro1MousePressed(evt);
            }
        });

        lbFiltro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/filtro2reverso.png"))); // NOI18N
        lbFiltro2.setToolTipText("EXCLUIR TODOS DA COLUNA = ITEM SELECIONADO");
        lbFiltro2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFiltro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFiltro2MousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/exluir.png"))); // NOI18N
        jLabel6.setToolTipText("EXCLUIR COLUNA SELECIONADA");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/zoom_out.png"))); // NOI18N
        jLabel9.setToolTipText("PROCURAR E EXCLUIR");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        lbLinha_Tabela.setForeground(new java.awt.Color(0, 102, 0));
        lbLinha_Tabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/tabela_horizontal.png"))); // NOI18N
        lbLinha_Tabela.setToolTipText("EXPORTAR PARA EXCEL");
        lbLinha_Tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLinha_Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbLinha_TabelaMousePressed(evt);
            }
        });

        lbColuna_Tabela.setForeground(new java.awt.Color(0, 102, 0));
        lbColuna_Tabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/tabela_vertical.png"))); // NOI18N
        lbColuna_Tabela.setToolTipText("EXPORTAR PARA EXCEL");
        lbColuna_Tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbColuna_Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbColuna_TabelaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_Impressora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Exportar_Exel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbColuna_Tabela)
                    .addComponent(lbLinha_Tabela)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFiltro1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLinha_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbColuna_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(lb_Exportar_Exel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Impressora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/xls.png"))); // NOI18N
        jLabel7.setToolTipText("IMPORTAR DO EXCEL");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setEnabled(false);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jp_OpcoesLayout = new javax.swing.GroupLayout(jp_Opcoes);
        jp_Opcoes.setLayout(jp_OpcoesLayout);
        jp_OpcoesLayout.setHorizontalGroup(
            jp_OpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_OpcoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jp_OpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jp_OpcoesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_OpcoesLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp_OpcoesLayout.setVerticalGroup(
            jp_OpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_OpcoesLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_OpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_OpcoesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel3});

        javax.swing.GroupLayout jp_Opcoes_TabelaLayout = new javax.swing.GroupLayout(jp_Opcoes_Tabela);
        jp_Opcoes_Tabela.setLayout(jp_Opcoes_TabelaLayout);
        jp_Opcoes_TabelaLayout.setHorizontalGroup(
            jp_Opcoes_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_Opcoes_TabelaLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jp_Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jp_Opcoes_TabelaLayout.setVerticalGroup(
            jp_Opcoes_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_Opcoes_TabelaLayout.createSequentialGroup()
                .addComponent(jp_Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jmary/home/imagens/livroTp.gif"))); // NOI18N
        jButton7.setText("Executar Scripts");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/16_chrome.png"))); // NOI18N
        jLabel10.setText("Obter links do Google");
        jLabel10.setToolTipText("Enviar Endereço de Html da Web Mais mostrar os controles");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jp_Opcoes_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_Opcoes_Tabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PerguntaLayout = new javax.swing.GroupLayout(Pergunta);
        Pergunta.setLayout(PerguntaLayout);
        PerguntaLayout.setHorizontalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerguntaLayout.createSequentialGroup()
                .addGroup(PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PerguntaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PerguntaLayout.setVerticalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerguntaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jTabbedPane1.addTab("Browser Autômato", Pergunta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void abrir_Resposta(String icon){
        try { 
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            JOptionPane pane = new JOptionPane( new ImageIcon( clazzHome.getResource(icon)) );
            final JDialog dialog = pane.createDialog( Home, "" ); 
            dialog.setModal(true);
            Timer timer = new Timer(2 * 1000, new ActionListener() {  
                @Override
                public void actionPerformed(ActionEvent ev) {  
                    dialog.dispose();   
                }  
            });  
            timer.setRepeats(false);  
            timer.start();  
            dialog.show();  
            timer.stop(); 
        } catch( Exception e ){ }
    }
        
    Exportando Exportando;
    private void tbPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPesquisaKeyReleased
        try{

            if ( tbPesquisa.getSelectedRow() != -1){

                if( evt.getKeyCode() == KeyEvent.VK_DELETE )  {

                    int linhaC  = tbPesquisa.getSelectedRow();
                    int colunaC = tbPesquisa.getSelectedColumn();

                    tbPesquisa.setValueAt( "", linhaC, colunaC );
                }
            }
        } catch( Exception e ){}
        
    }//GEN-LAST:event_tbPesquisaKeyReleased
                                            
    private void lb_Exportar_ExelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Exportar_ExelMousePressed
        if( lb_Exportar_Exel.isEnabled() == true ){
        
        new Thread() { @Override public void run() { try{
        
        Object[] options = {
            "EXPORTAR PARA EXCEL",
            "CANCELAR" 
        };
        
        int n = JOptionPane.showOptionDialog(null,
            "Confirme a Exportação.",
            "Opção Exportação",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);        
        if(n==0){ 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
        int numLinhas = -1; try{ numLinhas = tbPesquisa.getRowCount();    } catch( Exception e ){}
        int numColuna = -1; try{ numColuna = tbPesquisa.getColumnCount(); } catch( Exception e ){}
        if ( numLinhas != -1){
            try {         
                Arquivo_Ou_Pasta.criarPasta(System.getProperty("user.dir"), "Arquivos_Exportados");
                Thread.sleep( 1 );
                /////////////////////////////////////////////////////////////////////////////////////
                //String entrada = System.getProperty("user.dir") + "//"+ "Arquivos" + "//" +  
                Class<Usuarios_Do_Sistema_Excel_Modelo> clazz_Entrada_Excel = Usuarios_Do_Sistema_Excel_Modelo.class;
                ////////////////////////////////////////////////////////////////////////////////////
                String saida = System.getProperty("user.dir") + "//"+ "Arquivos_Exportados" + "//" + 
                        "usuarios_do_sistema_excel" + ".xlsx";  
                ///////////////////////////////////////////////////////////////////////////////////
                Arquivo_Ou_Pasta.deletar(new File(saida));
                Thread.sleep( 1 );
                            
                Exportando = new Exportando("EXPORTANDO DADOS...");
                Exportando.setVisible(true);Exportando.pbg.setMinimum(0);
                                                               
                //FileInputStream fileIn = null;
                FileOutputStream fileOut = null;                            
                            
                try{
                                
                    //fileIn = new FileInputStream( entrada );
                    //fileIn = new FileInputStream( clazzHome.getResourceAsStream("usuarios_do_sistema_excel_modelo.xlsx") );
                    //XSSFWorkbook wb = new XSSFWorkbook(fileIn); 
                    XSSFWorkbook wb = new XSSFWorkbook(clazz_Entrada_Excel.getResourceAsStream("usuarios_do_sistema_excel_modelo.xlsx")); 
                    XSSFSheet aba = wb.getSheetAt(0);   
                                
                    Exportando.pbg.setMaximum( numLinhas );
                                                                                    
                    XSSFCell cell;  
                    for (int i = -1; i < numLinhas; i++) { 
                        int linhaParaescrever = i+2;
                        XSSFRow linha = aba.getRow(linhaParaescrever);
                        //XSSFRow linha = aba.createRow(i+1);
                                    
                        for (int j = 0; j < numColuna ; j++) { 
                                        
                            cell = linha.getCell(j); 
                            if (cell == null) cell = linha.createCell(j);
                                        
                                try{ cell.setCellType(XSSFCell.CELL_TYPE_STRING); }catch(Exception e){}
                                try{ cell.setCellValue(XSSFCell.CELL_TYPE_STRING); }catch(Exception e){}
                                        
                                if(i==-1){
                                    cell.setCellValue(String.valueOf(tbPesquisa.getColumnName(j)));
                                }else{
                                            
                                    cell.setCellValue(String.valueOf(tbPesquisa.getValueAt(i, j)));
                                }
                        }
                        
                        Exportando.pbg.setValue( i );                                
                    }
                                                                
                    wb.setForceFormulaRecalculation(true);
                    fileOut = new FileOutputStream( saida );
                    wb.write(fileOut);
                                
                    try{
                        fileOut.close(); 
                        //fileIn.close(); 
                    } catch(Exception e) {}
                                    
                    java.awt.Desktop.getDesktop().open( new File( saida ) ); 
                } catch(Exception e) {}
                                                                    
                Exportando.fechar();                   
            }catch( Exception e ){ e.printStackTrace(); }
        }    
        else{
            
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            //ImageIcon icon = new ImageIcon( clazzHome.getResource( imgURLIcon ) );
                    JOPM JOptionPaneMod = new JOPM( 1, "EXPORTAR PARA EXCEL\n"
                            + "\nSTATUS DA EXPORTAÇÃO:"
                            + "\nPARA EXPORTAR É NECESSÁRIO QUE A TABELA NÃO ESTEJA VAZIA!\n"
                            + "\nOK Para Prosseguir"
                            ,"Class: " + this.getClass().getName(), 
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        }
        }catch( Exception e ){ } } }.start();
        
        }
    }//GEN-LAST:event_lb_Exportar_ExelMousePressed

    private void lb_ImpressoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ImpressoraMousePressed
        if( lb_Impressora.isEnabled() == true ){
        
        new Thread() { @Override public void run() { try{
        
        Object[] options = {
            "IMPRIMIR",
            "CANCELAR" 
        };
        
        int n = JOptionPane.showOptionDialog(null,
            "Confirme a Impressão.",
            "Opção de Imprimir",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);        
        if(n==0){ 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
            Exportando = new Exportando("IMPRIMINDO...");
            Exportando.setVisible(true);Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            Exportando.pbg.setValue( 50 ); 

            Usuarios_Do_Sistema_Imprimir_01_Controle t1 = new Usuarios_Do_Sistema_Imprimir_01_Controle( tbPesquisa );
            t1.setName("ControleThread_Print");
            t1.start();
            
            try{ Thread.sleep( 1000 ); } catch( Exception e ){ }
            Exportando.fechar(); 
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        }catch( Exception e ){ } } }.start();
        
        }
    }//GEN-LAST:event_lb_ImpressoraMousePressed

    private void lbFiltro2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFiltro2MousePressed
        if ( tbPesquisa.getSelectedRow() != -1){

            int c = tbPesquisa.getSelectedColumn();

            String str = String.valueOf( tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), tbPesquisa.getSelectedColumn()) );
            filtroReverso( str, c );
        }
        else{

            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "FILTRO REVERSO TABELA\n"

                + "\nPara filtrar dados da tabela 1º selecione uma célula\n"
                + "\nOK Para Prosseguir"
                ,"Class: " + this.getClass().getName(),
                new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }//GEN-LAST:event_lbFiltro2MousePressed

    private void lbFiltro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFiltro1MousePressed
        if ( tbPesquisa.getSelectedRow() != -1){

            int c = tbPesquisa.getSelectedColumn();

            String str = String.valueOf( tbPesquisa.getValueAt(tbPesquisa.getSelectedRow(), tbPesquisa.getSelectedColumn()) );
            filtro( str, c );
        }
        else{

            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "FILTRA TABELA\n"

                + "\nPara filtrar dados da tabela 1º selecione uma célula\n"
                + "\nOK Para Prosseguir"
                ,"Class: " + this.getClass().getName(),
                new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }//GEN-LAST:event_lbFiltro1MousePressed

    String filtro = "";
    int    coluna = 1;
    public void filtro( String f, int c ) { filtro = f; coluna = c;    
        try { filtro = f.trim(); } catch( Exception e ){}
        
        new Thread() {   @Override public void run() { try { 
            Exportando Exportando = new Exportando("APLICANDO O FILTRO...");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            
            int numFila=tmPesquisa.getRowCount();
            
            Exportando.pbg.setMaximum( numFila );
            
            Thread.sleep( 1 );
                                                
            for (int i = 0; i < numFila; i++) {     Exportando.pbg.setValue( i );
                
                try{
                    
                    String str = String.valueOf( tmPesquisa.getValueAt(i, coluna) ).trim();  
                    
                    if( !str.equals(filtro) ){
                        
                        tmPesquisa.removeRow( i );       
                        i = -1;
                        //System.out.println( str + "  -------------  " + i + "  " + coluna);
                    }
                } catch( Exception e ){ }
                //System.out.println( "++++++++++++++  " + i + "  " + coluna);
            }

            Exportando.fechar();
            
        } catch( Exception e ){ System.out.println("Exportar - "); e.printStackTrace(); } } }.start();  
    }
    
    String filtroReverso = "";
    int    colunaReverso = 1;
    public void filtroReverso( String f, int c ) { colunaReverso = c;    
        try { filtroReverso = f.trim(); } catch( Exception e ){}
        
        new Thread() {   @Override public void run() { try { 
            Exportando Exportando = new Exportando("APLICANDO O FILTRO...");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            
            int numFila=tmPesquisa.getRowCount();
            
            Exportando.pbg.setMaximum( numFila );
            
            Thread.sleep( 1 );
                                                
            for (int i = 0; i < numFila; i++) {     Exportando.pbg.setValue( i );
                
                try{
                    
                    String str = String.valueOf( tmPesquisa.getValueAt(i, colunaReverso) ).trim();  
                    
                    if( str.equals(filtroReverso) ){
                        
                        tmPesquisa.removeRow( i );       
                        i = -1;
                        //System.out.println( str + "  -------------  " + i + "  " + coluna);
                    }
                } catch( Exception e ){ }
                //System.out.println( "++++++++++++++  " + i + "  " + coluna);
            }

            Exportando.fechar();
            
        } catch( InterruptedException e ){ System.out.println("Exportar - "); e.printStackTrace(); } } }.start();  
    }
    
    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            if ( tbPesquisa.getSelectedRow() != -1){
                int coluna = tbPesquisa.getSelectedColumn();
                TableColumn TColuna = tbPesquisa.getColumnModel().getColumn( coluna );
                tbPesquisa.removeColumn( TColuna );
            }
            else{
                
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "EXCLUIR COLUNA DA TABELA\n"
                        + "\nPARA EXCLUIR UMA COLUNA\n"
                        + "\nPRIMEIRO SELECIONE UMA\n"
                        + "\nOK Para Prosseguir"
                        ,"Class: " + this.getClass().getName(),
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            
        } catch( InterruptedException e ){  } } }.start();
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
    if ( tbPesquisa.getSelectedRow() != -1){
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            Exportando = new Exportando("Procurando e Excluindo");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );                            
            ////////////////////////////////////////////////////////////////
            String contentsX = jTextPane1.getText().trim();
            
        if(!contentsX.equals("")){    
                
            StringTokenizer st1=new StringTokenizer(contentsX,"\n");
 
            int contadorElenco;
            for (int i = 0; st1.hasMoreTokens(); i++) {
                contadorElenco = 0;
                                            
                String rowstring = st1.nextToken();
//              //System.out.println( "rowstring - " + rowstring );
                try{                            
                    String[] dados = rowstring.split("\t");                        
                    contadorElenco++;
                    if(contadorElenco < 2){
                        String material_procurado = dados[0].trim(); 
                        Exportando.pbg.setValue( tmPesquisa.getRowCount() );
///////////////////////////////////////////////////////////////////////////////////////////////////////////
                        for( int L_i=0; L_i < tmPesquisa.getRowCount(); L_i++ ){
                            Exportando.pbg.setValue(L_i);
                            
                            for( int C_i=0; C_i < tmPesquisa.getColumnCount(); C_i++ ){ try{
                                String strn = tmPesquisa.getColumnName(C_i);
                                
                                if( strn.trim().equalsIgnoreCase("MATERIAL") ){
                                    String sap = String.valueOf( tmPesquisa.getValueAt(L_i, C_i) ).trim();
                                
                                    if( material_procurado.equals(sap) ){
                                    
                                        tmPesquisa.removeRow( L_i );
                                    }
                                }
                            } catch( Exception e ){  } }    
                        }                     
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                    }                                
                } catch( Exception e ){ e.printStackTrace(); }
                                                
            }   
                
            Exportando.fechar();
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            //ImageIcon icon = new ImageIcon( clazzHome.getResource( imgURLIcon ) );
                JOPM JOptionPaneMod = new JOPM( 1, "EXCLUSÃO DE DADOS\n"
                        + "\nSTATUS DA EXCLUSÃO:"
                        + "\nFINALIZADA COM SUCESSO!\n"
                        + "\nOK Para Prosseguir"
                        ,"Class: " + this.getClass().getName(), 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }     
        else{
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            //ImageIcon icon = new ImageIcon( clazzHome.getResource( imgURLIcon ) );
                JOPM JOptionPaneMod = new JOPM( 1, "EXCLUSÃO DE DADOS\n"
                        + "\nSTATUS DA EXCLUSÃO:"
                        + "\nNÃO HÁ DADOS INFORMADO PARA PROCURA!\n"
                        + "\nOK Para Prosseguir"
                        ,"Class: " + this.getClass().getName(), 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
        } catch( InterruptedException e ){ Exportando.fechar(); } } }.start(); 
    }
    else{
                
        Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
        JOPM JOptionPaneMod = new JOPM( 1, "EXCLUSÃO DE DADOS\n"
                + "\nPARA EXCLUIR DADOS DA TABELA\n"
                + "\nPRIMEIRO INFORME O NÚMERO DOS MATERIAIS\n"
                + "\nOK Para Prosseguir"
                ,"Class: " + this.getClass().getName(),
                new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }//GEN-LAST:event_jLabel9MousePressed

    private void lbLinha_TabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinha_TabelaMousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            if ( tbPesquisa.getSelectedRow() != -1){
                tabelaModoDeSelecao( "Column Selection",true, false, false );
            }
            else{
                
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "ALTERAR MODO DE SELEÇÃO\n"
                        + "\nPARA ALTERAR O MODO DE SELEÇÃO\n"
                        + "\nPRIMEIRO SELECIONE UMA CÉLULA\n"
                        + "\nOK Para Prosseguir"
                        ,"Class: " + this.getClass().getName(),
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            
        } catch( InterruptedException e ){  } } }.start();           
    }//GEN-LAST:event_lbLinha_TabelaMousePressed

    private void lbColuna_TabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbColuna_TabelaMousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            if ( tbPesquisa.getSelectedRow() != -1){
                tabelaModoDeSelecao( "Row Selection",false, true, false );
            }
            else{
                
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "ALTERAR MODO DE SELEÇÃO\n"
                        + "\nPARA ALTERAR O MODO DE SELEÇÃO\n"
                        + "\nPRIMEIRO SELECIONE UMA CÉLULA\n"
                        + "\nOK Para Prosseguir"
                        ,"Class: " + this.getClass().getName(),
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            
        } catch( InterruptedException e ){  } } }.start();   
    }//GEN-LAST:event_lbColuna_TabelaMousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        copiar_Dados_Da_Memoria_Ou_Do_JTextPane(2);
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed

        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            if( jLabel7.isEnabled() == true ) { jLabel7.setEnabled(false);

                JFileChooserJM JFileChooserJM = new JFileChooserJM( "  imagens    -   jmarysystems.blogspot.com.br", new String [] { "XLS" , "XLSX" } );
                String strdevolvida = JFileChooserJM.getString( 2 );

                //tfPesquisa.setText( strdevolvida );

                if( !strdevolvida.equals("") ){
                    
                    ImportarExportarExcel ImportarDadosDoExcel = new ImportarExportarExcel();            
                    ImportarDadosDoExcel.Importar( new File( strdevolvida ), tbPesquisa );
                }
                jLabel7.setEnabled(true);
            }
        } catch( Exception e ){ jLabel7.setEnabled(true); } } }.start();
        /*
        Class<imagens_internas.Imagens_Internas> clazzHome = imagens_internas.Imagens_Internas.class;
                    JOPM JOptionPaneMod = new JOPM( 1, "ACESSO NÃO AUTORIZADO\n"
                            + "\nSTATUS DO ACESSO:"
                            + "\nVOCÊ NÃO TEM ACESSO A ESTA SOLICITAÇÃO!\n"
                            + "\nOK Para Prosseguir"
                            ,"Class: " + this.getClass().getName(), 
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        */                      
    }//GEN-LAST:event_jLabel7MousePressed
       
    
    private URL       imgURL; 
    private ImageIcon icon;            
    private URL       imgURL2;
    private ImageIcon icon2;
    private boolean cimabaixo = true; 
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        try{

            if( cimabaixo == false ){
                cimabaixo = true;
                
                jLabel3.setToolTipText( "Ocultar Submenu" );
                jLabel3.setIcon( icon2 );              
                
                jPanel6.setVisible(true);
            } else if( cimabaixo == true ){
                cimabaixo = false;
                                
                jLabel3.setToolTipText( "Mostrar Submenu" );
                jLabel3.setIcon( icon );  
                
                jPanel6.setVisible(false);
            }
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabJanelaSubmenu, \n"
                + e.getMessage() + "\n", "Alterar_Seta_Submenu" ); }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
            
        String tipo_comboBox  = ""; try{ tipo_comboBox = jComboBox4.getSelectedItem().toString().trim(); } catch( Exception e ){}

        adicionar_automato();
        
    }catch( HeadlessException | InterruptedException e ){
        
        e.printStackTrace();
        JOPM JOptionPaneMod = new JOPM( 2, "CADASTRAR AUTÔMATO, "
                + "\nERRO AO CADASTRAR AUTÔMATO"
                + "\nMENSAGEM: " + e.getMessage()
                + "\nNÃO CADASTRADO"
                + "\n", "CADASTRAR AUTÔMATO" );    
    } } }.start();  
    }//GEN-LAST:event_jButton6MousePressed

    private void adicionar_automato() {                                      
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
        Exportando = new Exportando("ABRINDO");
        Exportando.setVisible(true);
        Exportando.pbg.setMinimum(0); 
        Exportando.pbg.setMaximum( 100 );
        Exportando.pbg.setValue( 50 );
            
        String tipo_comboBox  = "";
        String tempo = "";
        String acao  = "";
        
        try{ tipo_comboBox = jComboBox4.getSelectedItem().toString().trim(); } catch( Exception e ){}
        try{ tempo = tf_Tempo.getText().trim(); } catch( Exception e ){}
        try{ 
            String str_TextPane = jTextPane1.getText().trim();

            acao = str_TextPane;
        } catch( Exception e ){}
        
        tmPesquisa.addRow(new Object[]{ tipo_comboBox, tempo, acao }); 
        
        Exportando.fechar();
    }catch( HeadlessException | InterruptedException e ){
        Exportando.fechar();
        
        e.printStackTrace();
        JOPM JOptionPaneMod = new JOPM( 2, "CADASTRAR AUTÔMATO, "
                + "\nERRO AO CADASTRAR AUTÔMATO"
                + "\nMENSAGEM: " + e.getMessage()
                + "\nNÃO CADASTRADO"
                + "\n", "CADASTRAR AUTÔMATO" );    
    } } }.start();  
    }
    
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void JPOpcao_26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseEntered

    private void JPOpcao_26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseExited

    private void JPOpcao_26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MousePressed

    private void tf_TempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_TempoMouseClicked
        try{
            //PopupMenu_Colar = new PopupMenu_Colar(tf_Endereco);
        } catch( Exception e ){}
    }//GEN-LAST:event_tf_TempoMouseClicked

    private void tf_TempoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_TempoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TempoMouseEntered

    private void tf_TempoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_TempoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TempoMouseExited

    private void tf_TempoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_TempoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TempoKeyReleased

    private void JPOpcao_27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseEntered

    private void JPOpcao_27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseExited

    private void JPOpcao_27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MousePressed

    List<String[]> elements = new ArrayList<String[]>();
    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        try{
            
            for (int i = 0; i < tbPesquisa.getModel().getRowCount(); i++){
                Object obj0 = tbPesquisa.getModel().getValueAt(i, 0);
                Object obj1 = tbPesquisa.getModel().getValueAt(i, 1);
                Object obj2 = tbPesquisa.getModel().getValueAt(i, 2);
                
                String str_obj0 = String.valueOf( obj0 );
                String str_obj1 = String.valueOf( obj1 );
                String str_obj2 = String.valueOf( obj2 );
                
                String[] strArray = new String[]{ str_obj0, str_obj1, str_obj2 };

                elements.add( strArray );
            }
            
            /*
            for (int i = 0; i < elements.size(); i++){
                
                String[] strArray = elements.get(i);
                System.out.println( strArray[0] );
                System.out.println( strArray[1] );
                System.out.println( strArray[2] );
            }
            */
            
            Browser_Automato_Submenu_01.iniciarT( elements );

        } catch( Exception e ){ e.printStackTrace(); }
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
        setar_DefaultTableModel_tmPesquisa(1);
    }//GEN-LAST:event_jButton8MousePressed

    private void google(){ try {        
        Platform.runLater(new Runnable() {
           @Override
            public void run() {
                try{           
                    String html = (String) Browser_Automato_Submenu_01.BrowserFXT.eng.executeScript("document.documentElement.outerHTML");                    
                    String html_new = html.replace( ">", ">\n" );
                    //System.out.println(html_new);
                    
                    Google_Obter_Links Google = new Google_Obter_Links( Browser_Automato_Submenu_01, html_new );
                    
                }catch( Exception e ){ System.out.println( "codigo_fonte - " ); e.printStackTrace(); }  
            }
        });
    } catch( Exception e ){} }
    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        google();
    }//GEN-LAST:event_jLabel10MousePressed
            
    private void setarUrl_e_ImageIcon_Seta_Inicio(){
        try{                       
            
            imgURL  = Imagens_Menu_Norte.class.getResource("seta_para_baixo.png");
            icon    = new ImageIcon( imgURL );  
            
            imgURL2  = Imagens_Menu_Norte.class.getResource("seta_para_cima.png");
            icon2   = new ImageIcon( imgURL2 ); 
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "setarUrl_e_ImageIcon(), \n"
                + e.getMessage() + "\n", "Alterar_Seta_Submenu" ); }
    }
            
    private void tabelaInicio(){
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            tbPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lsmPesquisa = tbPesquisa.getSelectionModel();
            
            tbPesquisa.setAutoCreateRowSorter(true);

            tabelaModoDeSelecao( "Multiple Interval Selection", false, false, false );
            
            setar_DefaultTableModel_tbPreferedSize(1); 
            
            //ExcelAdapter myAd = new ExcelAdapter(tbPesquisa);
            
        } catch( InterruptedException e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabelaInicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();              
    }
    
    public void tabelaModoDeSelecao( String command, boolean linhaCheck, boolean colunaCheck, boolean selecionar_celula ) {
        
        if ("Row Selection".equals(command)) {
            tbPesquisa.setRowSelectionAllowed(linhaCheck);
            //In MIS mode, column selection allowed must be the
            //opposite of row selection allowed.
            if (!selecionar_celula) {
                tbPesquisa.setColumnSelectionAllowed(!linhaCheck);
            }
        } else if ("Column Selection".equals(command)) {
            tbPesquisa.setColumnSelectionAllowed(colunaCheck);
            //In MIS mode, row selection allowed must be the
            //opposite of column selection allowed.
            if (!selecionar_celula) {
                tbPesquisa.setRowSelectionAllowed(!colunaCheck);
            }

        } else if ("Cell Selection".equals(command)) {
            
            tbPesquisa.setCellSelectionEnabled(selecionar_celula);
        } else if ("Multiple Interval Selection".equals(command)) { 
            tbPesquisa.setSelectionMode(
                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            //If cell selection is on, turn it off.
            if (selecionar_celula) {
                selecionar_celula = false;
                tbPesquisa.setCellSelectionEnabled(false);
            }
            //And don't let it be turned back on.
            selecionar_celula = false;
        } else if ("Single Interval Selection".equals(command)) {
            tbPesquisa.setSelectionMode(
                    ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            //Cell selection is ok in this mode.
            selecionar_celula = true;
        } else if ("Single Selection".equals(command)) { 
            tbPesquisa.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION);
            //Cell selection is ok in this mode.
            selecionar_celula = true;
            ////////////////////////////////////////////////////////////////////
            lsmPesquisa.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if ( !e.getValueIsAdjusting() ){
                        tbPesquisaLinhaSelecionada();
                        //calculoFlutuante();
                    }
                }
                
                /*public void focosLost(ListSelectionEvent e) {
                    if ( !e.getValueIsAdjusting() ){
                        calculoFlutuante();
                    }
                }*/
            });
            
            
        }
    }
                            
    String controltbPesquisaLinhaSelecionada = "";
    private void tbPesquisaLinhaSelecionada() { 
        try{
            
            if ( tbPesquisa.getSelectedRow() != -1){
                
                try{
                    
                    if( controltbPesquisaLinhaSelecionada.equals("mostrarListaEventoprodutos") ){
                    
                        /*
                        Menu_Pesquisa.btExcluirEventoGB.setVisible(false);
                        Menu_Pesquisa.IDSELECIONADA = listEventoprodutos.get( tbPesquisa.getSelectedRow() ).getId();
                        */
                    }
                    else{
                        /*          
                        Menu_Pesquisa.btExcluirEventoGB.setVisible(false);
                        Menu_Pesquisa.IDSELECIONADA = list.get( tbPesquisa.getSelectedRow() ).getId();
                        */
                    }
                }catch( Exception e ){}
                 
                /*
                Menu_Pesquisa.btVisualizar.setEnabled(true);
                Menu_Pesquisa.btSelecionar.setEnabled(true);               
                
                if( Administrador.mapaComandos.get("ALTERAR_ESTABELECIMENTO") != null ) {
                    Menu_Pesquisa.btAlterar.setEnabled(true);
                }  
                
                if( Administrador.mapaComandos.get("EXCLUIR_ESTABELECIMENTO") != null ) {
                    Menu_Pesquisa.btExcluir    .setEnabled(true);
                }   
                
                Menu_Pesquisa.btExcluirEventoGB.setEnabled(true);   
                Menu_Pesquisa.btExcluirEventoGB.setVisible(true);  
                
                Menu_Pesquisa.lbFiltro.setVisible(true); 
                
                Menu_Pesquisa.lbExcluir.setVisible(true); 
                */

            } else{
                    
                /*
                Menu_Pesquisa.IDSELECIONADA = -1;  
                
                Menu_Pesquisa.btAlterar   .setEnabled(false);
                Menu_Pesquisa.btExcluir   .setEnabled(false);
                Menu_Pesquisa.btVisualizar.setEnabled(false);
                Menu_Pesquisa.btSelecionar.setEnabled(false);
                
                Menu_Pesquisa.btExcluirEventoGB.setEnabled(false);   
                Menu_Pesquisa.btExcluirEventoGB.setVisible(false);
                
                Menu_Pesquisa.lbFiltro.setVisible(false); 
                
                Menu_Pesquisa.lbExcluir.setVisible(false); 
                */
            }
        } catch( Exception e ) {}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPOpcao_26;
    private javax.swing.JPanel JPOpcao_27;
    private javax.swing.JPanel Pergunta;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel jp_Opcoes;
    private javax.swing.JPanel jp_Opcoes_Tabela;
    private javax.swing.JLabel lbColuna_Tabela;
    public javax.swing.JLabel lbFiltro1;
    public javax.swing.JLabel lbFiltro2;
    private javax.swing.JLabel lbLinha_Tabela;
    private javax.swing.JLabel lb_Exportar_Exel;
    private javax.swing.JLabel lb_Impressora;
    public javax.swing.JTable tbPesquisa;
    public javax.swing.JTextField tf_Tempo;
    // End of variables declaration//GEN-END:variables
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private void setar_DefaultTableModel_tmPesquisa(int opcao){  
        try{
            
            switch(opcao){
                
                case 1:
                    while ( tmPesquisa.getRowCount() > 0){ tmPesquisa.removeRow(0); } 
                    tmPesquisa = new DefaultTableModel( null, new String[]{ 
                        "TIPO", "TEMPO", "AÇÃO" } );
                    tbPesquisa.setModel(tmPesquisa);
                break;    
                
            }            
        } catch( Exception e ){ e.printStackTrace(); }
    }
    
    private void setar_DefaultTableModel_tbPreferedSize(int opcao){ 
        try{
            
            switch(opcao){
                
                case 1:
                    DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
                    rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
                    
                    DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
                    rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    int count = 0;
                    
                    tbPesquisa.getColumnModel().getColumn(count).setPreferredWidth(80);
                    tbPesquisa.getColumnModel().getColumn(count).setResizable(true);
                    tbPesquisa.getColumnModel().getColumn(count).setCellRenderer( rendererCentro );
                    count++;
                    
                    tbPesquisa.getColumnModel().getColumn(count).setPreferredWidth(100);
                    tbPesquisa.getColumnModel().getColumn(count).setResizable(true);
                    tbPesquisa.getColumnModel().getColumn(count).setCellRenderer( rendererCentro );
                    count++;
                    
                    tbPesquisa.getColumnModel().getColumn(count).setPreferredWidth(600);
                    tbPesquisa.getColumnModel().getColumn(count).setResizable(true);
                    //tbPesquisa.getColumnModel().getColumn(count).setCellRenderer( rendererCentro );
                    count++;
            
                    
                    tbPesquisa.setRowHeight(30);
                    tbPesquisa.setSelectionBackground(Color.YELLOW);
                    tbPesquisa.setSelectionForeground(Color.BLUE);

                    tbPesquisa.getTableHeader().setReorderingAllowed(true);
                    //tbPesquisa.getTableHeader().setResizingAllowed(true);            
                    tbPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                break;    
                
            }            
        } catch( Exception e ){ e.printStackTrace(); }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void consultaSqlPorSap(){
                      
        new Thread() {   @Override public void run() { try {  
            /*
            String tabela = "";
            try{ tabela = jComboBox1.getSelectedItem().toString().trim(); } catch( Exception e ){}
        
            if( !tabela.equals( "" ) ){
                
                String query = "SELECT * FROM JM."+tabela+"";
                                               
                String str[] = jTextPane1.getText().split("\n");
                
                String colunaParaProcurar = jTextField2.getText().trim();
            
                tabelaResultSetComListSap(query, tabela, colunaParaProcurar, str);
            }
           */
        } catch( Exception e ){ e.printStackTrace(); } } }.start();               
    }
    
    public void tabelaResultSetComListSap( String query, String tabela, String colunaParaProcurar, String str[]  ){ try {   
        while ( tmPesquisa.getRowCount() > 0){ tmPesquisa.removeRow(0); }                   
        DB DB = new DB();
        Connection con = null; try{ con = DB.derby();             }catch(Exception e){}    
        Statement stmt = null; try{ stmt = con.createStatement(); }catch(Exception e){}        
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsMetaData = rs.getMetaData(); 

        int columnCount = rsMetaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        
        int colunaProcurada = -1;
        
        int contador = 0;
        for (int i = 0; i < columnCount; i++) {
            contador = 1 + i;
            columnNames [i] = rsMetaData.getColumnName(contador);
            
            //////////////////////////
            String sapPROC = ""; try{ sapPROC = rsMetaData.getColumnName(contador); } catch(Exception e){}
            if( sapPROC.equals(colunaParaProcurar) ){
                
                colunaProcurada = i;
            }
        }
            
        tmPesquisa = new DefaultTableModel( null, columnNames );
        tbPesquisa.setModel(tmPesquisa);
        
        if( !str.equals("") ){ for (int xi = 0; xi < str.length; xi++){
            String busca = ""; try{ busca = str[xi].trim(); }catch( Exception e ){ }
            
            boolean novaLinhaBusca = false;
            
            rs = null;
            
            try{
                String queryX = "SELECT * FROM JM."+tabela+" WHERE "+ colunaParaProcurar +" = '"+busca+"'";
                DB = new DB();
                con = null; try{ con = DB.derby();             }catch(Exception e){}    
                stmt = null; try{ stmt = con.createStatement(); }catch(Exception e){}        
                rs = stmt.executeQuery(queryX);
            }catch( Exception e ){ }
                                        
            while (rs.next()) { 
                
                novaLinhaBusca = true;
                        
                boolean buscaEncontrada = false;
                //System.out.println("SAP Procurado: " +busca);
                                    
                String[] dados = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    contador = 1 + i;
                    dados [i] = ( rs.getString(contador) );
                
                    ////////////////////////////////
                    if( i == colunaProcurada ){
                    
                        if( rs.getString(contador).equals(busca) ){
                            
                            buscaEncontrada = true;
                        }
                    }
                }
            
                if( buscaEncontrada == true ){
                    tmPesquisa.addRow( dados ); 
                }
            }  
                
            if( novaLinhaBusca == false ){
               String[] dados = new String[columnCount];
               dados [colunaProcurada] = busca;
               
               tmPesquisa.addRow( dados ); 
               //System.out.println("rs != null: ");
            } 

        }}
        
        setar_DefaultTableModel_tbPreferedSize(1);
        
        Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
        //ImageIcon icon = new ImageIcon( clazzHome.getResource( imgURLIcon ) );
        JOPM JOptionPaneMod = new JOPM( 1, "CONSULTA SQL\n"
                + "\nSTATUS DA CONSULTA:"
                + "\nCONSULTA FINALIZADA COM SUCESSO!\n"
                + "\nOK Para Prosseguir"
                ,"Class: " + this.getClass().getName(), 
                new ImageIcon( clazzHome.getResource("logocangaco2.png")) );

    } catch( SQLException e ){ JOPM JOptionPaneMod = new JOPM( 2, "CONSULTA SQL, \n" + "\n", e.getMessage() ); } }   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    int opcao_copiar_Dados_Da_Memoria = 0;
    private void copiar_Dados_Da_Memoria_Ou_Do_JTextPane(int opcao_copiar_Dados_Da_Memoria2){  
        
        opcao_copiar_Dados_Da_Memoria = opcao_copiar_Dados_Da_Memoria2;
        
    new Thread() {   @Override public void run() { try {  
        
        int opcao = opcao_copiar_Dados_Da_Memoria;
          
        try {                                                
            int response = JOptionPane.showConfirmDialog(null, ""
                + "**CONFIRMAR LISTAGEM DOS DADOS**"
                + "\n"
                + "E PESQUISAR?");
              
            if( response == JOptionPane.YES_OPTION){
                
                Exportando = new Exportando("Listando Dados");
                Exportando.setVisible(true);
                Exportando.pbg.setMinimum(0);
                Exportando.pbg.setMaximum( 100 );
                Exportando.pbg.setValue( 50 );
                                
                ////////////////////////////////////////////////////////////////
                setar_DefaultTableModel_tmPesquisa(1);
                setar_DefaultTableModel_tbPreferedSize(1);
                
                String contentsX = "";                
                switch(opcao){
                    
                    case 1:
                        contentsX = jTextPane1.getText().trim(); 
                    break;
                    
                    case 2:
                
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        Transferable contents = clipboard.getContents(null);
                        boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
                        if ( hasTransferableText ) {
                            try { 
                                contentsX = (String)contents.getTransferData(DataFlavor.stringFlavor);
                            }catch (Exception e){}
                        }   
                    break;
                }
                
                /////////////////////////////////////////////////////////////// 
                /*
                StringTokenizer stX=new StringTokenizer(contentsX,"\n");                
                
                int countColuna = 0;
                for( int i=0; stX.hasMoreTokens(); i++ ){               
                                        
                    String rowstring = stX.nextToken();
                    StringTokenizer st2 = new StringTokenizer(rowstring,"\t");
                    for( int j=0; st2.hasMoreTokens(); j++ ){
                        
                        if( i > 0 ){ break; }
                        
                        countColuna += 1;
                        String cellstring = st2.nextToken();
                    }                                                                                                    
                }
                */ 
                ////////////////////////////////////////////////////////////////
                
                StringTokenizer st1=new StringTokenizer(contentsX,"\n");
 
                for (int i = 0; st1.hasMoreTokens(); i++) {
                                            
                    String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){} 
//                  //System.out.println( "rowstring - " + rowstring );
                    try{
                            
                        String[] dados = null; try{ dados = rowstring.split("\t"); }catch( Exception e ){}
                            String material_procurado = ""; try{ material_procurado = dados[0].trim(); }catch( Exception e ){}    
                /////////////////////////////////////////////////
                        String id  = "";                         try{ id                          = dados[0].trim(); }catch( Exception e ){} 
                        String codigoaux = "";                   try{ codigoaux                   = dados[1].trim(); }catch( Exception e ){}
                        String nome = "";                        try{ nome                        = dados[2].trim(); }catch( Exception e ){}
                        String senha = "";                       try{ senha                       = dados[3].trim(); }catch( Exception e ){}
                        String email = "";                       try{ email                       = dados[4].trim(); }catch( Exception e ){} 
                        String acesso_ao_sistema = "";           try{ acesso_ao_sistema           = dados[5].trim(); }catch( Exception e ){}                          
                        String data_cadastro = "";               try{ data_cadastro               = dados[6].trim(); }catch( Exception e ){} 
                        String data_ultima_alteracao = "";       try{ data_ultima_alteracao       = dados[7].trim(); }catch( Exception e ){} 
                        String data_ultima_alteracao_senha = ""; try{ data_ultima_alteracao_senha = dados[8].trim(); }catch( Exception e ){}
                        String id_usuario_que_cadastrou = "";    try{ id_usuario_que_cadastrou    = dados[9].trim(); }catch( Exception e ){}
                        String id_usuario_que_alterou = "";      try{ id_usuario_que_alterou      = dados[10].trim(); }catch( Exception e ){}
                /////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
                            /*
                            int    id   = 0; 
                            String nome = "";
                            String senha = "";                      
                            String email = "";
                            String acesso_ao_sistema = "";                            
                            String data_cadastro = "";
                            String data_ultima_alteracao = "";
                            String data_ultima_alteracao_senha = "";
                            String id_usuario_que_cadastrou = "";    
                            String id_usuario_que_alterou = "";
                            try {
                                List<UsuarioSistema> UsuarioSistema = null;
                                try{ 
                                    Query q = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE ID = '"+material_procurado+"'", UsuarioSistema.class );
                                    UsuarioSistema = q.getResultList();
                                }catch( Exception e ){ }
                                
                                String rbusca = ""; try{ rbusca = String.valueOf( UsuarioSistema.get(0).getId() ); }catch( Exception e ){}
                                
                                if( !rbusca.equals("") ){
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    
                                    try{ id                            = UsuarioSistema.get(0).getId();                                           }catch( Exception e ){}
                                    try{ nome                          = UsuarioSistema.get(0).getNome();                                         }catch( Exception e ){}
                                    try{ senha                         = UsuarioSistema.get(0).getSenha();                                        }catch( Exception e ){}
                                    try{ email                         = UsuarioSistema.get(0).getEmailRecuperacao();                             }catch( Exception e ){}
                                    try{ acesso_ao_sistema             = UsuarioSistema.get(0).getPermitirAcessoAoSistema();                      }catch( Exception e ){}                                    
                                    try{ data_cadastro                 = formatter.format( UsuarioSistema.get(0).getDataCadastro() );             }catch( Exception e ){}                                    
                                    try{ data_ultima_alteracao         = formatter.format( UsuarioSistema.get(0).getDataUltimaAlteracaoSenha());  }catch( Exception e ){}
                                    try{ data_ultima_alteracao_senha   = formatter.format( UsuarioSistema.get(0).getDataUltimaAlteracaoSenha());  }catch( Exception e ){}
                                    try{ id_usuario_que_cadastrou      = UsuarioSistema.get(0).getIdUsuarioSistemaCadastro(); }catch( Exception e ){}
                                    try{ id_usuario_que_alterou        = UsuarioSistema.get(0).getIdUsuarioSistemaAlteracao(); }catch( Exception e ){}
                                }
                            }catch( Exception e ){}
                            */
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                            tmPesquisa.addRow(new Object[]{ id, codigoaux, nome, senha, email, acesso_ao_sistema, data_cadastro, data_ultima_alteracao, data_ultima_alteracao_senha, id_usuario_que_cadastrou, id_usuario_que_alterou });                              
                    } catch( Exception e ){ e.printStackTrace(); }
                                                
                }   
                
                Exportando.fechar();
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                    JOPM JOptionPaneMod = new JOPM( 1, "CONSULTA O ELENCO\n"
                            + "\nSTATUS DA CONSULTA:"
                            + "\nCONSULTA FINALIZADA COM SUCESSO!\n"
                            + "\nOK Para Prosseguir"
                            ,"Class: " + this.getClass().getName(), 
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
        } catch( Exception e ){ Exportando.fechar(); } //} }.start();        
    } catch( Exception e ){ } } }.start();  
    } 
    
            
}