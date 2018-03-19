package controller;

import javax.swing.JOptionPane;
import view.Inicio;
import view.Loading;
import view.Principal;

public class Controlador {
    
    public void iniciarPrograma(){
        Principal inicio = new Principal(this);
        inicio.setVisible(true);
    }
    
    public void abrirPrincipal(){
        Principal principal = new Principal(this);
        principal.setVisible(true);
        principal.setTitle("MetroCine");
    }
    
    public void iniciarSesion(Inicio inicio){
        if(inicio.jTextFieldUsuario.getText().trim().equals("admin") && inicio.jPasswordField.getText().equals("admin")){
            // Inicio frame Loading
            Loading loading = new Loading();
            
            Runnable miRunnable = new Runnable(){
            @Override
            public void run(){
                try
                {
                    // Si no hay ningun error carga el juego
                    inicio.dispose();
                    loading.setVisible(true);
                    for (int i = 0; i <= 100; i++) {
                        // Tiempo que tardará la carga
                        Thread.sleep(13);
                        loading.loadingBar.setValue(i);

                        if(i==100){
                            Thread.sleep(1000);
                        }
                    }
                    loading.dispose();
                    abrirPrincipal();
                }catch (InterruptedException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                }
            };
            Thread hilo = new Thread (miRunnable);
            hilo.start();
            
            // Fin frame loading
        }else{
            JOptionPane.showMessageDialog(inicio, "Usuario o contraseña inválidos");
            inicio.jTextFieldUsuario.setText("Ingrese su usuario");
            inicio.jPasswordField.setText("jPasswordField1");
        }
    }


    
    
}
