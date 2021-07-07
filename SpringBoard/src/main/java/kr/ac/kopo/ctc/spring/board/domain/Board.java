package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="RenamedBoard")
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="board")//EAGLE하고 LAZY 차이
	private Collection<BoardItem> boardItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<BoardItem> getBoardItems() {
		if (boardItems == null) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}

	public void setBoardItems(Collection<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
	
	public void addBoardItem(BoardItem bi) {
		Collection<BoardItem> boardItems = getBoardItems();
		boardItems.add(bi);
	}
	
	@Override
	public String toString() {
		String result = "["+id+"]" + title;
		for (BoardItem bi : getBoardItems()) {
			result += "\n" + bi.toString();
		}
		return result;
	}
	
	
	

}
