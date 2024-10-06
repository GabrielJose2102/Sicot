package funcionabilidad;

import javax.swing.JOptionPane;

public class ValidacionesIndividual {

    public ValidacionesIndividual() {

    }

    public boolean compararDatos(String txtUsuario, String txtContraseña, 
            String usuario, String contraseña) {
        if (usuario.equals(txtUsuario) && contraseña.equals(txtContraseña)) {
            return true;
        } else {
            return false;
        }
        
    }
}
