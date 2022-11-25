package ar.edu.ubp.das.eventos.parcial3.beans;

import java.sql.Date;

public class EventoBean {
    
	private Date fecha_evento;
	private String nom_evento;	
	private String desc_evento;
	private int nro_evento;
	private String tipo_evento;

	public String getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	public Date getFecha_evento() {
		return fecha_evento;
	}
	public String getNom_evento() {
		return nom_evento;
	}
	public String getDesc_evento() {
		return desc_evento;
	}
	public int getNro_evento() {
		return nro_evento;
	}
	public void setFecha_evento(Date fecha_evento) {
		this.fecha_evento = fecha_evento;
	}
	public void setNom_evento(String nom_evento) {
		this.nom_evento = nom_evento;
	}
	public void setDesc_evento(String desc_evento) {
		this.desc_evento = desc_evento;
	}
	public void setNro_evento(int nro_evento) {
		this.nro_evento = nro_evento;
	}
}
