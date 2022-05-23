package com.yurim.www.Controller;

import com.yurim.www.dto.AppraisalDTO;
import com.yurim.www.dto.BookShelfDTO;
import com.yurim.www.dto.UserDTO;
import com.yurim.www.service.AppraisalService;
import com.yurim.www.vo.RequestLogin;
import com.yurim.www.vo.RequestWriteComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppraisalController {

    private final AppraisalService appraisalService;

    /**
     * 도서 상세보기 - 해당 도서의 대한 모든 평가 추출
     */
    @GetMapping("/read/{isbn}")
    public String bookDetailAndComment(RequestLogin requestLogin, Model model, HttpSession session,
                                       HttpServletResponse response, Errors errors, @RequestParam(required = false) String query,
                                       @PathVariable String isbn) {

        // 해당 도서의 대한 평가 개수
        int commentCount = appraisalService.commentCount(isbn);

        // 해당 도서의 대한 모든 평가 불러오기
        List<AppraisalDTO> commentsByMembers = appraisalService.findAllComment(isbn);

        model.addAttribute("query", query);
        model.addAttribute("isbn", isbn);
        model.addAttribute("commentCount", commentCount);
        model.addAttribute("commentsByMembers", commentsByMembers);

        return "detail";
    }

    /**
     * 평가 등록
     */
    @PostMapping("/read/{isbn}")
    private String writeComment(@ModelAttribute("requestWriteComment") RequestWriteComment requestWriteComment,
                                RequestLogin requestLogin, Errors errors, Model model, HttpSession session,
                                HttpServletResponse response) throws UnsupportedEncodingException {

        AppraisalDTO appraisal = new AppraisalDTO();
        BookShelfDTO bookShelf = new BookShelfDTO();

        /**
         * 에러시 반환
         */
        if (errors.hasErrors()) {
            return "redirect:/";
        }

        /**
         * session에서 데이터를 꺼내 있는지 확인
         */
        UserDTO authInfo = null;
        if (session == null || session.getAttribute("authInfo") == null) {
            return "redirect:/login";
        }

        /**
         * 세션에 담긴 로그인 객체를 꺼내 userDTO객체로 저장
         */
        authInfo = (UserDTO) session.getAttribute("authInfo");

        /**
         * Long userNo로 변환
         */
        Long userNo = authInfo.getUserNo();

        bookShelf.setStatus(requestWriteComment.getOption());
        bookShelf.setUserNo(userNo);
        bookShelf.setIsbn(requestWriteComment.getIsbn());

        bookShelf = appraisalService.insertStatus(bookShelf);

        appraisal.setStar(requestWriteComment.getStar());
        appraisal.setComment(requestWriteComment.getComment());
        appraisal.setStartDate(requestWriteComment.getStartDate());
        appraisal.setEndDate(requestWriteComment.getEndDate());
        appraisal.setCoPrv(requestWriteComment.getCoPrv());
        appraisal.setStatusNo(bookShelf.getStatusNo());

        appraisalService.writeComment(appraisal);

        return "redirect:/read/" + requestWriteComment.getIsbn();
    }

    /**
     * 독서 상태 등록
     */
    @ResponseBody
    @PostMapping(value = "/insertStatus", produces = "application/json; charset=UTF-8")
    public ResponseEntity insertStatus(@RequestBody RequestWriteComment requestWriteComment,
                                       Errors errors,
                                       HttpSession session, HttpServletResponse response) {

        BookShelfDTO bookShelf = new BookShelfDTO();

        /**
         * 에러시 반환
         */
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /**
         * session에서 데이터를 꺼내 있는지 확인
         */
        UserDTO authInfo = null;
        if (session == null || session.getAttribute("authInfo") == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /**
         * 세션에 담긴 로그인 객체를 꺼내 userDTO객체로 저장
         */
        authInfo = (UserDTO) session.getAttribute("authInfo");

        /**
         * Long userNo로 변환
         */
        Long userNo = authInfo.getUserNo();

        bookShelf.setStatus(requestWriteComment.getOption());
        bookShelf.setUserNo(userNo);
        bookShelf.setIsbn(requestWriteComment.getIsbn());
        bookShelf = appraisalService.insertStatus(bookShelf);

        String statusMsg = null;
//        JSONObject jo=new JSONObject();

        if(bookShelf.getStatus() == 0){
            statusMsg = "해당 도서를 '찜' 으로 등록하였습니다.";
        }else if(bookShelf.getStatus() == 1){
            statusMsg = "해당 도서를 '보는 중' 으로 등록하였습니다.";
        }

//        jo.put("statusMsg",statusMsg);
        return ResponseEntity.ok(statusMsg);
    }
}