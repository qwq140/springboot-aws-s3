package com.cos.filetest.model.file;

import com.cos.filetest.dto.file.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_FILE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String oriFileName;

    private String fileName;

    private String directory;

    private String fileUrl;

    private String extension;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    public FileDTO toDTO(){
        return FileDTO.builder()
                .id(id)
                .oriFileName(oriFileName)
                .fileName(fileName)
                .directory(directory)
                .fileUrl(fileUrl)
                .extension(extension)
                .build();
    }
}
