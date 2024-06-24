const commentForm = document.forms['commentForm'];

commentForm.onsubmit = e => {
    e.preventDefault();

    if (commentForm['content'].value.length < 1 || commentForm['content'].value.length > 1000) {
        alert('올바른 내용을 입력해 주세요.');
        commentForm['content'].focus();
        return;
    }

    const xhr = new XMLHttpRequest();
    const formData = new FormData();
    formData.append('content', commentForm['content'].value);

    xhr.onreadystatechange = function () {
        if (xhr.readyState !== XMLHttpRequest.DONE) return;

        if (xhr.status < 200 || xhr.status >= 300) {
            alert('요청을 전송하는 도중 오류가 발생하였습니다. 잠시 후 다시 시도해 주세요.');
            return;
        }

        const responseObject = JSON.parse(xhr.responseText);
        switch (responseObject['result']) {
            case 'failure':
                alert('서버에서 댓글 작성을 처리하지 못했습니다. 오류 메시지: ' + responseObject['message']);
                break;
            case 'success':
                location.reload();
                break;
            default:
                alert('서버가 알 수 없는 응답을 반환하였습니다. 잠시 후 다시 시도해 주세요.');
        }
    };

    xhr.open('POST', '/comment/write');
    xhr.send(formData);

    return false;
};



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


