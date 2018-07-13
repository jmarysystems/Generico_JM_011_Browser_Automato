/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package browser_automato;

import br.com.jmary.utilidades.JOPM;
import browser_automato_menu_e_submenu.Browser_Automato_Submenu_01;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author pc
 */
public class Email_Enviar {
         
    //Email_Home.list_cmd.get(0)  --  E-mail do destinatário 
    //Email_Home.list_cmd.get(1)  --  Senha do Remetente
    //Email_Home.list_cmd.get(2)  --  E-mail do Remetente 
    //Email_Home.list_cmd.get(3)  --  Usuário do E-mail 
    public List<String> list_cmd;
    public List<File>   fileMailsRecebido;
    String ip;
    Browser_Automato_Submenu_01 Leitor_De_Email_Submenu_01;
    
    public Email_Enviar( List<String> list_cmd2, List<File> fileMails2, String ip2, Browser_Automato_Submenu_01 Leitor_De_Email_Submenu_012 ) {

        list_cmd = list_cmd2;
        fileMailsRecebido = fileMails2;
        ip = ip2;
        Leitor_De_Email_Submenu_01 = Leitor_De_Email_Submenu_012;
           
        System.out.println("public Email_Enviar( List<String> list_cmd2, List<File> fileMails2, String ip2 )");
        inicio();
    }
    
    private void inicio(){
        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
        
            System.out.println("inicio()");
            iniciar();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Materias_Home_Inicio" ); } //} }.start(); 
                
    }
    
    //Verificar Lista de Comandos
    private void iniciar(){
        
        if( !list_cmd.isEmpty() ) {
            
            System.out.println("iniciar()");
            verificar_o_email_a_ser_enviado();
                                        
        }
        else{
            
            //Nenhum Comando Recebido
            JOPM JOPM = new JOPM( "MÉTODO: " + "iniciar()\n"
                ,"\nLista de Comandos referentes a impressão está vazia!" 
                ,this.getClass().getName()
            ); 
        }
    }  
    
