package uk.co.sheffieldwebprogrammer.imageupload.imageupload.controller;

import lombok.extern.slf4j.Slf4j;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.co.sheffieldwebprogrammer.imageupload.imageupload.entity.ImageUpload;
import uk.co.sheffieldwebprogrammer.imageupload.imageupload.repository.ImageRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/imageupload")
@Slf4j
@CrossOrigin
public class ImageUploadController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/{propertyId}")
    @CrossOrigin
    public void upload(@PathVariable("propertyId") long propertyId , @RequestParam("file") MultipartFile file) {

        UUID uuid = UUID.randomUUID();

        String filename = propertyId + "_large_" + uuid;
        String filePath = "d:\\docker-nginx\\html\\" + File.separator + filename + ".jpg";
        log.info("image upload for propertyId {}", propertyId);

        String fileUploadStatus;

        String thumbFilename = propertyId + "_thumb_" + uuid;
        String filePathThumb = "d:\\docker-nginx\\html\\" + File.separator + thumbFilename + ".jpg";

        try {
            ByteArrayOutputStream thumbnail = createThumbnail(file, 200);
            try {

                // Creating an object of FileOutputStream class
                FileOutputStream fout = new FileOutputStream(filePathThumb);
                fout.write(thumbnail.toByteArray());

                // Closing the connection
                fout.close();
                fileUploadStatus = "File Uploaded Successfully";

            }

            // Catch block to handle exceptions
            catch (Exception e) {
                e.printStackTrace();
                fileUploadStatus =  "Error in uploading file: " + e;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
        imageUpload.setImageSmallFilename(thumbFilename);
        imageRepository.save(imageUpload);
//        return fileUploadStatus;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteByImageId(@PathVariable("id") long id) {
        Optional<ImageUpload> byId = imageRepository.findById(id);
        if(byId.isPresent()) {
            ImageUpload imageUpload = byId.get();
            File myObj = new File("d:\\docker-nginx\\html\\" + imageUpload.getImageSmallFilename() + ".jpg");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

            myObj = new File("d:\\docker-nginx\\html\\" + imageUpload.getImageLargeFilename() + ".jpg");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
            imageRepository.deleteById(id);

        }
    }

    @DeleteMapping("/deletebypropertyid/{id}")
    @CrossOrigin
    public void delete(@PathVariable("id") long id) {
        List<ImageUpload> byPropertyId = imageRepository.findByPropertyId(id);
        for (ImageUpload imageUpload : byPropertyId) {
            File myObj = new File("d:\\docker-nginx\\html\\" + imageUpload.getImageSmallFilename() + ".jpg");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

            myObj = new File("d:\\docker-nginx\\html\\" + imageUpload.getImageLargeFilename() + ".jpg");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
            imageRepository.deleteById(imageUpload.getId());
        }

    }

    @GetMapping("/{id}")
    public List<ImageUpload> getById(@PathVariable("id") Long id) {
        return imageRepository.findByPropertyId(id);
    }

    private ByteArrayOutputStream createThumbnail(MultipartFile orginalFile, Integer width) throws IOException {
        ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
        BufferedImage thumbImg = null;
        BufferedImage img = ImageIO.read(orginalFile.getInputStream());
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumbImg, orginalFile.getContentType().split("/")[1] , thumbOutput);
        return thumbOutput;
    }
}
