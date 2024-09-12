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

    @GetMapping("/{id}")
    public List<ImageUpload> getById(@PathVariable("id") Long id) {
        return imageRepository.findByPropertyId(id);
    }


}
