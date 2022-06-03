package com.yurim.www.service;

import com.yurim.www.dto.BookShelfDTO;
import com.yurim.www.repository.BookShelfDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class BookShelfServiceImpl implements BookShelService{

    private final BookShelfDAO bookShelfDAO;

    @Override
    public void insertUserNoAndIsbn(BookShelfDTO bookShelf){
       bookShelfDAO.insertUserNoAndIsbn(bookShelf);
    }

    @Override
    public Long selectStatusNo(BookShelfDTO bookShelf){
        return bookShelfDAO.selectStatusNo(bookShelf);
    }

    @Override
    public void insertStatus(BookShelfDTO bookShelf){
        bookShelfDAO.insertStatus(bookShelf);
    }

    @Override
    public void deleteStatus(BookShelfDTO bookShelf){
        bookShelfDAO.deleteStatus(bookShelf);
    }

    @Override
    public Integer selectStatus(String isbn, Long userNo){
        HashMap<String, String> map = new HashMap<>();
        String userNoS = String.valueOf(userNo);

        map.put("userNo", userNoS);
        map.put("isbn", isbn);

        return bookShelfDAO.selectStatus(map);
    }

    @Override
    public void updateStatus(BookShelfDTO bookShelf){
        bookShelfDAO.updateStatus(bookShelf);
    }
}
