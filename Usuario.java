package proyectofinal;

import javax.swing.JOptionPane;

public class Usuario {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private int cedula;
    private String usuario;
    private String contrasena;
    private boolean estado;

    public Usuario() {
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.cedula = 0;
        this.usuario = "";
        this.contrasena = "";
        this.estado = true;
    }

    
    public void MenuPrincipal() {
        int opcionMenu = 0;

        while (opcionMenu != 5) {
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO A LA ESCUELA DEPORTIVA CAZATALENTOS\nSELECCIONE UNA DE LAS OPCIONES\n"
                    + "********************************************\n"
                    + "1- REGISTRO DE USUARIOS\n"
                    + "2- CONSULTAR USUARIOS\n"
                    + "3- Inactivar/Desactivar Usuario\n"
                    + "4- FACTURACION\n"
                    + "5- SALIR"));

            switch (opcionMenu) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    int cedulaInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del cliente a consultar"));
                    consultaCedula(cedulaInput);
                    break;
                case 3:
                    int cedulaInputDesactivar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del usuario a inactivar/desactivar"));
                    int opcionDesactivar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para activar o 0 para desactivar al usuario"));
                    if (cedulaInputDesactivar == getCedula()) {
                        if (opcionDesactivar == 1) {
                            activar();
                            JOptionPane.showMessageDialog(null, "Usuario activado con éxito.");
                        } else if (opcionDesactivar == 0) {
                            desactivar();
                            JOptionPane.showMessageDialog(null, "Usuario desactivado con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opción no válida. Use 1 para activar o 0 para desactivar al usuario.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                    break;
                case 4:
                    // Lógica para facturación
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Ingrese solo números del 1 al 5 e inténtelo de nuevo.");
            }
        }
    }

    public void registrarUsuario() {
        String nombreInput = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
        setNombre(nombreInput);

        String apellido1Input = JOptionPane.showInputDialog("Ingrese el primer apellido del usuario");
        setApellido1(apellido1Input);

        String apellido2Input = JOptionPane.showInputDialog("Ingrese el segundo apellido del usuario");
        setApellido2(apellido2Input);

        String usuarioInput = JOptionPane.showInputDialog("Ingrese el Usuario (Nickname)");
        setUsuario(usuarioInput);

        String contrasenaInput = JOptionPane.showInputDialog("Ingrese la contraseña");
        setContrasena(contrasenaInput);

        String estadoInput = JOptionPane.showInputDialog("Ingrese el estado del usuario (Activo o Inactivo)").toLowerCase();
        setEstado(estadoInput.equals("activo"));

        int cedulaInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del usuario"));
        setCedula(cedulaInput);
    }

    public void consultaCedula(int cedulaInput) {
        if (cedulaInput == getCedula()) {
            String informacion;
            if (estado) {
                informacion = "Información del usuario:\n"
                        + "Nombre: " + getNombre() + "\n"
                        + "Primer Apellido: " + getApellido1() + "\n"
                        + "Estado: Activo\n\n"
                        + "Escribe 'desactivar' para desactivar al usuario.";
                String opcion = JOptionPane.showInputDialog(null, informacion);
                if ("desactivar".equalsIgnoreCase(opcion)) {
                    desactivar();
                    JOptionPane.showMessageDialog(null, "Usuario desactivado con éxito.");
                }
            } else {
                informacion = "Información del usuario:\n"
                        + "Nombre: " + getNombre() + "\n"
                        + "Primer Apellido: " + getApellido1() + "\n"
                        + "Estado: Inactivo\n\n"
                        + "Escribe 'activar' para activar al usuario.";
                String opcion = JOptionPane.showInputDialog(null, informacion);
                if ("activar".equalsIgnoreCase(opcion)) {
                    activar();
                    JOptionPane.showMessageDialog(null, "Usuario activado con éxito.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    public void activar() {
        estado = true;
    }

    public void desactivar() {
        estado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.MenuPrincipal();
    }
}
