package org.ludo.clientui.proxies;

import org.ludo.clientui.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "bibliotheque", url = "localhost:8080")
public interface MicroserviceLivresProxy {

    @GetMapping(value = "/liste")
    List<LivreBean> listeLivre();

    @GetMapping(value = "/listeRecherche")
    List<LivreBean> listeLivreRecherche(@RequestParam(name = "mc")String mc);

}
