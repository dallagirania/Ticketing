package com.site.SDE.RestController;

import com.site.SDE.Entite.Client;
import com.site.SDE.Entite.Support;
import com.site.SDE.Repository.ClientRepository;
import com.site.SDE.Repository.SupportRepository;
import com.site.SDE.Service.ClientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/client")
public class ClientRestController {

    @Autowired
    public ClientRestController(ClientRepository candidatRepository) {this.proprietaireRepository= candidatRepository;}
    @Autowired
    private ClientRepository proprietaireRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "loginClient")
    public ResponseEntity<Map<String, Object>> loginclient(@RequestBody Client admin) {

        HashMap<String, Object> response = new HashMap<>();

        Client userFromDB = proprietaireRepository.findIdByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "Client not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    @PostMapping(path = "registerClient")
    public ResponseEntity<?> addClient(@RequestBody Client developper) {
        if(proprietaireRepository.existsByEmail(developper.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        developper.setMdp(this.bCryptPasswordEncoder.encode(developper.getMdp()));
        Client savedUser = proprietaireRepository.save(developper);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public Client ajouterClient(@RequestBody Client proprietaire){
        return clientService.ajouterClient(proprietaire);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Client modifierClient(@PathVariable("id")Long id,@RequestBody Client proprietaire){
        Client newproprietaire=clientService.modifierClient(proprietaire);
        return newproprietaire;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Client> GetClientById(@PathVariable("id")Long id){
        Optional<Client>proprietaire=clientService.FindById(id);
        return proprietaire;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerClient(@PathVariable("id")Long id){
        clientService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Client> listClient(){
        return clientService.listClient();
    }

//    @RequestMapping(method = RequestMethod.GET,value = "GetProprietaireByAnimalId/{id}")
//    public Client findClientByProjetId(@PathVariable("id")Long id){
//        Client newProp=proprietaireRepository.findClientByProjectId(id);
//        return newProp;
//    }

}