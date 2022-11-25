package ar.edu.ubp.das.eventos.parcial3.repositories;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ubp.das.eventos.parcial3.beans.ActividadBean;
import ar.edu.ubp.das.eventos.parcial3.beans.AsistenteBean;
import ar.edu.ubp.das.eventos.parcial3.beans.ComentarioBean;
import ar.edu.ubp.das.eventos.parcial3.beans.EventoBean;
import ar.edu.ubp.das.eventos.parcial3.beans.UsuarioBean;

@Repository
public class EventosRepository {

    @Autowired
    private JdbcTemplate jdbcTpl; 

    @SuppressWarnings("unchecked")
    public List<EventoBean> getEventos() {     
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                  .withProcedureName("get_eventos")
                                  .withSchemaName("dbo")
                                  .returningResultSet("eventos", BeanPropertyRowMapper.newInstance(EventoBean.class));

        Map<String, Object> out = jdbcCall.execute();
        System.out.println("HOLA");
        return (List<EventoBean>)out.get("eventos");
    }

    @SuppressWarnings("unchecked")
    public List<EventoBean> getDatosEvento(Integer idEvento) {
        SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("nro_evento", idEvento);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                  .withProcedureName("get_datos_evento")
                                  .withSchemaName("dbo")
                                  .returningResultSet("evento", BeanPropertyRowMapper.newInstance(EventoBean.class));

        Map<String, Object> out = jdbcCall.execute(in);
        return (List<EventoBean>)out.get("evento");
    }

    @SuppressWarnings("unchecked")
    public List<ActividadBean> getActividadesEvento(Integer idEvento) {
        SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("nro_evento", idEvento);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                  .withProcedureName("get_actividades_evento")
                                  .withSchemaName("dbo")
                                  .returningResultSet("actividades", BeanPropertyRowMapper.newInstance(ActividadBean.class));

        Map<String, Object> out = jdbcCall.execute(in);
        return (List<ActividadBean>)out.get("actividades");
    }

    @Transactional
    public String inscripcionEvento(AsistenteBean asistente) {
      SqlParameterSource in = new MapSqlParameterSource()
                              .addValue("nro_evento", asistente.getNro_evento())
                              .addValue("apellido", asistente.getApellido())
                              .addValue("nombre", asistente.getNombre())
                              .addValue("correo", asistente.getCorreo())
                              .addValue("actividades", asistente.getActividades())
                              .addValue("id_asistente", null, Types.VARCHAR);
                              
      SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                .withProcedureName("ins_asistente_evento")
                                .withSchemaName("dbo");
  
      Map<String, Object> out = jdbcCall.execute(in);
      return (String)out.get("id_asistente").toString();
    }

    @Transactional
    public void setComentario(ComentarioBean comentario) {
      SqlParameterSource in = new MapSqlParameterSource()
                              .addValue("comentario",comentario.getComentario())
                              .addValue("id_asistente", comentario.getIdAsistente());
      SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                .withProcedureName("ins_comentario_asistencia_evento")
                                .withSchemaName("dbo");
      
      jdbcCall.execute(in);
      return ;
    }
    @Transactional
    public void getUsuario(UsuarioBean usuario) {
      SqlParameterSource in = new MapSqlParameterSource()
                              .addValue("correo",usuario.getCorreo())
                              .addValue("clave", usuario.getCorreo());
      SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                                .withProcedureName("get_usuarios")
                                .withSchemaName("dbo");
      jdbcCall.execute(in);

      return ;
    }
}
