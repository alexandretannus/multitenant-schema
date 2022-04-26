package com.example.multitenancy.schema.domain.clube;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private ClubeService clubeService;

    @GetMapping
    public ResponseEntity<List<Clube>> listar(ServletWebRequest request) {
        // ShallowEtagHeaderFilter.disableContentCaching(request.getRequest());

        String eTag = "0";
/* 
        OffsetDateTime ultimaAtualizacao = clubeRepository.getUltimaAtualizacao();

        if (ultimaAtualizacao != null) {
            System.out.println("\n Mudou \n");
            eTag = String.valueOf(ultimaAtualizacao.toEpochSecond());
        }

        
        System.out.println(request.checkNotModified(eTag));

        if (request.checkNotModified(eTag)) {
            System.out.println("\n Não mudou \n");
            return null;
        }
 */
        List<Clube> clubes = clubeRepository.findAll();

        return ResponseEntity.ok()
                .body(clubes);
    }

    @GetMapping("{clubeId}")
    public Clube buscar(@PathVariable("clubeId") Long id) {

        return clubeService.buscarOuFalhar(id);
    }

    @PostMapping
    public Clube adicionar(@RequestBody Clube clube) {
        return clubeRepository.save(clube);
    }

    @DeleteMapping("{clubeId}")
    public void excluir(@PathVariable("clubeId") Long id) {
        clubeRepository.deleteById(id);
    }
}