    //cmd_0 = Endereço local do Arquivo a ser impresso
    public void verificar_o_email_a_ser_enviado(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            String cmd_0 = list_cmd.get(0); 
            
            if( !cmd_0.trim().equals("") ) {
                       
                System.out.println("verificar_o_email_a_ser_enviado()");
                verificar_a_senha_do_email();
            }
            else{
            
                //Nenhum Comando Recebido
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_o_email_a_ser_enviado()\n"
                    ,"\nO E-mail do destinatário está vazio!" 
                    ,this.getClass().getName()
                ); 
            }
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_o_email_a_ser_enviado()\n"
                    ,"\nErro ao tentar ler o E-mail do destinatário - cmd_0" 
                    ,this.getClass().getName() ); 
        } //} }.start();                   
    }
    
    //cmd_1 = Verificar o nome da impressora a ser impresso o documento
    public void verificar_a_senha_do_email(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            String cmd_1 = list_cmd.get(1); 
            
            if( !cmd_1.trim().equals("") ) {
                   
                System.out.println("verificar_a_senha_do_email()");
                mailJava();
            }
            else{
            
                //Nenhum nome de impressora Recebido
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_a_senha_do_email()\n"
                    ,"\nA Senha do E-mail do remetente está vazio!" 
                    ,this.getClass().getName()
                ); 
            }
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_a_senha_do_email()\n"
                    ,"\nErro ao tentar ler a senha do E-mail do remetente - cmd_1" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    //indica se o formato de texto será texto ou html
    public String TYPE_TEXT_PLAIN = "text/plain";
    public String TYPE_TEXT_HTML = "text/html";
    
    //indica qual será o servidor de email(gmail, hotmail...)        
    public String smtpHostMail;
    //indica a porta de acesso ao servidor
    public String smtpPortMail;
    //indica que a necessidade de autenticação no servidor(true ou false)
    public String smtpAuth;
    //indica ao servidor que ele está recebendo uma conexão segura
    public String smtpStarttls;
    //nome do remetente do email
    public String fromNameMail;
    //email do remetente
    public String userMail;
    //senha do email do remetente
    public String passMail;
    //assunto do email
    public String subjectMail;
    //corpo do email, onde estará o texto da mensagem
    public String bodyMail;
    //lista com email e nome dos destinatários
    public Map<String, String> toMailsUsers;
    //lista contendo os arquivos anexos
    public List<File> fileMails;
    //charset, no caso de html é necessário
    public String charsetMail;
    //tipo do formato da mensagem, texto ou html
    public String typeTextMail;
    public void mailJava(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
            /*Configuração de servidores * 
             Servidor       smtpHostMail       smtpPortMail    smtpStarttls
                Gmail      smtp.gmail.com	  587	         true
                Bol        smtps.bol.com.br	  587	         true
                Ibest	   smtp.ibest.com.br	  587	         true
                IG	   smtp.ig.com.br	  587	         true
                Hotmail    smtp.live.com	  25	         true
            **/
           
             smtpHostMail = "smtp.gmail.com";
             smtpPortMail = "587";
             smtpAuth     = "true";
             smtpStarttls = "true";
             fromNameMail = list_cmd.get(3);     //Usuário do E-mail //"subzero3463.01"
             userMail     = list_cmd.get(2);                //E-mail //"subzero3463.01@gmail.com"
             passMail     = list_cmd.get(1);                 //Senha //"subzero3463"
             subjectMail  = list_cmd.get(4);                         //Assunto do E-mail
             subjectMail = ip;
             bodyMail     = htmlMessage();
             
             toMailsUsers = new HashMap<String, String>();
             toMailsUsers.put( list_cmd.get(0), "email gmail" ); //Email_Home.list_cmd.get(0)  --  "jmarysystems@gmail.com"
             
/********************************************/
             toMailsUsers.put( list_cmd.get(0) , "FF" );

/********************************************/
             
             fileMails    = fileMailsRecebido; 
             
             charsetMail  = "ISO-8859-1"; 
             typeTextMail = TYPE_TEXT_HTML;
            
             System.out.println("mailJava()");
             autenticar();
             
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "mailJava()\n"
                    ,"\nErro ao tentar setar dados da lista de comandos" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    private String htmlMessage() {
        GregorianCalendar gc = new GregorianCalendar();

        return 
       "<html>\n" +
       "\t<head>\n" +
       "\t\t<title>" + "Cleilson Henrique de Araujo" + "</title> \n" +
       "\t</head>\n" +
       "\t<body>\n" +              
           
       "<hr>" +         
       "<table align='center' width='100%' border='0' cellpadding='0' cellspacing='0' > " +
                
            "<tr>" +   
                "<td style='vertical-align: central;'>" 
                    + "<div style=\"font-size:18.8px\"><span style=\"font-size:18.8px\">"
                            
                        + "<div style=\"font-size:12.8px\"><span style=\"font-size:12.8px\"><br></span></div>"
                        + "<div style=\"font-size:12.8px\"><span style=\"font-size:12.8px\"><br></span></div>"
                    + "</span>" + "</div>"
                +"</td>" +
            "</tr>" + 
                
            "<tr>" +   
                "<td style='vertical-align: central;'>" 
                    + "<div style=\"font-size:18.8px\"><span style=\"font-size:18.8px\">"
                
                            + "Cleilson Henrique de Araujo"
                
                        + "</span>" + "</div>"
                    + "<div style=\"font-size:12.8px\"><span style=\"font-size:12.8px\"><br></span></div>"
                +"</td>" +
            "</tr>" +         
                
            "<tr>" +   
                "<td style='vertical-align: central;'>" 
                    +"<div style=\"font-size:12.8px\"><h1 style=\"line-height:28.8px;margin-bottom:1px;border-top:1px solid rgb(238,238,238);background:none 0% 0% repeat scroll rgb(248,248,248);padding:10px\">"
                        
                        + "<font color=\"#424242\" face=\"Arial, Georgia, serif\" size=\"5\">"               
                            
                        + "</font>"
                
                        + "<font face=\"Arial, Georgia, serif\" color=\"#424242\" style=\"font-size:12.8px\"><br></font></h1>"
                        + "<div style=\"font-size:12.8px\"><span style=\"font-size:12.8px\"><br></span></div>"
                        + "<div style=\"font-size:12.8px\"><span style=\"font-size:12.8px\"><br></span></div>"
                
                        + "<div style=\"font-size:18.8px\"><span style=\"font-size:18.8px\">"
                            + "Cleilson Henrique de Araujo"
                        + "</span>" + "</div>"
                
                    + "</div>"
                +"</td>" +
            "</tr>" +  
  
       "</table>" +         
                              
                
       "\t</body> \n" +
       "</html>";
    }
    
    public Authenticator auth;
    public void autenticar(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            //classe anonima que realiza a autenticação
            //do usuario no servidor de email.
            auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                                   userMail, passMail                                                                                                                                                                                                                      
                 );
            } };
            
            System.out.println("autenticar()");
            proprerties();
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "autenticar()\n"
                    ,"\nErro ao tentar setar a autenticação" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    Properties props;
    public void proprerties(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            props = new Properties();
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //yes
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.mime.charset", "ISO-8859-1");
            
            props.setProperty("mail.smtp.socketFactory.port", "587");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            
            ////////////////////////////////////////////////////////
            props.setProperty("mail.imap.ssl.trust", "imap.gmail.com"); //yes            
            props.setProperty("mail.imap.host", "imap.gmail.com");
            props.setProperty("mail.imap.auth", "true");
            props.setProperty("mail.imap.starttls.enable","true");
            props.setProperty("mail.imap.port", "993");            
            props.setProperty("mail.imap.socketFactory.class",  "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.imap.socketFactory.fallback", "false");
            props.setProperty("mail.store.protocol", "imaps");
            
            //props.setProperty("mail.transport.protocol", "imap");
            props.setProperty("mail.mime.charset", "ISO-8859-1");
            ////////////////////////////////////////////////////////
            
            System.out.println("proprerties");
            sessao();
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "proprerties()\n"
                    ,"\nErro ao tentar setar as propriedades" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    Session session;
    public void sessao(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            // Cria a sessao passando as propriedades e a autenticação
            session = Session.getDefaultInstance(props, auth);
            session.setDebug(true);
            
            System.out.println("sessao");
            criar_mensagem_e_setar_remetentes();
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "sessao()\n"
                    ,"\nErro ao tentar setar a sessão" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    Message msg;
    public void criar_mensagem_e_setar_remetentes(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 
           
            //cria a mensagem setando o remetente e seus destinatários
            msg = new MimeMessage(session);
            //aqui seta o remetente
            msg.setFrom(new InternetAddress(userMail, fromNameMail));
            
            boolean first = true;            
            for (Map.Entry<String, String> map : toMailsUsers.entrySet()) {
                if (first) {
                    //setamos o 1° destinatario
                    msg.addRecipient(Message.RecipientType.TO,
                              new InternetAddress(map.getKey(), map.getValue())
                     );
                    first = false;
                } else {
                    //setamos os demais destinatarios
                    msg.addRecipient(Message.RecipientType.CC,
                              new InternetAddress(map.getKey(), map.getValue())
                     );
                }
        
            }
            
            msg.getReceivedDate();
            // Adiciona um Assunto a Mensagem
            msg.setSubject(subjectMail);
            
            msg.setText("blabla");
                        
            // Cria o objeto que recebe o texto do corpo do email
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(bodyMail, typeTextMail);
            // Monta a mensagem SMTP  inserindo o conteudo, texto e anexos
            
            Multipart mps = new MimeMultipart();
            /*for (int index = 0; index < fileMails.size(); index++) {
                // Cria um novo objeto para cada arquivo, e anexa o arquivo
                MimeBodyPart attachFilePart = new MimeBodyPart();
                FileDataSource fds =   new FileDataSource(
                    fileMails.get(index)
                );
                attachFilePart.setDataHandler(new DataHandler(fds));
                attachFilePart.setFileName(fds.getName());
                //adiciona os anexos da mensagem
                mps.addBodyPart(attachFilePart, index);
            }                                
            */
            
            //adiciona o corpo texto da mensagem
            mps.addBodyPart(textPart);
            //adiciona a mensagem o conteúdo texto e anexo
            msg.setContent(mps);
            
            System.out.println("criar_mensagem_e_setar_remetentes");
            enviar_mensagem();
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: " + "criar_mensagem_e_setar_remetentes()\n"
                    ,"\nErro ao tentar criar_mensagem_e_setar_remetentes" 
                    ,this.getClass().getName() ); 
        } //} }.start();                 
    }
    
    public void enviar_mensagem(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 ); 

            System.out.println( "\n" );
            System.out.println("enviar_mensagem");
            apagando_todas_as_mensagens();
            System.out.println( "\n" );
        
            Transport.send(msg);
            
            //Leitor_De_Email_Submenu_01.enviar_ip();
            
        } catch( Exception e ){ 
            
            JOPM JOPM = new JOPM( "MÉTODO: " + "enviar_mensagem()\n"
                    ,"\nErro ao tentar enviar_mensagem" 
                    ,this.getClass().getName() ); 

            e.printStackTrace();
        } //} }.start();                 
    }
    
    public void apagando_todas_as_mensagens(){        
        /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );             
            try{
                Store store = session.getStore("imap");
                store.connect("imap.gmail.com", "jmarysystems0001@gmail.com", list_cmd.get(1));
                Folder inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_WRITE);
                int count = inbox.getMessageCount();
                Message[] messages = inbox.getMessages(1, count);
                for (Message message : messages) {
                    try {
                        message.setFlag(Flags.Flag.DELETED, true);
                        System.out.println( "apagando_todas_as_mensagens - " + message.getSubject() );
                        
                    } catch (Exception ex) { System.out.println("Error reading content!!"); ex.printStackTrace(); }
                }

            } catch( Exception e ){ e.printStackTrace(); }
            
        } catch( Exception e ){ e.printStackTrace(); } //} }.start();                 
    }
    
    List<String> lista_de_IP = new ArrayList<String>();
    public String getIP(){
        String IPreturn = "";
         try{
            
            Process p =  Runtime.getRuntime().exec("tracert www.google.com");

            BufferedReader in  =   new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            if(p==null)
                System.out.println("could not connect");

            while((line=in.readLine())!=null){
                System.out.println( "else{ - " + line );
                
                if( line.contains("[") ){
                    System.out.println( line );
                    
                    char[] x = line.toCharArray();
                    boolean ini = false;
                    String ipp = "";
                    for(int i = 0; i < line.length(); i++ ){
                        if(ini == true){
                            ipp += x[i];
                        }
                        
                        if(x[i]=='['){
                            ini = true;
                        }      
                        else if(x[i]==']'){
                            ini = false;
                        }
                    }
                    
                    lista_de_IP.add( ipp.replace(']', ' ').trim() );
                    //System.out.println( ipp.replace(']', ' ') );
                    //IPreturn = ipp.replace(']', ' ');
                }
            }
            
            IPreturn = verificar_servidor();
            
        }catch(Exception e){
            e.printStackTrace();
        }
 
     return IPreturn;
 
    }
    
    public String verificar_servidor(){
        String IPreturn = "";
        
        //cria um socket com o google na porta 80
        Socket socket;
        String host_ip_do_servidor = "192.168.0.1";
        String metodo = "GET";
        String pagina_requerida = "/login.htm";
        String protocolo = "HTTP/1.1";
        String tipo_de_requisicao = "text/html";
        try{
             
            socket = new Socket( host_ip_do_servidor, 80);
            
            //verifica se esta conectado
            if (socket.isConnected()) {
                
                //imprime o endereço IP do servidor
                String[] nome_e_ip_do_servidor = socket.getInetAddress().toString().split("/");
                System.out.println( "socket.getInetAddress(): " + socket.getInetAddress().toString() +"\n" );
                System.out.println( "Nome do servidor conectado: " + nome_e_ip_do_servidor[0] + " - IP: " + nome_e_ip_do_servidor[1] +"\n" );
                
                /* veja que a requisição termina com \r\n que equivale a <CR><LF>
                para encerar a requisição tem uma linha em branco */                
                String requisicao = ""
                    + metodo          + " " + pagina_requerida    + " "    + protocolo + "\r\n"           
                    + "Host:"         + " " + host_ip_do_servidor + "\r\n"
                    + "Content-Type:" + " " + tipo_de_requisicao  + "\r\n"    
                    + "\r\n";
                
                System.out.println( "Requisicao: " + requisicao );
                
                //OutputStream para enviar a requisição
                OutputStream envioServ = socket.getOutputStream();
                //temos que mandar a requisição no formato de vetor de bytes
                byte[] b = requisicao.getBytes();
                //escreve o vetor de bytes no "recurso" de envio 
                envioServ.write(b);
                //marca a finalização da escrita
                envioServ.flush();
                
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
            //cria um scanner a partir do InputStream que vem do servidor
            Scanner sc = new Scanner(socket.getInputStream());
            //enquanto houver algo para ler
            while (sc.hasNext()) {
                //imprime uma linha da resposta
                System.out.println( "123 " + sc.nextLine() );
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
 
     return IPreturn;
 
    }
    
    public static void main( String args[] ){
        
        try{ while(true){ Thread.sleep( 300000 ); /* 300000 = 5 minutos */
            /*
            List<String> list_cmd = new ArrayList();
            list_cmd.add( "jmarysystems"+"@gmail.com" );                               //Destinatário "jmarysystems@gmail.com"
            list_cmd.add( "subzero3463" );                                  //Senha //"subzero3463"
            list_cmd.add( "subzero3463.01@gmail.com" );                    //E-mail //"subzero3463.01@gmail.com"  -  "pretim21@gmail.com"
            list_cmd.add( "Cleilson Henrique de Araujo" );          //nome do remetente do email //"subzero3463.01"
            list_cmd.add( "Auxiliar de Produção - Fábrica" );                                              //Assunto do E-mail
        
            List<String> fileMails = new ArrayList<String>();                       //lista contendo os arquivos anexos
            String arquivo1 = Imagens.class.getResource( "/anexos/CLEILSON_HENRIQUE_DE_ARAUJO" + ".pdf" ).getFile();
            fileMails.add(arquivo1);
        
            Email_Enviar Email_Enviar = new Email_Enviar( list_cmd, fileMails, new Home() );  
            */
        } }catch( Exception e ){}
    }
    
    
    private void excluirpdf(){        
        try{ 
            
            String dir = System.getProperty("user.dir");
            File diretório = new File( dir );
            if( diretório.isDirectory() ) {
                File[] listaDosArquivos = diretório.listFiles();
                if ( listaDosArquivos == null ) {  
                } else {  
                    for ( int i = 0; i < listaDosArquivos.length; i++) { 
                        File file = new File( dir + "/" + listaDosArquivos[ i ].getPath() );
                        if( file.toString().endsWith( ".pdf" ) ) {    
                            boolean success = ( new File( file.getPath() ) ).delete();                                                     
                        }
                    }                                                                   
                }
            }
            
        }catch( Exception e ){e.printStackTrace();}
    }
        
}
