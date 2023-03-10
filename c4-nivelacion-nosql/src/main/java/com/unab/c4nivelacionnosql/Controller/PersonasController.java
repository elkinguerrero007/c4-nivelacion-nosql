package com.unab.c4nivelacionnosql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.c4nivelacionnosql.Collection.Personas;
import com.unab.c4nivelacionnosql.IService.IPersonasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/personas")
public class PersonasController {

	
	@Autowired
    private IPersonasService service;
    
    @GetMapping
    public List<Personas> all() {
        return service.all();
    }
    
    @GetMapping("{id}")
    public Optional<Personas> show(@PathVariable String id) {
        return service.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personas save(@RequestBody Personas personas) {
        return service.save(personas);
    }
    
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personas update(@PathVariable String id, @RequestBody Personas personas) {
        Optional<Personas> op = service.findById(id);
        
        if (!op.isEmpty()) {
            Personas personasUpdate = op.get();
            personasUpdate.setTipoDocumento(personas.getTipoDocumento());
            personasUpdate.setNombreCompleto(personas.getNombreCompleto());                        
            personasUpdate.setDireccion(personas.getDireccion());
            personasUpdate.setCelular(personas.getCelular());
            personasUpdate.setEstado(personas.getEstado());
            return service.save(personasUpdate);
        }
        
        return personas;
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
