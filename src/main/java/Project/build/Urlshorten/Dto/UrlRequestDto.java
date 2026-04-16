package Project.build.Urlshorten.Dto;

import java.time.LocalDateTime;

public record UrlRequestDto(
    String fullUrl,
    String shortUrl, 
    LocalDateTime expiresAt){}
