package org.ludo.clientui.proxies;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "bibliotheque", url = "localhost:8080")
public interface MicroserviceLivresProxy {

    /*
    API Livre
     */

    @GetMapping(value = "/liste")
    List<LivreBean> listeLivre();

    @GetMapping(value = "/listeRecherche")
    List<LivreBean> listeLivreRecherche(@RequestParam(name = "mc")String mc);

    /*
    **************
    API Emprunt
    **************
     */

    @GetMapping(value = "/listeEmprunt")
    List<EmpruntBean> listeEmprunt();

    @GetMapping(value = "/emprunt/{idEmprunt}")
    EmpruntBean findById(@RequestParam Long idEmprunt);
}
