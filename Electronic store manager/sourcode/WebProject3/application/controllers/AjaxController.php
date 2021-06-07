<script src="https://code.jquery.com/jquery-latest.js"></script>
<base href="http://localhost/Nam/WebProject3/">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script>
	$(document).ready(function()
	{
        //add cart
        $(".addCart").click(function()
        {
            var id = $(this).attr("anlong");
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/CartController/insert",
                    method:"POST",
                    data: {"id" : id},
                    success: function(data)
                    {
                        alert(data);
                    }
                });
        });
		//so luong gio hang
        $(".updateCartBtn").click(function()
        {
            var rowid = $(this).attr("anlong");
            var id = $(this).attr("along");
            var qty = $('.quantityTxt').val();
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/CartController/update",
                    method:"POST",
                    data: {"rowid" : rowid, "id" : id, "qty" : qty},
                    success: function(data)
                    {
                        if(data == "false")
                        {
                            alert("Tồn kho không đủ");
                        } else {
                            location.reload();
                        }
                    }
                });
        });
		//check info
        $(".checkInfo").click(function()
        {
            var id = $(this).attr("anlong");
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/IndexController/checkInfo",
                    method:"POST",
                    data: {"id" : id},
                    dataType: 'json',
                    success: function(data)
                    {
                    	var imgPath = "./assets/img/product/"+id+".jpg";
                    	$('.productImg').attr("src", imgPath);
                            $('.infoModal').modal('show');
                            $('.productName').html(data.sp_ten);
                            $('.addCartModal').attr("anlong", id);
                            $('.productPrice').html(data.sp_dongia);
                            $('.productContent').html(data.sp_mota);
                            $('#hopdemso').val("1");
                            //$('.productImg').attr("img", imgPath);

                    }
                });
        });

        //sign in
        $(".signinbtn").click(function()
        {
            var email = $('#emailDangnhap').val();
            var pass = $('#passDangnhap').val();
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/LogController/login",
                    method:"POST",
                    data: {"email" : email, "pass" : pass},
                    success: function(data)
                    {
                        if(data == "false")
                        {
                            $('.loginErr').html("Email hoặc Pass không đúng");
                        } else {
                            location.replace("<?= base_url()?>index.php/IndexController/read");
                        }
                    }
                });
        });
        //sign up
        $(".signupbtn").click(function()
        {
            var name = $('#signupName').val();
            var pass = $('#signupPass').val();
            var phone = $('#signupPhone').val();
            var address = $('#signupAddress').val();
            var email = $('#signupEmail').val();
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/LogController/signup",
                    method:"POST",
                    data: {"name" : name, "pass" : pass, "phone" : phone, "address" : address, "email" : email},
                    success: function(data)
                    {
                        if(data == "false")
                        {
                            $('#emailErr').html("  Email này đã có người sử dụng");
                        } else {
                            location.replace("<?= base_url()?>index.php/IndexController/read");
                        }
                    }
                });
        });
        //update guest info
        $(".updateGuestInfo").click(function()
        {
            var ten = $('#tenhientai').val();
            var pass = $('#passhientai').val();
            var phone = $('#sdthientai').val();
            var diachi = $('#diachihientai').val();
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/LogController/updateGuest",
                    method:"POST",
                    data: {"ten" : ten, "pass" : pass, "phone" : phone, "diachi" : diachi},
                    success: function(data)
                    {
                        alert("Update thanh cong");
                        location.replace("<?= base_url()?>index.php/IndexController/read");
                    }
                });
        });
        //modal guest info
        $(".infoGuestBtn").click(function()
        {
            var id = 1;
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/LogController/checkInfo",
                    method:"POST",
                    data: {"id" : id},
                    dataType: 'json',
                    success: function(data)
                    {
                        $('.infoGuestModal').modal('show');
                        $('#tenhientai').val(data.ten);
                        $('#emailhientai').val(data.email);
                        $('#passhientai').val(data.pass);
                        $('#sdthientai').val(data.phone);
                        $('#diachihientai').val(data.address);
                        $('#ngaygianhap').val(data.joindate);
                    }
                });
        });
        //order btn
        $(".orderBtn").click(function()
        {
            if($('#diachinhanTxt').val() == "")
            {
                $('#diachiErr').html("Chua nhap dia chi nhan hang");
            } else 
            {
                var diachi = $('#diachinhanTxt').val();
                var nguoinhan = $('#nguoinhanTxt').val();
                var ghichu = $('#ghichuTxt').val();

                $.ajax(
                {
                    url:"<?= base_url()?>index.php/CheckoutController/insert",
                    method:"POST",
                    data: {"diachi" : diachi, "nguoinhan" : nguoinhan, "ghichu" : ghichu},
                    success: function(data)
                    {
                        alert("Đặt hàng thành công");
                        location.replace("<?= base_url()?>index.php/IndexController/read");
                    }
                });
            }
        });
        //info history
        $(".infoInvoiceBtn").click(function()
        {
            var id = $(this).attr("anlong");
            $.ajax(
                {
                    url:"<?= base_url()?>index.php/IndexController/historyDetail",
                    method:"POST",
                    data: {"id" : id},
                    success: function(data)
                    {
                        $('.infoInvoiceModal').modal('show');
                        $('#infoInvoiceArea').html(data);
                    }
                });
        });
    });
</script>
  