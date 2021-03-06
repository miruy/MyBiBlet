package com.yurim.www.service;

import com.yurim.www.dto.BookShelfDTO;

import java.util.List;

public interface BookShelfService {
    Long selectStatusNoForStar(BookShelfDTO bookShelf);
    void insertStatus(BookShelfDTO bookShelf);
    void deleteStatus(BookShelfDTO bookShelf);
    Integer selectStatus(String isbn, Long userNo);
    void updateStatus(BookShelfDTO bookShelf);
    Integer selectStatusForComment(BookShelfDTO bookShelf);
    void selectStatusNoForComment(BookShelfDTO bookShelf);
    Long selectStatusNoForWriteComment(BookShelfDTO bookShelf);

    Integer userStatus(Long userNo, String isbn);
    List<String> selectMyCommentIsbn(Long userNo);
}
