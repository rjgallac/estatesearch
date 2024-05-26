package uk.co.sheffieldwebprogrammer.imageupload.imageupload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.co.sheffieldwebprogrammer.imageupload.imageupload.entity.ImageUpload;
import uk.co.sheffieldwebprogrammer.imageupload.imageupload.repository.ImageRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/imageupload")
@Slf4j
public class ImageUploadController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/{propertyId}")
    @CrossOrigin
    public String upload(@PathVariable("propertyId") long propertyId , @RequestParam("file") MultipartFile file) {

        UUID uuid = UUID.randomUUID();

        String filename = propertyId + "_large_" + uuid;
        String filePath = "/home/rob/docker-nginx/html" + File.separator + filename + ".jpg";
        log.info("image upload for propertyId {}", propertyId);

        String fileUploadStatus;


        try {

            // Creating an object of FileOutputStream class
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());

            // Closing the connection
            fout.close();
            fileUploadStatus = "File Uploaded Successfully";

        }

        // Catch block to handle exceptions
        catch (Exception e) {
            e.printStackTrace();
            fileUploadStatus =  "Error in uploading file: " + e;
        }

        ImageUpload imageUpload = new ImageUpload();
        imageUpload.setPropertyId(propertyId);
        imageUpload.setImageLargeFilename(filename);
        imageRepository.save(imageUpload);
        return fileUploadStatus;
    }

    @GetMapping("/{id}")
    public List<ImageUpload> getById(@PathVariable("id") Long id) {
        return imageRepository.findByPropertyId(id);
    }
}
