package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.Sample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleRepositoryTests {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Before(value = "")
	private void before() {
		System.out.println("before");
	}
	
	@After(value = "")
	private void after() {
		System.out.println("after");
	}
	
//	@Test
//	public void findAll() {
//		Map<String, Object> filter = new HashMap<String, Object>();
//		filter.put("title", "미국");
//		
//		PageRequest pageable = PageRequest.of(0,  10);
//		Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
//		
//		for (Sample s : page) {
//			System.out.println(s.getTitle());
//		}		
//	}
	
	@Test
	public void findAll() {
		assertEquals(4, sampleRepository.count());
		
	}
	
	@Test
	public void equalTest() {
		assertEquals("일본", "일본");
	}
	
	@Test
	@Ignore
	public void notEqualTest() {
		assertEquals("미국", "일본");
	}

}
