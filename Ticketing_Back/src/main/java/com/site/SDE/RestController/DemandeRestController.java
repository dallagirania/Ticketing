package com.site.SDE.RestController;

import com.site.SDE.Entite.Demande;
import com.site.SDE.Entite.DemandeDto;
import com.site.SDE.Entite.Projet;
import com.site.SDE.Entite.ProjetDto;
import com.site.SDE.Service.ClientService;
import com.site.SDE.Service.DemandeService;
import com.site.SDE.Service.ProjetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/demande")
public class DemandeRestController {@Autowired

    DemandeService animalService;
    @Autowired
    ProjetService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public DemandeDto ajouterDemande(@RequestBody DemandeDto animalDto){
        Demande offreRequest=modelMapper.map(animalDto,Demande.class);
        Demande animal=animalService.ajouterDemande(offreRequest);
        DemandeDto animalResponse=modelMapper.map(animal,DemandeDto.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Demande modifierDemande(@PathVariable("id")Long id,@RequestBody Demande animal){
        Demande newanimal=animalService.modifierDemande(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerDemande(@PathVariable("id")Long id){
        animalService.supprimerDemande(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<DemandeDto> getDemandeById(@PathVariable("id")Long id){
        Demande animal=animalService.getDemandeById(id);
        DemandeDto animalDto=modelMapper.map(animal,DemandeDto.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<DemandeDto> lstDemande(){
        return animalService.lstDemande().stream().map(animal -> modelMapper.map(animal,DemandeDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-Demande-by-proj/{id}")
    public List<Demande> listDemandeByIdPrp(@PathVariable Long id) {
        return animalService.listeDemandeByProjetId(id);
    }
}




