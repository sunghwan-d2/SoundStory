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


