package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model;

import lombok.Data;

@Data
public class ImageUploadDto {
    long id;
    String imageLargeFilename;
    String imageSmallFilename;
}
