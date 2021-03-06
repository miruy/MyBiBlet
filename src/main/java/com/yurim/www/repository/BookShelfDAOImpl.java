package com.yurim.www.repository;

import com.yurim.www.dto.AppraisalDTO;
import com.yurim.www.dto.BookShelfDTO;
import com.yurim.www.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookShelfDAOImpl implements BookShelfDAO {

	private final SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Long selectStatusNoForStar(BookShelfDTO bookShelf){
		return sqlSessionTemplate.selectOne("selectStatusNoForStar", bookShelf);
	}

	@Override
	public void insertStatus(BookShelfDTO bookShelf){
		sqlSessionTemplate.insert("insertStatus", bookShelf);
	}

	@Override
	public void deleteStatus(BookShelfDTO bookShelf){
		sqlSessionTemplate.delete("deleteStatus", bookShelf);
	}

	@Override
	public Integer selectStatus(HashMap<String, String> map){
		return sqlSessionTemplate.selectOne("selectStatus", map);
	}

	@Override
	public void updateStatus(BookShelfDTO bookShelf){
		sqlSessionTemplate.update("updateStatus", bookShelf);
	}
	@Override
	public Integer selectStatusForComment(BookShelfDTO bookShelf) {
		return sqlSessionTemplate.selectOne("selectStatusForComment", bookShelf);
	}

	@Override
	public Long selectStatusNoForComment(BookShelfDTO bookShelf) {
		return sqlSessionTemplate.selectOne("selectStatusNoForComment", bookShelf);
	}

	@Override
	public Long selectStatusNoForWriteComment(BookShelfDTO bookShelf){
		return sqlSessionTemplate.selectOne("selectStatusNoForWriteComment", bookShelf);
	}

	@Override
	public Integer userStatus(HashMap<String, String> map){
		return sqlSessionTemplate.selectOne("userStatus", map);
	}

	@Override
	public List<String> selectMyCommentIsbn(Long userNo){
		return sqlSessionTemplate.selectList("selectMyCommentIsbn", userNo);
	}
}
