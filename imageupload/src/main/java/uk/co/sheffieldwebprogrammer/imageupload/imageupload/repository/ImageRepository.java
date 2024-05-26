package uk.co.sheffieldwebprogrammer.imageupload.imageupload.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.sheffieldwebprogrammer.imageupload.imageupload.entity.ImageUpload;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageUpload, Long> {
    List<ImageUpload> findByPropertyId(Long id);
}
