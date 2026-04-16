package Project.build.Urlshorten.Service;


import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import Project.build.Urlshorten.Dto.UrlRequestDto;
import Project.build.Urlshorten.Model.UrlModel;
import Project.build.Urlshorten.Repository.UrlRepository;

@Service
public class UrlService {
    
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    // verificar se id existe no banco de dados

    public boolean existsById(String id) {
        return urlRepository.existsById(id);
    } 
    
    // verifica se url existe no banco de dados

    public UrlModel shortenUrl(UrlRequestDto urlRequestDto) {
        String shortCode;

        do {
            shortCode = RandomStringUtils.randomAlphanumeric(6);
        } while (urlRepository.existsById(shortCode));

        UrlModel urlModel = new UrlModel();
        urlModel.setId(shortCode);

        urlModel.setFullUrl(urlRequestDto.fullUrl());
        urlModel.setShortUrl(shortCode);

        urlModel.setExpiresAt(LocalDateTime.now().plusMinutes(5));

        return urlRepository.save(urlModel);
        
    }

    public String getOriginalUrl(String id) {
    return urlRepository.findById(id)
        .filter(url -> url.getExpiresAt().isAfter(LocalDateTime.now())) 
        .map(UrlModel::getFullUrl) 
        .orElse(null); 
    }

}
