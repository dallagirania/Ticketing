package com.site.SDE.RestController;

import com.site.SDE.Entite.Developper;
import com.site.SDE.Entite.Support;
import com.site.SDE.Repository.DevelopperRepository;
import com.site.SDE.Repository.SupportRepository;
import com.site.SDE.Service.SupportService;
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
@RequestMapping(value = "/support")
public class SupportRestController  {
    @Autowired
    private SupportRepository proprietaireRepository;

    public SupportRestController(SupportRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "loginsupp")
    public ResponseEntity<Map<String, Object>> loginsupp(@RequestBody Support admin) {

        HashMap<String, Object> response = new HashMap<>();

        Support userFromDB = proprietaireRepository.findIdByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "Support not found !");
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
    @PostMapping(path = "registerSup")
    public ResponseEntity<?> addsupp(@RequestBody Support developper) {
        if(proprietaireRepository.existsByEmail(developper.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        developper.setMdp(this.bCryptPasswordEncoder.encode(developper.getMdp()));
        Support savedUser = proprietaireRepository.save(developper);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    SupportService supportService;

    @RequestMapping(method = RequestMethod.POST)
    public Support ajouterSupport(@RequestBody Support proprietaire){
        return supportService.ajouterSupport(proprietaire);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Support modifierSupport(@PathVariable("id")Long id,@RequestBody Support proprietaire){
        Support newproprietaire=supportService.modifierSupport(proprietaire);
        return newproprietaire;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Support> GetSupportById(@PathVariable("id")Long id){
        Optional<Support>proprietaire=supportService.FindById(id);
        return proprietaire;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerSupport(@PathVariable("id")Long id){
        supportService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Support> listProprietaire(){
        return supportService.listSupport();
    }

//    @RequestMapping(method = RequestMethod.GET,value = "GetProprietaireByAnimalId/{id}")
//    public Support findProprietaireByAnimalId(@PathVariable("id")Long id){
//        Support newProp=proprietaireRepository.findProprietaireByAnimalId(id);
//        return newProp;
//    }

}

