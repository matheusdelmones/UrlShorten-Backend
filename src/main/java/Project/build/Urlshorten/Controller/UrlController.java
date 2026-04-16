package Project.build.Urlshorten.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.build.Urlshorten.Dto.UrlRequestDto;
import Project.build.Urlshorten.Dto.UrlResponseDTO;
import Project.build.Urlshorten.Model.UrlModel;
import Project.build.Urlshorten.Service.UrlService;

@RestController
@RequestMapping("/")
public class UrlController {
    
    private final UrlService urlService;
    
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @Value("${app.base-url:http://localhost:8081/}")
    private String baseUrl;

    @PostMapping
    public ResponseEntity<UrlResponseDTO> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {

        UrlModel urlModel = urlService.shortenUrl(urlRequestDto);
        String shortUrl = baseUrl + urlModel.getId();
        return ResponseEntity.ok(new UrlResponseDTO(shortUrl));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable("id") String id) {

        String originalUrl = urlService.getOriginalUrl(id);

        if (originalUrl != null) {
        
        return ResponseEntity
                .status(HttpStatus.FOUND) 
                .location(URI.create(originalUrl)) 
                .build();
    } 
    
    return ResponseEntity.notFound().build();

    }
}


