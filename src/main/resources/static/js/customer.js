
$(window).on('load',function () {

    $('.tbody').children().on('click',function(){

        let id = $($(this).children()[0]).text();
        let name = $($(this).children()[1]).text();
        let address = $($(this).children()[2]).text();
        let contactNo = $($(this).children()[3]).text();

        $('#txtId').val(id)
        $('#txtName').val(name)
        $('#txtAddress').val(address)
        $('#txtContactNo').val(contactNo)

    })
})

