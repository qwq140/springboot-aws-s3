package com.cos.filetest.model.board;

import com.cos.filetest.dto.board.BoardDTO;
import com.cos.filetest.model.file.FileEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_BOARD")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private String content;

    @JoinColumn(name = "FILE_ID")
    @OneToOne(fetch = FetchType.EAGER)
    private FileEntity fileEntity;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    public BoardDTO toDTO(){
        return BoardDTO.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .fileDTO(fileEntity.toDTO())
                .createDate(createDate)
                .build();
    }

}
