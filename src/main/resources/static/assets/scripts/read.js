const commentForm = document.getElementById('commentForm');
const commentContainer = document.getElementById('comment-container');

function createCommentElement(index, author, date, content) {
    // 새로운 댓글 요소 생성
    var commentDiv = document.createElement('div');
    commentDiv.setAttribute('rel', 'comment');

    var innerHTML = `
        <div>
            <span>[${index}]</span>
            <span>${author}</span>
            <span>${date}</span>
        </div>
        <div>${content}</div>
        <div>
            <button rel="modify">수정</button>
            <button rel="delete">삭제</button>
        </div>
    `;
    commentDiv.innerHTML = innerHTML;

    return commentDiv;
}

commentForm.onsubmit = function (e) {
    const commentTextarea = document.querySelector('.comment_textarea');
    const commentContent = commentTextarea.value;

    // 댓글 내용이 비어있는지 확인
    if (commentContent.trim() === "") {
        alert("댓글을 입력하세요.");
        return;
    }

    // 댓글을 생성하는 데 필요한 정보
    const index = 1; // 예시로 1로 설정
    const author = "작성자 자리"; // 예시로 작성자 이름 설정
    const date = "2024-01-01 00:00:00"; // 예시로 날짜 설정

    // 새로운 댓글 요소 생성
    const newCommentElement = createCommentElement(index, author, date, commentContent);

    // comment-container에 새로운 댓글 요소 추가
    commentContainer.appendChild(newCommentElement);

    // 댓글 입력창 비우기
    commentTextarea.value = "";
};

