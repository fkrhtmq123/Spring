<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<jsp:include page="./inc/_aside_${group}.jsp" />
<section id="board" class="modify">
    <h3>글수정</h3>
    <article>
        <form action="/farmstory/board/modify?seq=${board.seq}" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" placeholder="${board.title}"/></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content">${board.content}</textarea>                                
                    </td>
                </tr>
                <tr>
                    <td>첨부</td>
                    <td><input type="file" name="fname"/></td>
                </tr>
            </table>
            <div>
                <a href="/farmstory/board/list?group=${group}&cate=${cate}" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="수정완료">
            </div>
        </form>
    </article>
</section>
<%@ include file="./inc/_aside_tail.jsp" %>
<%@ include file="../_footer.jsp" %>