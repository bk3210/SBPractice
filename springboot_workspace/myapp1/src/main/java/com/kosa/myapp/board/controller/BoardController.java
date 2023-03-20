package com.kosa.myapp.board.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosa.myapp.board.domain.BoardDTO;
import com.kosa.myapp.board.service.BoardService;

import jakarta.annotation.Resource;

@CrossOrigin("*")
@RestController
public class BoardController {
	
	// application.properties로부터 값을 읽어와야 한다
	@Value("${fileUploadPath}")
	String fileUploadPath="";
	
	@Value("${domain}")
	String domain="";
	
	@Resource(name="boardService")
	BoardService service;
	
	
	
	@RequestMapping("/board/list/{pg}")
	public HashMap<String, Object> board_getList(@PathVariable("pg")int pg, BoardDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setPg(pg-1);
		resultMap.put("result", "success");
		resultMap.put("totalCnt", service.getTotalCnt(dto));
		resultMap.put("list", service.getList(dto));
		
		return resultMap;
	}
	
	// http:127.0.0.1:9090/fileUpload/b.jpg
	// 파일 전송 처리를 해주지 않으면 값을 받지 못함 - application.proterties에 설정 추가
	@RequestMapping("/board/insert")
	public HashMap<String, Object> board_insert(MultipartFile file, BoardDTO dto){
		/*
		 * System.out.println(dto.getTitle()); System.out.println(dto.getWriter());
		 * System.out.println(dto.getContents());
		 */
		String filename = file.getOriginalFilename();
		try {
			Path uploadPath = Paths.get(fileUploadPath);
			Path filePath = uploadPath.resolve(filename);
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setFilename(filename);
		dto.setImage_url(domain+"/"+fileUploadPath+"/"+filename);
		service.insert(dto);
				
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", "success");
		
		return resultMap;
	}
	
	@GetMapping("/board/view/{seq}")
	public BoardDTO board_getView(@PathVariable("seq")String seq)
	{
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		
		return service.getView(dto);
	}
	
	// 파라미터의 dto에는 seq가 들어가있음
/*	@RequestMapping("/board/view/{seq}")
	public BoardDTO getView(@PathVariable("seq")String seq, BoardDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		BoardDTO resultDTO = service.getView(dto);
		try {
			resultMap.put("result", "success");
			resultMap.put("message", "success");
			resultMap.put("data", resultDTO);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
			resultMap.put("message", "fail");
		}
		
		System.out.println(dto.getTitle());
		
		return resultDTO;
		
	}
	*/
	
	

}
