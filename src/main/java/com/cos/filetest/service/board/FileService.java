package com.cos.filetest.service.board;

import com.cos.filetest.dto.file.FileDTO;
import com.cos.filetest.model.file.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileDTO getFile(Integer id){
        return fileRepository.findById(id).get().toDTO();
    }
}
