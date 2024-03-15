package com.site.SDE.RestController;

import com.site.SDE.Entite.Projet;
import com.site.SDE.Entite.ProjetDto;
import com.site.SDE.Service.ClientService;
import com.site.SDE.Service.ProjetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/projet")
public class ProjetRestController {
    @Autowired
    ProjetService animalService;
    @Autowired
    ClientService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ProjetDto ajouterOffre(@RequestBody ProjetDto animalDto){
        Projet offreRequest=modelMapper.map(animalDto,Projet.class);
        Projet animal=animalService.ajouterProjet(offreRequest);
        ProjetDto animalResponse=modelMapper.map(animal,ProjetDto.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Projet modifierOffre(@PathVariable("id")Long id,@RequestBody Projet animal){
        Projet newanimal=animalService.modifierProjet(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerAnimal(@PathVariable("id")Long id){
        animalService.supprimerProjet(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<ProjetDto> getanimalById(@PathVariable("id")Long id){
        Projet animal=animalService.getProjetById(id);
        ProjetDto animalDto=modelMapper.map(animal,ProjetDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<ProjetDto> lstAnimal(){
        return animalService.lstProjet().stream().map(animal -> modelMapper.map(animal,ProjetDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-animal-by-prop/{id}")
    public List<Projet> listanimalByIdPrp(@PathVariable Long id) {
        return animalService.listeProjetByClientId(id);
    }
}




