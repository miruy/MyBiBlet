package com.yurim.www.service;

import com.yurim.www.dto.BookShelfDTO;

public interface BookShelService {
    void insertBookShelfForStar(BookShelfDTO bookShelf);
    Long selectStatusNoForStar(BookShelfDTO bookShelf);
    void insertStatus(BookShelfDTO bookShelf);
    void deleteStatus(BookShelfDTO bookShelf);
    Integer selectStatus(String isbn, Long userNo);
    void updateStatus(BookShelfDTO bookShelf);
}
