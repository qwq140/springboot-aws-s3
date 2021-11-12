package com.cos.filetest.service.board;

import com.cos.filetest.dto.board.BoardDTO;
import com.cos.filetest.dto.board.BoardSaveDTO;
import com.cos.filetest.dto.file.FileDTO;
import com.cos.filetest.model.board.BoardEntity;
import com.cos.filetest.model.board.BoardRepository;
import com.cos.filetest.model.file.FileEntity;
import com.cos.filetest.model.file.FileRepository;
import com.cos.filetest.utils.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {

    @Value("${file.path}")
    private String uploadFolder;

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public BoardDTO save(BoardSaveDTO boardSaveDTO) throws IOException {

        BoardEntity boardEntity = boardSaveDTO.toEntity();
        if(boardSaveDTO.getFile()!=null){
            FileEntity fileEntity = s3Uploader.upload(boardSaveDTO.getFile(),"static", boardSaveDTO);
            boardEntity.setFileEntity(fileRepository.save(fileEntity));
        }


//        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//        String oriFileName = boardSaveDTO.getFile().getOriginalFilename();
//        String fileName = now+"_"+oriFileName;
//        Path filePath = Paths.get(uploadFolder+fileName);
//        String extension = StringUtils.getFilenameExtension(fileName);
//        String fileUrl = "http://localhost:"+request.getLocalPort() +"/uploads/"+fileName;
//        try {
//            Files.write(filePath, boardSaveDTO.getFile().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        FileEntity fileEntity = FileEntity.builder()
//                .oriFileName(oriFileName)
//                .directory(dir)
//                .fileUrl(fileUrl)
//                .extension(extension)
//                .build();

        return boardRepository.save(boardEntity).toDTO();
    }

    public BoardDTO detail(Integer id){
        return boardRepository.findById(id).get().toDTO();

    }
}
