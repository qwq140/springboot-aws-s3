package com.cos.filetest.dto.file;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDTO {
    private Integer id;
    private String oriFileName;
    private String fileName;
    private String directory;
    private String fileUrl;
    private String extension;
}
