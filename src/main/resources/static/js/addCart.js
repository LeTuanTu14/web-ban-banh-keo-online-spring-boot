$(document).ready(function(){
    addToCart();
});

function addToCart(){
    $('.cart_add  #addCart').on('click', function(evt){
        evt.preventDefault();
        var href=$(this).attr('href');
        var name = $(this).attr('value');
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api'+href,
            data:{
                type:"ajax"
            },
            async: false,
            success: function (data) {
                console.log(data);
                if(data){
                $.each(data, function (index, value) {
                    num=index;
                    total=value;
                    $('#numCart').text(num);
                    $('#totalCart').text('$'+total);
                  });
                  Swal.fire({
                    // position: 'top-end',
                    icon: 'success',
                    title: 'Added '+name+' to cart',
                    showConfirmButton: false,
                    timer: 2000
                  })
                }
            },
            error: function (data) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Product is out of stock!',
                    showConfirmButton: false,
                    timer: 2000
                  })
            }
            
        })
    });
}