package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.BookVO;

@Mapper
public interface BookRepository {
	@Delete("""
			TRUNCATE TABLE book;
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO book
			 SET title = #{title}
			 , author = #{author}
			 , storeId = #{storeId}
			""")
	void insertBook(String title, String author, int storeId);

	@Select("""
			SELECT title
			 FROM book
			""")
	List<BookVO> selectBooks();

	@Select("""
			SELECT title
			 FROM book
			 WHERE storeId = #{storeId};
			""")
	List<BookVO> selectkoreaStoreBooks(int storeId);

	@Delete("""
			DELETE FROM book
			WHERE author = #{author}
			
			""")
	void deleteWriteBoook(String author);

	

}
