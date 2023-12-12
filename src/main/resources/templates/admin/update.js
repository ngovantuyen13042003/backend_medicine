let idUpdate;
function comfirmUpdateProduct(id) {
    idUpdate = id;
    debugger
    $('[id^=error-update-]').text("");
    debugger
    $.ajax({
        type: 'GET', // Sử dụng phương thức GET để yêu cầu dữ liệu từ server.
        url: `https://medicine-w344.onrender.com/api/product?id=${id}`, // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
        success: function (data) {
            const product = data[0];
            debugger
            $("#update_title").val(product.name);
            $("#update_price").val(product.price);
            $("#update_image_raw").attr("src", `${product.image}`);
            $("#update_discount").val(product.price * 0.7);
            $("#update_quantity").val(product.quantity);
            $("#update_description").val(product.description);
        },
        error: function (error) {
        }
    });
}

function updateProduct() {
    let name = $("#update_title").val();
    let price = $("#update_price").val();
    let discount = $("#update_discount").val();
    let quantity = $("#update_quantity").val();
    let image = "https://giadinh.mediacdn.vn/296230595582509056/2023/3/15/bao-cao-su-5--1678854218558912776621.jpg";
    let description = $("#update_description").val();
    debugger
    const product = {
        id: idUpdate,
        name: name,
        price: price,
        quantity: quantity,
        image: image,
        description: description,
        categoryId: "1"
    }
    $.ajax({
        headers: {
            Accept: 'application/json', // Đặt kiểu dữ liệu được chấp nhận từ server là JSON.
            'Content-Type': 'application/json', // Đặt kiểu dữ liệu được gửi lên server là JSON.
        },
        type: 'PUT',
        data: JSON.stringify(product),
        url: 'https://medicine-w344.onrender.com/api/product',
        success: function () {
            debugger
            $("#modal_update_product").modal("hide");
            displayProducts();
            $("input").val("");
            $(".toast_update").toast("show");
        },
        error: function (error) {
        }
    });
}