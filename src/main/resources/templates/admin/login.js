$("#form-login").submit(function (event) {
    event.preventDefault();
    const usernameOrEmail = $("#username").val();
    const password = $("#password").val();
    // Add vào list
    const user = {
        email: usernameOrEmail,
        password: password
    };

    $.ajax({
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'POST', // Sử dụng phương thức POST để gửi dữ liệu lên server.
        data: JSON.stringify(user), // Chuyển đổi đối tượng 'student' thành chuỗi JSON để gửi lên server.
        url: `https://medicine-w344.onrender.com/api/user/login`, // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
        success: function (data) {
            debugger
            // if (data.id == 1) {
            localStorage.setItem('roleList', data.name);

            window.location.href = "index.html";
            // } else {
            //     window.location.href = "acessdined";
            // }
        },
        error: function (error) {
            if(error.status == 500) {
                $('#error-message').text('Thông tin đăng nhập chưa chính xác');
            } else {
                $('#error-message').text('Hệ thống đang gặp lỗi, xin thử lại sau!');
            }
        }
    });
});

function displayRolelist() {
    if (localStorage.getItem("roleList")) {
        $("#role").text(localStorage.getItem("roleList"));
        debugger
    }
}