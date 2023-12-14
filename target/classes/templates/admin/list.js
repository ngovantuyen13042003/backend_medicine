function displayProducts() {
    console.log("aaa");
    debugger
    $.ajax({
        type: 'GET', // Sử dụng phương thức GET để yêu cầu dữ liệu từ server.
        url: "https://medicine-w344.onrender.com/api/product", // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
        success: function (data) {
            console.log(data)
            let products = data;
            let tableContent = ``;
            debugger
            products.forEach((product, index) => {
                tableContent += `<tr><th scope="row">${index + 1}</th>
                                    <td>${product.name}</td>
                                    <td>${product.price}</td>
                                    <td>${product.quantity}</td>
                                    <td><img src="${product.image}" width="100" height="100"></td>
                                    <td>Thuốc tây</td>
                                    <td>
                                        <button type="button" onclick="comfirmUpdateProduct(${product.id})" data-bs-toggle="modal" data-bs-target="#modal_update_product" class="btn btn-info">Chỉnh sửa</button>
                                        <button type="button" onclick="viewDetail(${product.id})" data-bs-toggle="modal" data-bs-target="#modal_detail_product" class="btn btn-warning">Chi tiết</button>
                                        <button type="button" onclick="comfirmDeleteProduct(${product.id}, '${product.name}')" data-bs-toggle="modal" data-bs-target="#modal_delete_product" class="btn btn-danger" >Xóa</button>
                                    </td> </tr>`
            });
            $("#productList_content").html(tableContent);
        },
        error: function (error) {
            // Hàm này được gọi khi có lỗi trong quá trình gửi yêu cầu hoặc nhận phản hồi.
            // Biến 'error' chứa thông tin về lỗi, bạn có thể xử lý lỗi ở đây hoặc thông báo cho người dùng.
        }
    });
}