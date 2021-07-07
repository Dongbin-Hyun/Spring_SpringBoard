package kr.ac.kopo.ctc.spring.board.repository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.BaseEntity;
import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardItemRepositoryTest {
	
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	
	@Test
	void create() {
		//Date date = new Date();
		
		
		Board board1 = new Board();
		board1.setTitle("title");
		
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("boardItem1");
		
		boardItem1.setBoard(board1);
		
		BoardItem boardItem2 = new BoardItem();
		boardItem2.setTitle("boardItem2");
		boardItem2.setBoard(board1);
	
		
		
		List<BoardItem> list = new ArrayList<>();
		list.add(boardItem1);
		list.add(boardItem2);
		
		board1.setBoardItems(list);
		
		boardRepository.save(board1);
		
		Board board2 = new Board();
		board2.setTitle("title2");
		
		BoardItem boardItem3 = new BoardItem();
		boardItem3.setTitle("인사");
		boardItem3.setContent("안녕하세요");
		//boardItem3.setDatetime(date);
		boardItem3.setViewCnt(0);
		boardItem3.setBoard(board2);

		List<BoardItem> list2 = new ArrayList<>();	
		list2.add(boardItem3);
		
		board2.setBoardItems(list2);
		
		boardRepository.save(board2);
		
		BoardItem boardItem4 = new BoardItem();
		boardItem4.setBoard(board2);
		boardItem4.setTitle("음식");
		boardItem4.setContent("치킨");
		//boardItem4.setDatetime(date);
		boardItem4.setViewCnt(0);
		
		List<BoardItem> list3 = new ArrayList<>();
		list3.add(boardItem4);
		board2.setBoardItems(list3);
		
		boardRepository.save(board2);
		
		Board board3 = new Board();
		board3.setTitle("title3");
		
		boardRepository.save(board3);
		
		System.out.println("게시판 및 게시글 작성 완료");
	}
	
	@Test
	void update() {
		int id = 2;
		Optional<BoardItem> updateResult = boardItemRepository.findById(id);
		updateResult.ifPresent(selectBoardItem -> {
			selectBoardItem.setTitle("수정한게시판이름");
			System.out.println("게시판 수정 완료");
			
		boardItemRepository.save(selectBoardItem);	
		});	
		
	}
	
	//@Test
	void selectAll() {
		List<BoardItem> boardItems = boardItemRepository.findAll();
		for(BoardItem boardItem: boardItems) {
			System.out.println("============select all=========");
			System.out.println(boardItem.getId());
			System.out.println(boardItem.getTitle());
		}
	}
	
	@Test
	void findById() {//Board
		int id = 2;
		
		Optional<Board> result = boardRepository.findById(id);
		
		System.out.println("==============find by id Board======================");
		if(result.isPresent()) {
			Board board = result.get();
			System.out.println(board.getTitle());
		}	
	}
	
	//@Test
	void findById2() {//BoardItem
		
		int id = 5;
		
		Optional<BoardItem> result = boardItemRepository.findById(id);
		
		System.out.println("==============find by id BoardItem======================");
		if(result.isPresent()) {
			BoardItem boardItem = result.get();
			System.out.println(boardItem);
		}	
	}
	
	//@Test
	void deleteById() {//Board
		
		int id = 1;
		
		boardRepository.deleteById(id);
		System.out.println("========Board Delete Complete=======");
	}
		
	//@Test
	void deleteById2() {//BoardItem
		
		int id = 3;
		
		boardItemRepository.deleteById(id);
		System.out.println("=====BoardItem Delete Complete======");
		
	}
		
//	@Test
//	void pageDefault() {
//		//페이지 처리는 반드시 0부터 시작함
//		Pageable pageable = PageRequest.of(0, 4);//1페이지 4개
//		//Page<Board> result = boardRepository.findAll(pageable);
//		Page<BoardItem> result = boardItemRepository.findAll(pageable);
//		System.out.println("PageDefault start");
//		System.out.println(result);
//		System.out.println("PageDefault end");
//		System.out.println("PageDefault detail start");
//		System.out.println("Total pages : " + result.getTotalPages());
//		System.out.println("Total elements : " + result.getTotalElements());
//		System.out.println("Current page : " + result.getNumber());
//		System.out.println("Page size : " + result.getSize());
//		System.out.println("has next page? : " + result.hasNext());
//		System.out.println("has previous page? : " + result.hasPrevious());
//		System.out.println("PageDefault detail end");
//	}
	
	@Test
	void sort() {
		Sort sort1 = Sort.by("id").descending();
		Sort sort2 = Sort.by("title").ascending();
		Sort AllSort = sort1.and(sort2);
		Pageable pageable = PageRequest.of(0, 10, sort1);//0부터 시작
		//Pageable pageable = PageRequest.of(0, 10, sort2);//0부터 시작
		//Pageable pageable = PageRequest.of(0, 10, AllSort);//0부터 시작
		
		Page<BoardItem> result = boardItemRepository.findAll(pageable);
		result.get().forEach(boardItem -> {
			System.out.println(boardItem);
		});
		System.out.println("=========Paging Sort complete===============");
	}

}
