const deleteCommentButtons = document.querySelectorAll('.deleteButton');

deleteCommentButtons.forEach(deleteCommentButton => {
    deleteCommentButton.addEventListener('click', function() {
        if (!confirm('정말 댓글을 삭제할까요?')) {
            return;
        }

        const index = this.getAttribute('data-index'); // Get the index from data-index attribute

        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState !== XMLHttpRequest.DONE) {
                return;
            }
            if (xhr.status < 200 || xhr.status >= 300) {
                alert('삭제에 실패하였습니다. 다시 시도해 주세요.');
                return;
            }
            const responseObject = JSON.parse(xhr.responseText);
            switch (responseObject['result']) {
                case 'success':
                    location.reload(); // 삭제 성공 시 페이지 새로고침
                    break;
                case 'failure':
                    alert('삭제에 실패하였습니다. 다시 시도해 주세요.');
                    break;
                default:
                    alert('오류가 발생하였습니다. 잠시 후 다시 시도해 주세요.');
            }
        };

        xhr.open('DELETE', `/article/read?index=${index}`); // 수정된 URL 경로
        xhr.send();
    });
});
