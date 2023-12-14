function viewDetail(id) {
    $.ajax({
        type: 'GET', // Sử dụng phương thức GET để yêu cầu dữ liệu từ server.
        url: `https://medicine-w344.onrender.com/api/product?id=${id}`, // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
        success: function (data) {
            let product = data[0];
            debugger

            $("#image_detail").attr("src", `${product.image}`);
            $("#id_detail").text(product.id);
            $("#title_detail").text(product.name);
            $("#price_detail").text(product.price + " VNĐ");
            $("#discount_detail").text(product.price * 0.3 + " VNĐ");
            $("#quantity_detail").text(product.quantity + " cái");
            $("#category_detail").text("Thuốc tây");
            $("#description_detail").text(product.description);
        },
        error: function (error) {
        }
    });
}