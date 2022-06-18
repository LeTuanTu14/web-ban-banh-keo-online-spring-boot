$(document).ready(function(){
    // var elements = document.getElementsByClassName("inc");
    // for (var i = 0; i < elements.length; i++) {
    //     elements[i].addEventListener("click", function() {
    //         var elements2 = document.getElementsByClassName("qtyIn");
    //         for (var j = 0; j < elements2.length; j++) {
    //             var val = elements2[j].getAttribute("value");
    //             console.log(val);
    //         }
    //     });
    // }    
    deleteCart();
});

function deleteCart(){
    $('.cart__close #removeCart').on('click', function(evt){
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
                if(data=="OK"){
                // $.each(data, function (index, value) {
                //     num=index;
                //     total=value;
                //     $('#numCart').text(num);
                //     $('#totalCart').text(total);
                //   });
                  Swal.fire({
                    // position: 'top-end',
                    icon: 'success',
                    title: 'Deleted '+name+' to cart',
                    showConfirmButton: false,
                    timer: 2000
                  })
                  setTimeout(function(){
                    location.reload();
                  }, 2000);
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