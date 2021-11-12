package com.cos.filetest.dto.board;

import com.cos.filetest.model.board.BoardEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardSaveDTO {

    private String author;
    private String title;
    private String content;
    private MultipartFile file;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }

}
