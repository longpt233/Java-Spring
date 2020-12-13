$(document).ready(function() {

    var dataProduct = {};


    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                // $('#preview-product-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }


    $("#input-select-img-product").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#input-select-img-product")[0].files[0]);
        axios.post("/api/upload", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('.product-main-image').attr('src', res.data.link);
            }
        }, function(err){
            NProgress.done();
        });
    });



    $("#new-product").on("click", function () {
        dataProduct = {};
        $('#input-product-name').val("");
        $('#input-product-desc').val("");
        $("#input-product-category").val("");
        $("#input-product-price").val("");
        $('.product-main-image').attr('src', 'https://www.vietnamprintpack.com/images/default.jpg');
        $("#modal-create-product").modal();
    });

    $(".btn-save-product").on("click", function () {
        if($("#input-product-name").val() === "" || $("#input-product-desc").val() === "" || $("#input-product-price").val()==="") {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return;
        }


        dataProduct.name = $('#input-product-name').val();
        dataProduct.description = $('#input-product-desc').val();
        dataProduct.categoryId = $("#input-product-category").val();
        dataProduct.images = $('.product-main-image').attr('src');
        dataProduct.price = $("#input-product-price").val();
        NProgress.start();
        var linkPost = "/api/products";
        axios.post(linkPost, dataProduct).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Some error when saving product',
                'error'
            );
        })
    });


    $("#input-select-img-product-update").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#input-select-img-product-update")[0].files[0]);
        axios.post("/api/upload", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('.product-main-image').attr('src', res.data.link);
            }
        }, function(err){
            NProgress.done();
        });
    });


    $(".btn-edit-product").on("click", function () {
        var product = $(this).attr("prodid");
        prodid = product;
        console.log(product);
        NProgress.start();
        axios.get("/api/products/" + product).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $("#input-product-name-update").val(res.data.data.name);
                $("#input-product-desc-update").val(res.data.data.description);
                $("#input-product-category-update").val(res.data.data.categoryId);
                $("#input-product-price-update").val(res.data.data.price);
                if(res.data.data.images != null) {
                    $('.product-main-image').attr('src', res.data.data.images);
                }
                $("#modal-update-product").modal();
            }else {
                console.log("ahihi");
            }
        }, function(err){
            NProgress.done();
        })
    });

    $("#btn-update-product").on("click", function () {
        dataProduct ={};
        if($("#input-product-name-update").val() === "" || $("#input-product-desc-update").val() === "" || $("#input-product-category-update").val()==="") {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return;
        }

        dataProduct.name = $('#input-product-name-update').val();
        dataProduct.description = $('#input-product-desc-update').val();
        dataProduct.categoryId = $("#input-product-category-update").val();
        dataProduct.images = $('.product-main-image').attr('src');
        dataProduct.price = $("#input-product-price-update").val();
        NProgress.start();
        var linkPost = "/api/products/" + prodid;
        axios.put(linkPost, dataProduct).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Some error when saving product',
                'error'
            );
        })
    });

    $(".btn-delete-product").on("click", function () {
        var id = $(this).attr("prodid");
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function (result) {
            if (result.value) {
                NProgress.start();
                var linkdelete = "/api/products/" + id;
                axios.delete(linkdelete).then(function (res) {
                    NProgress.done();
                    if (res.data.success) {
                        swal(
                            'Good job!',
                            res.data.message,
                            'success'
                        ).then(function () {
                            location.reload();
                        });
                    } else {
                        swal(
                            'Error',
                            res.data.message,
                            'error'
                        );
                    }
                }, function (err) {
                    NProgress.done();
                    swal(
                        'Error',
                        'Some error when deleting product',
                        'error'
                    );
                })
            }
        })
    });

});