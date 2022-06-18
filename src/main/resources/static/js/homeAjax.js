$(document).ready(function(){
    loadDataLoaiSp(1);
    
     
});


 function loadDataLoaiSp(id){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/sanphamsDM/'+id,
        async: false,
        success: function(data){ 
            $('#loadlsp').empty();
            let saleText =''
            let res='';
            
            
            $.each(data, function(index, value){
                
                var donGiaKm;
                var dG;
                let className='';
                
                donGiaKm=value.donGia-value.donGia*value.khuyenMai;
                dG=value.donGia;
                let onSale='<span class="onsale">'+donGiaKm+'</span>';
                let donGia='<span id="was"  >$'+dG+'</span>';
                
                if(value.khuyenMai>0){
                    saleText ='<div class="sale-item icn">SALE</div>'
                }else{
                    saleText =''
                }
                if(saleText!=''){
                    onSale='<span class="onsale">$'+donGiaKm+'</span>';
                    className='was';

                }else{
                    onSale='';
                }
                
                res+=
                ' <div class="col-lg-3 col-md-6 col-sm-6">'+
                '<div class="product__item">'+
                saleText+
                    '<a  href="/sanpham/'+value.maSP+'" class="product__item__pic set-bg" style="display: block; background-image: url(' + value.hinhAnh + ');" data-setbg="'+value.hinhAnh+'">'+
                       ' <div class="product__label">'+
                            '<span>'+value.maLoaiSP.tenLoaiSP+'</span>'+
                        '</div>'+
                    '</a>'+
                    '<div class="product__item__text">'+
                        '<h6><a >'+value.tenSP+'</a></h6>'+
                        '<div class="product__item__price">'+
                        onSale+
                        '<span id="was" class="'+className+'">$'+dG+'</span>'+
                        '</div>'+
                        '<div class="cart_add">'+
                            '<a value="'+value.tenSP+'" id="addCart" href="/addCart/'+value.maSP+'" >Add to cart</a>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
            
            });
            
            $('#loadlsp').append(res);
            addToCart();
             
        }
    })

}

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
                    $('#numCart').text(index);
                    $('#totalCart').text(value);
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
