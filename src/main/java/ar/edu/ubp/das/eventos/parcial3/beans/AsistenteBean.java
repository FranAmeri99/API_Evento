package ar.edu.ubp.das.eventos.parcial3.beans;

public class AsistenteBean {
    private Integer nro_evento;
    private String nombre;
    private String apellido;
    private String correo;
    private String actividades;
    private String idAsistente;
    private String comentario;
    
    public Integer getNro_evento() {
        return nro_evento;
    }
    public void setNro_evento(Integer nro_evento) {
        this.nro_evento = nro_evento;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getActividades() {
        return actividades;
    }
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
    public String getIdAsistente() {
        return idAsistente;
    }
    public void setIdAsistente(String idAsistente) {
        this.idAsistente = idAsistente;
    }

    
}
