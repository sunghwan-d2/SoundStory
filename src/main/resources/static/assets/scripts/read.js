const commentForm = document.forms['commentForm'];

commentForm.onsubmit = e => {
    e.preventDefault();
    if (commentForm['content'].value.trim() === '') {
        alert('댓글을 작성해 주세요.');
        commentForm['content'].focus();
    } else if (commentForm['content'].value.length < 1 || commentForm['content'].value.length > 10000) {
        alert('올바른 내용을 입력해 주세요.');
        commentForm['content'].focus();
    } else {
        commentForm.submit();
    }
}

const deleteCommentButtons = document.querySelectorAll('.deleteButton');

deleteCommentButtons.forEach(deleteCommentButton => {
    deleteCommentButton.addEventListener('click', () => {
        if (!confirm('정말 댓글을 삭제할까요?')) {
            return;
        }

        const indexElement = deleteCommentButton.closest('tr').querySelector('.index');
        const index = indexElement.textContent.trim();

        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    const responseObject = JSON.parse(xhr.responseText);
                    switch (responseObject.result) {
                        case 'success':
                            location.reload();
                            break;
                        case 'failure':
                            alert('삭제에 실패하였습니다. 다시 시도해 주세요.');
                            break;
                        default:
                            alert('오류가 발생하였습니다. 잠시 후 다시 시도해 주세요.');
                    }
                } else {
                    alert('서버 오류가 발생하였습니다. 잠시 후 다시 시도해 주세요.');
                }
            }
        };

        xhr.open('DELETE', '/comment/?index=' + index);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send();
    });
});

// const CommentCountText = document.forms['commentForm'].querySelector('[rel=CommentCountText]');


document.addEventListener('DOMContentLoaded', function () {
    // CommentCountText 요소가 올바르게 선택되는지 확인
    const CommentCountText = document.querySelector('[rel=CommentCountText]');
    if (CommentCountText) {
        fetch('/comment/count') // 예시: 적절한 API 엔드포인트로 변경
            .then(response => response.json())
            .then(data => {
                const initialCommentCount = parseInt(data.count);
                updateCommentCount(initialCommentCount);
            })
            .catch(error => {
                console.error('Error fetching comment count:', error);
            });
    } else {
        console.error('CommentCountText element not found.');
    }
});

// 댓글 수 업데이트 함수
function updateCommentCount(count) {
    const commentCountElement = document.getElementById('commentCount');
    if (commentCountElement) {
        commentCountElement.textContent = count;
    } else {
        console.error('commentCountElement with id "commentCount" not found.');
    }
}
