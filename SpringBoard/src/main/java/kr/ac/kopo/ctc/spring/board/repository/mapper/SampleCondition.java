package kr.ac.kopo.ctc.spring.board.repository.mapper;

import java.io.Serializable;

public class SampleCondition implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

		
	
	
	

	

}
