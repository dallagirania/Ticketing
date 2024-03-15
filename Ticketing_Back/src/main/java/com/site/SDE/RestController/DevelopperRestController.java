package com.site.SDE.RestController;

import com.site.SDE.Entite.Admin;
import com.site.SDE.Entite.Developper;
import com.site.SDE.Entite.Support;
import com.site.SDE.Repository.AdminRepository;
import com.site.SDE.Repository.DevelopperRepository;
import com.site.SDE.Repository.SupportRepository;
import com.site.SDE.Service.DevelopperService;
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
@RequestMapping(value = "/dev")
public class DevelopperRestController {
    @Autowired
    private DevelopperRepository proprietaireRepository;


    public DevelopperRestController(DevelopperRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "logindev")
    public ResponseEntity<Map<String, Object>> logindev(@RequestBody Developper admin) {

        HashMap<String, Object> response = new HashMap<>();

        Developper userFromDB = proprietaireRepository.findIdByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "dev not found !");
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
    @PostMapping(path = "registerdev")
    public ResponseEntity<?> adddev(@RequestBody Developper developper) {
        if(proprietaireRepository.existsByEmail(developper.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        developper.setMdp(this.bCryptPasswordEncoder.encode(developper.getMdp()));
        Developper savedUser = proprietaireRepository.save(developper);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    DevelopperService supportService;

    @RequestMapping(method = RequestMethod.POST)
    public Developper ajouterSupport(@RequestBody Developper proprietaire){
        return supportService.ajouterDevelopper(proprietaire);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Developper modifierDevelopper(@PathVariable("id")Long id,@RequestBody Developper proprietaire){
        Developper newproprietaire=supportService.modifierDevelopper(proprietaire);
        return newproprietaire;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Developper> GetDevelopperById(@PathVariable("id")Long id){
        Optional<Developper>proprietaire=supportService.FindById(id);
        return proprietaire;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerDevelopper(@PathVariable("id")Long id){
        supportService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Developper> listDevelopper(){
        return supportService.listDevelopper();
    }

}
