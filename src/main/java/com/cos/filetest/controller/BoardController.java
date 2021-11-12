package com.cos.filetest.controller;

import com.cos.filetest.dto.board.BoardDTO;
import com.cos.filetest.dto.board.BoardSaveDTO;
import com.cos.filetest.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/save")
    public String save(BoardSaveDTO boardSaveDTO, HttpServletRequest request) throws IOException {
        BoardDTO boardDTO = boardService.save(boardSaveDTO, request); // 성공 실패 분기 해줘야함
        return "redirect:/board/detail/"+boardDTO.getId();
    }

    @GetMapping("/board/save")
    public String saveForm(){
        return "post";
    }

    @GetMapping("/board/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("boardDTO",boardService.detail(id));
        return "detail";
    }

}
