package com.gapsi.controller;

import com.gapsi.exception.ProviderExistException;
import com.gapsi.model.Provider;
import com.gapsi.service.ProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/providers")
@CrossOrigin(origins = "http://localhost:4200")
public class ProviderController {

    private static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";
    public ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping()
    public Page<Provider> getProvidersList(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "5") int size) {
        return providerService.getProviders(page, size);
    }

    @PostMapping()
    public ResponseEntity<Provider> addProvider(@RequestBody Provider provider) throws ProviderExistException {
        Provider  newProvider = providerService.saveProvider(provider);
        return new ResponseEntity<>(newProvider, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteProvider(@PathVariable("id") long id){
        providerService.deleteProvider(id);
        return response(NO_CONTENT, USER_DELETED_SUCCESSFULLY);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus status, String message) {
        return new ResponseEntity<>(
                new HttpResponse(status.value(), status, status.getReasonPhrase().toUpperCase(), message.toUpperCase()),
                status);
    }

}
