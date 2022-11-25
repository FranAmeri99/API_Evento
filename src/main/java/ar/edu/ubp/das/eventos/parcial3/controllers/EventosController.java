package ar.edu.ubp.das.eventos.parcial3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.eventos.parcial3.beans.ActividadBean;
import ar.edu.ubp.das.eventos.parcial3.beans.AsistenteBean;
import ar.edu.ubp.das.eventos.parcial3.beans.ComentarioBean;
import ar.edu.ubp.das.eventos.parcial3.beans.EventoBean;
import ar.edu.ubp.das.eventos.parcial3.beans.UsuarioBean;
import ar.edu.ubp.das.eventos.parcial3.repositories.EventosRepository;

@RestController
@RequestMapping(
  path="/eventos",
  produces={MediaType.APPLICATION_JSON_VALUE}
)
public class EventosController {

    @Autowired
    EventosRepository repository;


    @GetMapping(path="/{idEvento}")
    public ResponseEntity<EventoBean> getDatosEvento(@PathVariable("idEvento") Integer idEvento) {
      return new ResponseEntity<>(repository.getDatosEvento(idEvento).get(0), HttpStatus.OK);
    }

    @GetMapping(path="/listado")
    public ResponseEntity<List<EventoBean>> getEventos() {
      return new ResponseEntity<>(repository.getEventos(), HttpStatus.OK);
    }

    @PostMapping(
      path="/actividades",
      consumes={MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public ResponseEntity<List<ActividadBean>> getActividadesEvento(@RequestParam("nro_evento") Integer idEvento) {
        return new ResponseEntity<>(repository.getActividadesEvento(idEvento), HttpStatus.OK);
    }

    @PutMapping(path="/actividades/inscripcion", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> actualizarTipoDocumento(@RequestBody AsistenteBean updatedTipoDocumento) {
      return new ResponseEntity<>(repository.inscripcionEvento(updatedTipoDocumento), HttpStatus.OK);
    }

    @PutMapping(path="/asistente/comentario", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> comentario(@RequestBody ComentarioBean upComentarioBean) {
      repository.setComentario(upComentarioBean);
      return new ResponseEntity<>(null, HttpStatus.OK);
    } 
     @PutMapping(path="/login", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getUsuario(@RequestBody UsuarioBean upUsuarioBean) {
      repository.getUsuario(upUsuarioBean);
      return new ResponseEntity<>("ok", HttpStatus.OK);
    }



    
}
