document.addEventListener('DOMContentLoaded', (event) => {
    const commentForm = document.getElementById('commentForm');
    const commentContainer = document.getElementById('comment-container');
    const nickname = document.querySelector('.userNickname').textContent.trim();

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

    commentForm.onsubmit = function (e) {
        e.preventDefault();
        const commentTextarea = document.querySelector('.comment_textarea');
        const commentContent = commentTextarea.value;

        if (commentContent.trim() === "") {
            alert("댓글을 작성해주세요.");
            return;
        }

        const index = commentContainer.children.length + 1;
        const date = new Date().toLocaleString('ko-KR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit',
            hour: '2-digit',
            minute: '2-digit',
            second: '2-digit',
            hour12: false
        }).replace(/[-.]/g, '').replace(' ', '-').replace(' ', '-');

        const newCommentElement = createCommentElement(index, nickname, date, commentContent);
        commentContainer.appendChild(newCommentElement);
        commentTextarea.value = "";
    };
});
