// article 객체 생성
var user = {
    // 초기화(이벤트 등록) 메소드
    init: function() {
        // 스코프 충돌 방지! (https://mobicon.tistory.com/189)
        var _this = this;
        // 버튼 선택
        const joinBtn = document.querySelector('#user-join-btn');
        const loginBtn = document.querySelector('#user-login-btn');


        // 버튼 클릭 시, 동작 할 메소드를 연결!
        if (joinBtn != null) { // createBtn이 있다면 수행!
            joinBtn.addEventListener('click', _this.join);
        }
        if (loginBtn != null) {
            loginBtn.addEventListener('click', _this.login);
        }
    },
    // article 생성 메소드
    join: function() {
        // form 데이터를 JSON으로 만듬
        var data = {
            id: document.querySelector('#user-id').value,
            pwd: document.querySelector('#user-pwd').value,
        };
        // 데이터 생성 요청을 보냄
        // fetch(URL, HTTP_REQUEST)
        fetch('/api/join', {
            method: 'POST', // POST 방식으로, HTTP 요청.
            body: JSON.stringify(data), // 위에서 만든 폼 데이터(data)를 함께 보냄.
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) { // 응답 처리!
            // 요청 성공!
            if (response.ok) {
                alert('success');
                window.location.href='/'; // 해당 URL로 브라우저를 새로고침!
            } else { // 요청 실패..
                alert('fail');
            }
        });
    },
    login: function() {
        // form 데이터를 JSON으로 만듬
        var data = {
            id: document.querySelector('#user-id').value,
            pwd: document.querySelector('#user-pwd').value,
        };
        // 데이터 생성 요청을 보냄
        // fetch(URL, HTTP_REQUEST)
        fetch('/api/login', {
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
                alert('fail');
            }
        });
    }
};
// 객체 초기화
user.init();
