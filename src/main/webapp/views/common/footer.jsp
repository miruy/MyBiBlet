<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</main>

<footer class="bg-black px-32 py-10">

    <div class="grid place-items-center ">
        <c:if test="${!empty totalCommentCount}">
            <footer_biblet class="text-4xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-pink-600 to-purple-600">지금까지 ${totalCommentCount}개의 코멘트가 쌓였어요!</footer_biblet>
        </c:if>
    </div>

    <div class="flex mt-4">
        <div class="flex flex-col">
            <a href="/">
                <header_biblet class="hover:text-transparent font-bold text-white text-5xl flex flex-row">
                    <div class="bg-clip-text bg-gradient-to-br from-pink-600 to-purple-600">B</div>
                    <div class="text-white">i</div>
                    <div class="bg-clip-text bg-gradient-to-br from-pink-600 to-purple-600">B</div>
                    <div class="text-white">let</div>
                </header_biblet>
            </a>
            <p class="font-semibold text-white">
                ACME Industries Ltd. <br>Providing reliable tech since 1992
            </p>
            <p class="text-white">Copyright © 2022 - All right reserved</p>
        </div>

        <div></div>

        <div class="ml-auto pr-10 py-4 justify-center items-center text-center">
            <span class="footer-title text-base-100 text-2xl">Social</span>
            <div class="grid grid-flow-col gap-4 mt-2">
                <a><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 24 24" class="fill-current"><path d="M24 4.557c-.883.392-1.832.656-2.828.775 1.017-.609 1.798-1.574 2.165-2.724-.951.564-2.005.974-3.127 1.195-.897-.957-2.178-1.555-3.594-1.555-3.179 0-5.515 2.966-4.797 6.045-4.091-.205-7.719-2.165-10.148-5.144-1.29 2.213-.669 5.108 1.523 6.574-.806-.026-1.566-.247-2.229-.616-.054 2.281 1.581 4.415 3.949 4.89-.693.188-1.452.232-2.224.084.626 1.956 2.444 3.379 4.6 3.419-2.07 1.623-4.678 2.348-7.29 2.04 2.179 1.397 4.768 2.212 7.548 2.212 9.142 0 14.307-7.721 13.995-14.646.962-.695 1.797-1.562 2.457-2.549z"></path></svg></a>
                <a><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 24 24" class="fill-current"><path d="M19.615 3.184c-3.604-.246-11.631-.245-15.23 0-3.897.266-4.356 2.62-4.385 8.816.029 6.185.484 8.549 4.385 8.816 3.6.245 11.626.246 15.23 0 3.897-.266 4.356-2.62 4.385-8.816-.029-6.185-.484-8.549-4.385-8.816zm-10.615 12.816v-8l8 3.993-8 4.007z"></path></svg></a>
                <a><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 24 24" class="fill-current"><path d="M9 8h-3v4h3v12h5v-12h3.642l.358-4h-4v-1.667c0-.955.192-1.333 1.115-1.333h2.885v-5h-3.808c-3.596 0-5.192 1.583-5.192 4.615v3.385z"></path></svg></a>
            </div>
        </div>
    </div>

</footer>
</body>
</html>
