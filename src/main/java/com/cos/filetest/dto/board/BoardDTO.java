package com.cos.filetest.dto.board;

import com.cos.filetest.dto.file.FileDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardDTO {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private FileDTO fileDTO;
    private LocalDateTime createDate;
}
