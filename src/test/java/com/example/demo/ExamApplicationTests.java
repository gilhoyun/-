package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BookStoreRepository;
import com.example.demo.vo.BookStoreVo;
import com.example.demo.vo.BookVO;

@SpringBootTest
class ExamApplicationTests {

	@Autowired
	private BookStoreRepository bookStoreRepository;
	@Autowired
	private BookRepository bookRepository;

	@Test
	void t1() {
		bookStoreRepository.truncateTable();
//		bookRepository.truncateTable();
	}

	// 서점을 두개를 만들어주세요.
	// 서점은 각가 이름과 보유서적으로 구성됩니다.
	// 각각 코리아서점, 아이티문고
	@Test
	void t2() {
		bookStoreRepository.insertStore("코리아서점");
		bookStoreRepository.insertStore("아이티문고");
	}

	// 모든 서점 정보 조회
	// 출력: 코리아 서점, 아이티문고
	@Test
	void t3() {
		List<BookStoreVo> bookStores = bookStoreRepository.selectBookStores();
		System.out.println("==서점 정보==");
		for (int i = 0; i < bookStores.size(); i++) {
			BookStoreVo bStore = bookStores.get(i);
			System.out.printf("%d. %s\n", i + 1, bStore.getName());
		}
	}

	// 아이티문고의 이름을 IT문고로 변경해주세요
	// 변경 후엔 t3() 메서드를 실행해 확인해주세요.
	// 출력: 코리아서점, IT문고
	@Test
	void t4() {
		bookStoreRepository.modifyStoreName(2, "IT문고");
	}

	// 책 5권을 만들어주세요
	// 책은 제목과 저자, 보유 서점으로 구성됩니다.
	// 책은 각각
	// 어린왕자, 생떽쥐페리, 코리아서점
	// 해리포터, 조앤 롤링, 코리아서점
	// 죄와벌, 도예토프스키, 코리아서점
	// 점프 투 스프링부트. 박응용, 아이티문고
	// 수학의 정석, 홍성대, 아이티문고
	// 로 만들어주세요.
	@Test
	void t5() {
		bookRepository.insertBook("어린왕자", "생떽쥐페리", 1);
		bookRepository.insertBook("해리포터", "조앤 롤링", 1);
		bookRepository.insertBook("죄와벌", "도예토프스키", 1);
		bookRepository.insertBook("점프 투 스프링부트", "박응용", 2);
		bookRepository.insertBook("수학의 정석", "생홍성대떽쥐페리", 2);

	}

	//모든 책의 제목을 출력하세요.
	@Test
	void t6() {

		List<BookVO> books =  bookRepository.selectBooks();
		
		System.out.println("==모든 책의 제목 ==");
		for (int i = 0; i < books.size(); i++) {
			BookVO bStore = books.get(i);
			System.out.printf("%d. %s\n", i + 1, bStore.getTitle());
		}
	}
	
	
	// 코리아서점에서 판매하는 책의 제목을 출력해주세요.
	@Test
	void t7() {
		List<BookVO> books =  bookRepository.selectkoreaStoreBooks(1);
		
		System.out.println("==코리아서점 책의 제목 ==");
		for (int i = 0; i < books.size(); i++) {
			BookVO bStore = books.get(i);
			System.out.printf("%d. %s\n", i + 1, bStore.getTitle());
		}

	}

	// 박응용 쓴 책을 삭제해주세요.
	// 삭제 후 t5 메서드를 이용해 확인해주세요.
	@Test
	void t8() {
    	bookRepository.deleteWriteBoook("박응용");
    	
    	t6();

	}
}
