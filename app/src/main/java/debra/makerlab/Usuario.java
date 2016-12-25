package debra.makerlab;

/**
 * Created by Debra on 07/09/2016.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direc;
    private String cel;
    private String  correo;

    public Usuario(int id, String correo, String direc, String cel, String apellido, String dni, String nombre) {
        this.dni = dni;
        this.correo = correo;
        this.direc = direc;
        this.cel = cel;
        this.apellido = apellido;
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
