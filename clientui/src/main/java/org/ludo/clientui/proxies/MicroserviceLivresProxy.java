package org.ludo.clientui.proxies;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "bibliotheque", url = "localhost:8080")
public interface MicroserviceLivresProxy {

    /*
    APIs Livre
     */

    @GetMapping(value = "/liste")
    List<LivreBean> listeLivre();

    @GetMapping(value = "/listeRecherche")
    List<LivreBean> listeLivreRecherche(@RequestParam(name = "mc")String mc);

/*    @PostMapping(value ="/livre/enregistrer")
    public LivreBean enregistrerNouveauLivre(@RequestBody LivreDto livreDto, Livre livre);

    @PutMapping(value = "/livre/edition")
    public LivreBean editionLivre(@RequestBody LivreDto livreDto);*/

    @GetMapping(value = "/livre/supprimer")
    public void supprimerLivre(Long idLivre);

    /*
    **************
    APIs Emprunt
    **************
     */

    @GetMapping(value = "/listeEmprunt")
    List<EmpruntBean> listeEmprunt();

    @GetMapping(value = "/emprunt/{idEmprunt}")
    EmpruntBean findById(@RequestParam Long idEmprunt);

    @GetMapping(value = "/emprunt/{idUtilisateur}")
    public List<EmpruntBean> listeEmpruntUtilisateur(@RequestParam Long idUtilisateur);

/*    @PostMapping(value = "/emprunt/")
    public EmpruntBean ouvrirEmprunt(@RequestBody EmpruntDto empruntDto, Livre livre);*/

    @PutMapping(value = "emprunt/{idEmprunt}")
    public EmpruntBean cloturerEmprunt(@RequestParam Long idEmprunt);
}
