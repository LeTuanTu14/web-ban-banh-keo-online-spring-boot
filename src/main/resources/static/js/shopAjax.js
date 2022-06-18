$(document).ready(function(){
    
    var am=0;
    
    var idCategory=0;
    var txt='';
    // var num=0;
    // var total=0.0;
    // $('#numCart').text(num);
    // $('#totalCart').text('$'+total);
    loadMoreSP(0);
    selectCategory();
    clickLoadMoreSP(am);

    $('#inputSearch').change(function(){
        txt = $(this).val(); 
        console.log(txt);
        search(txt);
    });
    // addToCart();
});


function loadMoreSP(amount) {
    am = $('.lenPro').length;
    $.ajax({
  
        type: 'GET',
        url: 'http://localhost:8080/api/moresanphams/' + amount,
        async: false,
        success: function (data) {
    
            if(data.length==0){
                $('#loadNext').text('End Products');
            }
            
            let res='';
            let saleText =''
            $.each(data, function(index, value){
                var donGiaKm;
                var dG;
                let className='';
                idCategory=value.maLoaiSP.maLoaiSP;
                donGiaKm=value.donGia-value.donGia*value.khuyenMai;
                dG=value.donGia;
                var dgThat=dG/(1 - value.khuyenMai);
                console.log(dG);
                let onSale='<span class="onsale">'+donGiaKm+'</span>';
                let donGia='<span id="was"  >$'+dG+'</span>';
                
                if(value.khuyenMai>0){
                    saleText ='<div class="sale-item icn">SALE</div>'
                }else{
                    saleText =''
                }
                if(saleText!=''){
                    onSale='<span class="onsale">$'+dG+'</span>';
                    className='was';

                }else{
                    onSale='';
                }
                res+=
                ' <div  class="lenPro col-lg-3 col-md-6 col-sm-6">'+
                '<div class="product__item">'+
                saleText+
                    '<a href="/sanpham/'+value.maSP+'" class="product__item__pic set-bg" style="display: block; background-image: url(' + value.hinhAnh + ');" data-setbg="'+value.hinhAnh+'">'+
                       ' <div class="product__label">'+
                            '<span>'+value.maLoaiSP.tenLoaiSP+'</span>'+
                        '</div>'+
                    '</a>'+
                    '<div class="product__item__text">'+
                        '<h6><a >'+value.tenSP+'</a></h6>'+
                        '<div class="product__item__price">'+
                        onSale+
                        '<span id="was" class="'+className+'">$'+dgThat+'</span>'+
                        '</div>'+
                        '<div class="cart_add">'+
                            '<a value="'+value.tenSP+'" id="addCart" href="/addCart/'+value.maSP+'"  >Add to cart</a>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
            //  var c =$('#addCart').text();
            // console.log(c);
            
            });
            $('#loadMoreSP').append(res);
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


function loadDataLoaiSp(id){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/sanphamsDM/'+id,
        success: function(data){ 
            // $('#loadMoreSP').empty();
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
                ' <div class=" lenPro col-lg-3 col-md-6 col-sm-6">'+
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
                            '<a href="#">Add to cart</a>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
            
            });
            
            $('#loadMoreSP').append(res);
            
             
        }
    })

}

function selectCategory(){
    $('.shop__option__search  .list li' ).click(function() {
        idCategory= $(this).attr('data-value');
        if(idCategory!=0){
            $('#loadMoreSP').empty();
            loadDataLoaiSp(idCategory);
            $('#loadNext').hide();
        }else
        {   $('#loadMoreSP').empty();
            am=0;
            loadMoreSP(am)
            
            $('#loadNext').show().text('Load More');

        }
        
    });
}
function clickLoadMoreSP(){
    $('#loadNext').click(function(){
        am=am+12;
        console.log(am);
        loadMoreSP(am);
       
    });
}

function search(txtSearch){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/sanphamsName/' + txtSearch,
        success: function (data) {
            let noData=
            '<div class="nodata-message">'+
                '<p>'+
                    '<em>Sorry, no products matched the keyword:'+txtSearch+'</em>'+
                '</p>'+
            '</div>';
            $('#loadMoreSP').empty();
            if(data.length==0){
                $('#loadMoreSP').append(noData);
            }
            else{
            
            $('#loadNext').hide();
            let res='';
            let saleText =''
            $.each(data, function(index, value){
                var donGiaKm;
                var dG;
                let className='';
                idCategory=value.maLoaiSP.maLoaiSP;
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
                ' <div  class="lenPro col-lg-3 col-md-6 col-sm-6">'+
                '<div class="product__item">'+
                saleText+
                    '<a href="/sanpham/'+value.maSP+'" class="product__item__pic set-bg" style="display: block; background-image: url(' + value.hinhAnh + ');" data-setbg="'+value.hinhAnh+'">'+
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
                            '<a href="#">Add to cart</a>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
            
            });
            $('#loadMoreSP').append(res);
        }
        }
    })
}

