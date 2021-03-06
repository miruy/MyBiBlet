package com.yurim.www.repository;

import com.yurim.www.dto.AppraisalDTO;
import com.yurim.www.dto.BookShelfDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppraisalDAOImpl implements AppraisalDAO {

	private final SqlSessionTemplate sqlSessionTemplate;

	// 해당 도서의 대한 모든 평가 호출
	@Override
	public List<AppraisalDTO> findAllComment(String isbn) {
		return sqlSessionTemplate.selectList("findAllComment", isbn);
	}

	@Override
	public List<AppraisalDTO> findAllStar(String isbn){
		return sqlSessionTemplate.selectList("findAllStar", isbn);
	}

	// 해당 도서의 대한 평가 개수 호출
	@Override
	public int commentCount(String isbn) {
		return sqlSessionTemplate.selectOne("commentCount", isbn);
	}

	// 평가 작성
	@Override
	public void writeComment(AppraisalDTO appraisal) {
		sqlSessionTemplate.insert("writeComment", appraisal);
	}

	@Override
	public Integer starAVG(String isbn){
		return sqlSessionTemplate.selectOne("starAVG", isbn);
	}

	@Override
	public Long starCount(String isbn){
		return sqlSessionTemplate.selectOne("starCount", isbn);
	}

	@Override
	public Integer userStar(HashMap<String, String> map){
		return sqlSessionTemplate.selectOne("userStar", map);
	}

	@Override
	public void insertStar(HashMap<String, Long> map){
		sqlSessionTemplate.insert("insertStar", map);
	}

	@Override
	public void updateStar(AppraisalDTO appraisal){
		sqlSessionTemplate.update("updateStar", appraisal);
	}

	@Override
	public void deleteStar(HashMap<String, String> map){
		sqlSessionTemplate.delete("deleteStar", map);
	}

	@Override
	public List<AppraisalDTO> selectMyComment(BookShelfDTO bookShelf){
		return sqlSessionTemplate.selectList("selectMyComment", bookShelf);
	}

	@Override
	public void updateComment(AppraisalDTO appraisal){
		sqlSessionTemplate.update("updateComment", appraisal);
	}



	@Override
	public String selectKakaoNameById(String id){
		return sqlSessionTemplate.selectOne("selectKakaoNameById", id);
	}

	@Override
	public void deleteComment(HashMap<String, String> map){
		sqlSessionTemplate.delete("deleteComment", map);
	}
}
