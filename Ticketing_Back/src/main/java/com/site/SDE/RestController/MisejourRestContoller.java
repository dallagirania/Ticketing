package com.site.SDE.RestController;

import com.site.SDE.Entite.Misejour;
import com.site.SDE.Entite.MisejourDTO;
import com.site.SDE.Entite.Projet;
import com.site.SDE.Entite.ProjetDto;
import com.site.SDE.Service.ClientService;
import com.site.SDE.Service.DemandeService;
import com.site.SDE.Service.MisejourService;
import com.site.SDE.Service.ProjetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/misejour")
public class MisejourRestContoller {
    @Autowired
    MisejourService misejourService;
    @Autowired
    DemandeService proprietaireService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    public MisejourDTO ajouterMisejour(@RequestBody MisejourDTO animalDto){
        Misejour offreRequest=modelMapper.map(animalDto,Misejour.class);
        Misejour animal=misejourService.ajouterMisejour(offreRequest);
        MisejourDTO animalResponse=modelMapper.map(animal,MisejourDTO.class);
        return animalResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Misejour modifierMisejour(@PathVariable("id")Long id,@RequestBody Misejour animal){
        Misejour newanimal=misejourService.modifierMisejour(animal);
        return newanimal;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerMisejour(@PathVariable("id")Long id){
        misejourService.supprimerMisejour(id);
    }

    //    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<MisejourDTO> getanimalById(@PathVariable("id")Long id){
        Misejour animal=misejourService.getMisejourById(id);
        MisejourDTO animalDto=modelMapper.map(animal,MisejourDTO.class);
        return ResponseEntity.ok().body(animalDto);
    }
    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<MisejourDTO> lstMisejour(){
        return misejourService.lstMisejour().stream().map(animal -> modelMapper.map(animal,MisejourDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("list-misejour-by-demande/{id}")
    public List<Misejour> listMisejourByIdDemande(@PathVariable Long id) {
        return misejourService.listeMisejourByDemandeId(id);
    }
}





