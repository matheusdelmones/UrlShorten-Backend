package Project.build.Urlshorten.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.build.Urlshorten.Model.UrlModel;

public interface UrlRepository extends JpaRepository<UrlModel, String> {

    Optional <UrlModel> findById(String id);
    

    
}
