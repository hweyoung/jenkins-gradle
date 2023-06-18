// article 객체 생성
var article = {
    // 초기화(이벤트 등록) 메소드
    init: function() {
        // 스코프 충돌 방지! (https://mobicon.tistory.com/189)
        var _this = this;
        // 버튼 선택
        const createBtn = document.querySelector('#post-create-btn');
        const deleteBtn = document.querySelector('#post-delete-btn');

        // 버튼 클릭 시, 동작 할 메소드를 연결!
        if (createBtn != null) { // createBtn이 있다면 수행!
            createBtn.addEventListener('click', _this.create);
        }
        if (deleteBtn) { // destroyBtn이 있다면 수행!
            deleteBtn.addEventListener('click', _this.delete);
        }
    },
    // article 생성 메소드
    create: function() {

        // form 데이터를 JSON으로 만듬
        var data = {
            title: document.querySelector('#post-title').value,
            content: document.querySelector('#post-content').value,
        };
        // 데이터 생성 요청을 보냄
        // fetch(URL, HTTP_REQUEST)
        fetch('/api/post/create', {
            method: 'POST', // POST 방식으로, HTTP 요청.
            body: JSON.stringify(data), // 위에서 만든 폼 데이터(data)를 함께 보냄.
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) { // 응답 처리!
            // 요청 성공!
            if (response.ok) {
                alert('success');
                window.location.href='/page'; // 해당 URL로 브라우저를 새로고침!
            } else { // 요청 실패..
                alert('Login and try');
                window.location.href='/';
            }
        });
    },
    // article 삭제 메소드
    delete: function() {
        // url에서 id를 추출!
        var split = location.pathname.split('/');
        var id = split[split.length - 1];
        // 데이터 삭제 요청을 보냄
        // fetch(URL, HTTP_REQUEST)
        fetch('/api/post/' + id, {
            method: 'GET', // DELETE 방식! HTTP 요청.
        }).then(function(response) { // 응답 처리!
            // 요청 성공!
            if (response.ok) {
                alert('success');
                window.location.href='/page'; // 목록 페이지로 이동!(리다이렉트)
            } else { // 요청 실패..
                alert('fail');
                // window.location.href='/';
            }
        });
    }
};
// 객체 초기화
article.init();
