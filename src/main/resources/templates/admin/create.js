$("#form-add-product").submit(function (event) {
    event.preventDefault(); // Không bị load lại trang
    $('[id^=error-add-]').text("");
    let title = $("#add_name").val();
    let price = $("#add_price").val();
    let discount = $("#add_discount").val();
    let quantity = $("#add_quantity").val();
    let image = "https://rohto.com.vn/images/2023/new-vrohto-20230612.jpg";
    let description = $("#add_description").val();
    let categoryid = $("#classIdSelect").val();
    const product = {
        name: title,
        price: price,
        quantity: quantity,
        image: image,
        description: description,
        categoryId: categoryid
    }
    debugger
    $.ajax({
        headers: {
            Accept: 'application/json', // Đặt kiểu dữ liệu được chấp nhận từ server là JSON.
            'Content-Type': 'application/json', // Đặt kiểu dữ liệu được gửi lên server là JSON.
        },
        type: 'POST',
        data: JSON.stringify(product),
        url: `https://medicine-w344.onrender.com/api/product`, // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
        success: function () {
            debugger
            $("#modal_add_product").modal("hide");
            displayProducts();
            $("input").val('');
            $(".toast_create").toast("show");
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
            console.error(status);
            console.error(error);
            debugger
        }
    });
})
