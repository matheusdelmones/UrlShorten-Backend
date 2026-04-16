package Project.build.Urlshorten.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "urls")
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class UrlModel {

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "experies_at")   
    private LocalDateTime expiresAt;

    @Id
    @Column(name = "id")
    private String id;
    
}
