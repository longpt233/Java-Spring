$(document).ready(function() {

    var dataCategory = {};
    var cateid;

    //add

    $("#new-category").on("click", function () {
        dataCategory = {};
        $('#input-category-name').val("");
        $('#input-category-desc').val("");
        $("#modal-create-cate").modal();
    });

    $(".btn-save-category").on("click", function () {
        if($("#input-category-name").val() === "" || $("#input-category-desc").val() === "" ) {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return ;
        }


        dataCategory.name = $('#input-category-name').val();
        dataCategory.description = $('#input-category-desc').val();

        NProgress.start();
        var linkPost = "/api/categories";
        axios.post(linkPost, dataCategory).then(function(res){
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
                'Some error when saving category',
                'error'
            );
        })
    });

    //edit

    $(".btn-edit-cate").on("click", function () {
        var cate = $(this).attr("cateid");
        cateid = cate;
        NProgress.start();
        axios.get("/api/categories/" + cate).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('#input-cate-name-update').val(res.data.data.name);
                $('#input-cate-desc-update').val(res.data.data.description);
                $('#modal-update-cate').modal();
            }
        }, function(err){
            NProgress.done();
        })
    });

    $("#btn-update-cate").on("click", function () {
        dataCategory = {};
        if ($("#input-cate-name-update").val() === "" || $("#input-cate-desc-update").val() === "") {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return;
        }

        dataCategory.name = $('#input-cate-name-update').val();
        dataCategory.description = $('#input-cate-desc-update').val();
        NProgress.start();

        var linkPost = "/api/categories/" + cateid;

        axios.put(linkPost, dataCategory).then(function (res) {
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
                'Some error when updating cate',
                'error'
            );
        })
    })


    //delete
    $(".btn-delete-cate").on("click", function () {
        var id = $(this).attr("cateid");
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function (result) {
            if (result.value) {
                NProgress.start();
                var linkdelete = "/api/categories/" + id;
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
                        'Some error when deleting category',
                        'error'
                    );
                })
            }
        })
    });


});