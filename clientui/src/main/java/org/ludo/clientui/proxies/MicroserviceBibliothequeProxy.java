package org.ludo.clientui.proxies;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.LivreBean;
import org.ludo.clientui.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-server", contextId = "MicroserviceBibliothequeProxy", configuration = FeignConfig.class)
public interface MicroserviceBibliothequeProxy {

    /*
    APIs Livre
     */

    @GetMapping(value = "/bibliotheque/liste")
    List<LivreBean> listeLivre();

    @GetMapping(value = "/bibliotheque/listeRecherche")
    List<LivreBean> listeLivreRecherche(@RequestParam(name = "mc")String mc);

    @GetMapping(value = "/bibliotheque/livre/{idLivre}")
    LivreBean findLivreById(@PathVariable("idLivre")Long idLidvre);

    /*
    *************
    APIs Emprunt
    **************
     */

    @GetMapping(value = "/bibliotheque/listeEmprunt")
    List<EmpruntBean> listeEmprunt();

    @GetMapping(value = "/bibliotheque/emprunt/id/{idEmprunt}")
    EmpruntBean findById(@RequestParam Long idEmprunt);

    @GetMapping(value = "/bibliotheque/emprunt/pseudo/{pseudoEmprunteur}")
    public List<EmpruntBean> listeEmpruntUtilisateur(@PathVariable("pseudoEmprunteur") String pseudoEmprunteur);


    @PutMapping(value = "/bibliotheque/emprunt/prolonger/{idEmprunt}")
    public EmpruntBean prolongerEmprunt(@PathVariable("idEmprunt")Long idEmprunt);

}
