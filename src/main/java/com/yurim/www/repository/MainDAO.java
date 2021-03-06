package com.yurim.www.repository;

import com.yurim.www.dto.AppraisalDTO;

import java.util.HashMap;
import java.util.List;

public interface MainDAO {
	List<String> popularList();
	List<String> recommendList();
	List<AppraisalDTO> latestComments();
	List<Integer> latestStar(HashMap<String, String> map);
	Long totalCommentCount();
	Long userCommentCount(Long userNo);
	Long userStarCount(Long userNo);
	List<String> wantReadList(Long userNo);
	List<String> readingList(Long userNo);
}
