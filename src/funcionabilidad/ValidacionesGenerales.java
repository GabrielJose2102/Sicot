package funcionabilidad;

import javax.swing.JOptionPane;

public class ValidacionesGenerales {

    public ValidacionesGenerales() {

    }

    public static boolean camposVaciosArray(String[] campos) {

        for (String campo : campos) {
            if (campo.equals("")) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarTodos(String datos) {

        return datos.matches("[0-9a-zA-Z -]*");
    }
    
    public static boolean validarTodos(String[] datos) {

        for (String dato : datos) {

            if (!validarTodos(dato)) {
                return false;
            }

        }
        return true;
    }
    
    public static boolean validarNumeros(String datos) {

        return datos.matches("[0-9]*");
    }

    public static boolean validarNumerosC(String[] datos) {

        for (String dato : datos) {

            if (!validarNumeros(dato)) {
                return false;
            }

        }
        return true;
    }

    public static boolean validarLetras(String datos) {

        return datos.matches("[a-zA-Z ]*");
    }
    
    public static boolean validarLetras(String[] datos) {

        for (String dato : datos) {

            if (!ValidacionesGenerales.validarLetras(dato)) {
                return false;
            }

        }
        return true;
    }
    
    public static void main(String[] args) {
       String[] camposT = {"0000"};
       
        if (!validarLetras(camposT)) {
                        JOptionPane.showMessageDialog(null, "Los campos (nombre, apellido, nombreUsuario) solo deben contener letras...");
                    } else if (!validarNumerosC(camposT)) {
                        JOptionPane.showMessageDialog(null, "El campo (Cedula) solo deben contener Numeros...");
                    } else if (!validarTodos(camposT)) {
                        JOptionPane.showMessageDialog(null, "Los campos (contraseña, contraseñaConfirmar) no debe contener caracters especiales...");
                    } else {
                        System.out.println("Listo");
                    }
       
    }
}
