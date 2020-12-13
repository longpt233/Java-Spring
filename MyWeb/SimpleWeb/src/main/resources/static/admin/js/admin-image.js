$(document).ready(function () {


    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                // $('#preview-product-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }


    $("#add-product-image").change(function() {
        readURL(this);
        var formData = new FormData();
        formData.append('file', $("#add-product-image")[0].files[0]);
        axios.post("/api/upload", formData).then(function(res){

            if(res.data.success) {
                var dataProductImage = {};
                dataProductImage.productId = vm.productId;
                dataProductImage.link = res.data.link;
                axios.post("/api/images", dataProductImage).then(function(res){

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
                });
            }
        }, function(err){
            NProgress.done();
        });
    });

    $(".delete-image").on("click", function () {
        var id = $(this).attr("imageid");
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function (result) {
            if (result.value) {
                NProgress.start();
                var linkdelete = "/api/images/" + id;
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