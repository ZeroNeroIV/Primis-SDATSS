package com.primis.seismicdetectionacrossthesolarsystem.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ZipFileDto {
    private MultipartFile file;
}
