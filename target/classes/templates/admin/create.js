// $("#form-add-product").submit(function (event) {
//     event.preventDefault(); // Không bị load lại trang
//     $('[id^=error-add-]').text("");
//     let title = $("#add_name").val();
//     let price = $("#add_price").val();
//     let discount = $("#add_discount").val();
//     let quantity = $("#add_quantity").val();
//     let image = $("#add_image").attr('src');
//     let description = $("#add_description").val();
//     let categoryid = $("#classIdSelect").val();
//     const product = {
//         name: title,
//         price: price,
//         quantity: quantity,
//         image: image,
//         description: description,
//         categoryId: categoryid
//     }
//     debugger
//     $.ajax({
//         headers: {
//             Accept: 'application/json', // Đặt kiểu dữ liệu được chấp nhận từ server là JSON.
//             'Content-Type': 'application/json', // Đặt kiểu dữ liệu được gửi lên server là JSON.
//         },
//         type: 'POST',
//         data: JSON.stringify(product),
//         url: `https://medicine-w344.onrender.com/api/product`, // Đây là địa chỉ của API hoặc trang web bạn muốn tương tác.
//         success: function () {
//             debugger
//             $("#modal_add_product").modal("hide");
//             displayProducts();
//             $("input").val('');
//             $(".toast_create").toast("show");
//         },
//         error: function (xhr, status, error) {
//             console.error(xhr.responseText);
//             console.error(status);
//             console.error(error);
//             debugger
//         }
//     });
// })


$("#form-add-product").submit(function (event) {
    event.preventDefault();
    $('[id^=error-add-]').text("");

    // Tạo đối tượng FormData để đóng gói dữ liệu form
    let formData = new FormData();

    formData.append("name", $("#add_name").val());
    formData.append("price", $("#add_price").val());
    formData.append("discount", $("#add_discount").val());
    formData.append("quantity", $("#add_quantity").val());
    formData.append("description", $("#add_description").val());
    formData.append("categoryId", $("#classIdSelect").val());

    // Lấy file ảnh từ input và thêm vào FormData
    let imageInput = $("#add_image")[0];
    if (imageInput.files.length > 0) {
        formData.append("image", imageInput.files[0]);
    }
    formData.append("Content-Type", "multipart/form-data");

    console.log(formData);

    $.ajax({
        headers: {
            Accept: 'application/json',
        },
        type: 'POST',
        data: formData,
        processData: false,  // Không xử lý dữ liệu FormData
        contentType: false,  // Không đặt kiểu dữ liệu
        url: `https://medicine-w344.onrender.com/api/product`,
        success: function () {
            $("#modal_add_product").modal("hide");
            displayProducts();
            $("input").val('');
            $(".toast_create").toast("show");
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
            console.error(status);
            console.error(error);
        }
    });
});
