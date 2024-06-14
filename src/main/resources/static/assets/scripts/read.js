function formatDate(date) {
    return date.toLocaleString('ko-KR', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit',
        hour12: false
    }).replace(/[-.]/g, '').replace(' ', '-').replace(' ', '-');
}

function createCommentElement(index, nickname, date, content) {
    const commentDiv = document.createElement('div');
    commentDiv.setAttribute('rel', 'comment');

    const innerHTML = `
        <div>
            <span>[${index}]</span>
            <span>${nickname}</span>
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

document.addEventListener('DOMContentLoaded', function () {
    const commentForm = document.getElementById('commentForm');
    const commentContainer = document.getElementById('comment-container');
    const nickname = document.querySelector('.userNickname').textContent.trim();

    commentForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const commentTextarea = document.querySelector('.comment_textarea');
        const commentContent = commentTextarea.value.trim();

        if (commentContent === "") {
            alert("댓글을 작성해주세요.");
            return;
        }

        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/index/artist', true);
        xhr.setRequestHeader('Content-Type', 'application/json');

        xhr.onload = function () {
            if (xhr.status === 200) {
                const responseData = JSON.parse(xhr.responseText);
                const index = commentContainer.children.length + 1;
                const date = formatDate(new Date());

                const newCommentElement = createCommentElement(index, nickname, date, commentContent);
                commentContainer.appendChild(newCommentElement);
                commentTextarea.value = "";
            } else {
                alert('서버 오류가 발생했습니다.');
            }
        };

        xhr.onerror = function () {
            alert('서버와의 통신에 문제가 발생했습니다.');
        };

        const data = {
            nickname: nickname,
            content: commentContent
        };
        xhr.send(JSON.stringify(data));
    });
});
