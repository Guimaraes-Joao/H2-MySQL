package guimaraes.joao.h2mysql.controller;

import guimaraes.joao.h2mysql.model.ClientEntity;
import guimaraes.joao.h2mysql.repository.CleintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private CleintRepository clienRepository;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> findAll() {
        return new ResponseEntity<List<ClientEntity>>(
                (List<ClientEntity>) this.clienRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientEntity>findById(@PathVariable("id") long id){
                    if(this.clienRepository.findById(id).isPresent()) {
                        return new ResponseEntity<ClientEntity>(
                                this.clienRepository.findById(id).get(),
                                new HttpHeaders(),
                                HttpStatus.OK
                        );
                    }
                    return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
        }

    public ResponseEntity<ClientEntity> store(ClientEntity clientEntity) {
        return new ResponseEntity<ClientEntity>(
                this.clienRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }
        @PutMapping(value = "/{id}")
        public ResponseEntity<ClientEntity> update(@PathVariable("id") long id,
                                                   ClientEntity clientEntity) throws Exception{
        if(id == 0 || !this.clienRepository.existsById(id)){
            throw new Exception("Código não encontrado ou inexistente");
        }
        return new ResponseEntity<ClientEntity>(
                this.clienRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.OK);
        }

        @DeleteMapping(value ="/{id}")
        public ResponseEntity<ClientEntity> delete(@PathVariable("id") long id){
        this.clienRepository.deleteById(id);
        return  new ResponseEntity<ClientEntity>(new HttpHeaders(), HttpStatus.OK);
        }
    }

