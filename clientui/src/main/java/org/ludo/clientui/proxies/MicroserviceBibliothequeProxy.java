package org.ludo.clientui.proxies;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "bibliotheque", url = "localhost:8080")
public interface MicroserviceBibliothequeProxy {

    /*
    APIs Livre
     */

    @GetMapping(value = "/liste")
    List<LivreBean> listeLivre();

    @GetMapping(value = "/listeRecherche")
    List<LivreBean> listeLivreRecherche(@RequestParam(name = "mc")String mc);


    /*
    *************
    APIs Emprunt
    **************
     */

    @GetMapping(value = "/listeEmprunt")
    List<EmpruntBean> listeEmprunt();

    @GetMapping(value = "/emprunt/id/{idEmprunt}")
    EmpruntBean findById(@RequestParam Long idEmprunt);

    @GetMapping(value = "/emprunt/pseudo/{pseudoEmprunteur}")
    public List<EmpruntBean> listeEmpruntUtilisateur(@PathVariable("pseudoEmprunteur") String pseudoEmprunteur);


    @PutMapping(value = "/emprunt/prolonger/{idEmprunt}")
    public EmpruntBean prolongerEmprunt(@PathVariable("idEmprunt")Long idEmprunt);

}
