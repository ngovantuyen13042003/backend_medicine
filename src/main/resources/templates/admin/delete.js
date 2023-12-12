let idDelete;
function comfirmDeleteProduct(id, name) {
    idDelete = id;
    $("#nameProduct").text(name);
}

function deleteProduct() {
    let product = {
        id: idDelete,
        ids: [idDelete]
    }
    $.ajax({
        headers: {
            Accept: 'application/json', // Đặt kiểu dữ liệu được chấp nhận từ server là JSON.
            'Content-Type': 'application/json', // Đặt kiểu dữ liệu được gửi lên server là JSON.
        },
        type: 'DELETE',
        data: JSON.stringify(product),
        url: 'https://medicine-w344.onrender.com/api/product',
        success: function () {
            $("#modal_delete_product").modal("hide");
            displayProducts();
            $(".toast_delete").toast("show");
        },
        error: function (error) {
            // Hàm này được gọi khi có lỗi trong quá trình gửi yêu cầu hoặc nhận phản hồi.
            // Biến 'error' chứa thông tin về lỗi, bạn có thể xử lý lỗi ở đây hoặc thông báo cho người dùng.
        }
    });
}