package gestioncentrodeportivo;

public class GestionCentroDeportivo {

    public static void main(String args[]) {
        
        // --- Código para configurar el Look and Feel (Opcional pero recomendado) ---
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // --- Fin del Look and Feel ---


        /* Crea y muestra el formulario (Ventana) */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Le decimos que abra tu ventana
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}