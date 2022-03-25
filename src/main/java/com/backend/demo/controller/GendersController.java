package com.backend.demo.controller;

import com.backend.demo.exception.ResourceNotFoundException;
import com.backend.demo.model.Genders;
import com.backend.demo.repository.GendersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GendersController {
    @Autowired
    private GendersRepository gendersRepository;
    /********************************************************************************************/
    @GetMapping("/genders")
    public List<Genders> getAllGenders() {
        return gendersRepository.findAll();
    }
    /********************************************************************************************/
    @GetMapping("/genders/{id}")
    public ResponseEntity<Genders> getGendersById(@PathVariable(value = "id") Long gendersId)
        throws ResourceNotFoundException {
        Genders genders = gendersRepository.findById(gendersId)
        .orElseThrow(() -> new ResourceNotFoundException("Género no encontrado para el Id :: " + gendersId));
        return ResponseEntity.ok().body(genders);
    }
    /********************************************************************************************/
    @PostMapping("/genders")
    public Genders createGenders(@Valid @RequestBody Genders genders) {
        return gendersRepository.save(genders);
    }
    /********************************************************************************************/
    @PutMapping("/genders/{id}")
    public ResponseEntity<Genders> updateGenders(@PathVariable(value = "id") Long gendersId,
      @Valid @RequestBody Genders gendersDetails) throws ResourceNotFoundException {
        Genders genders = gendersRepository.findById(gendersId)
        .orElseThrow(() -> new ResourceNotFoundException("Género no encontrado para el Id :: " + gendersId));
        genders.setName(gendersDetails.getName());
        final Genders updatedGenders = gendersRepository.save(genders);
        return ResponseEntity.ok(updatedGenders);
    }
    /********************************************************************************************/
    @DeleteMapping("/genders/{id}")
    public Map<String, Boolean> deleteGenders(@PathVariable(value = "id") Long gendersId)
        throws ResourceNotFoundException {
        Genders genders = gendersRepository.findById(gendersId)
        .orElseThrow(() -> new ResourceNotFoundException("Género no encontrado para el Id :: " + gendersId));
        gendersRepository.delete(genders);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Borrado", Boolean.TRUE);
        return response;
    }
    /********************************************************************************************/
}
