<!DOCTYPE html>
<html lang="zxx">
<body>
    <?php include (APPPATH.'views/header.php') ?>
    
    

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <h4>Invoice Details</h4>
                <form action="#">
                    <div class="row">
                        <div class="col-lg-7 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Tên người đặt<span></span></p>
                                        <input style="color: black;" type="text" readonly value="<?=$kh_ten?>">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Điện thoại<span></span></p>
                                        <input style="color: black;" type="text" readonly value="<?=$kh_sdt?>">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Địa chỉ nhận hàng<span>*</span> <span id="diachiErr"></span></p>
                                <input type="text" placeholder="Address" class="checkout__input__add" style="color: black;" id="diachinhanTxt" value="<?=$kh_diachi?>">
                            </div>
                            <div class="checkout__input">
                                <p>Tên người nhận hàng<span></span></p>
                                <input type="text" style="color: black;" id="nguoinhanTxt">
                            </div>
                            <div class="checkout__input">
                                <p>Ghi chú (Nếu có)<span></span></p>
                                <input type="text" id="ghichuTxt">
                            </div>
                            
                        </div>
                        <div class="col-lg-5 col-md-6">
                            <div class="checkout__order">
                                <h4>Your Order</h4>
                                <div class="checkout__order__products">Products <span>Total</span></div>
                                <ul>
                                    <?php 
                                    foreach ($CartList as $row) {

                                    ?>
                                    <li><?=$row['name']?> 
                                        <span><?= number_format($row['qty']*$row['price'], 0, '', '.')?>đ</span></li>
                                    <?php }?>
                                </ul>
                                <div class="checkout__order__total">Total <span><?= number_format($this->cart->total(), 0, '', '.')?>đ</span></div>
                                <button type="button" class="site-btn orderBtn">PLACE ORDER</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
<footer class="footer spad" style="background-color: lightblue;">
    </footer>
    <!-- Footer Section End -->
<?php include (APPPATH.'controllers/AjaxController.php') ?>
    <!-- Js Plugins -->
    <script src="<?= base_url('assets/js/jquery-3.3.1.min.js');?>"></script>
    <script src="<?= base_url('assets/js/bootstrap.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery.nice-select.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery-ui.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery.slicknav.js');?>"></script>
    <script src="<?= base_url('assets/js/mixitup.min.js');?>"></script>
    <script src="<?= base_url('assets/js/owl.carousel.min.js');?>"></script>
    <script src="<?= base_url('assets/js/main.js');?>"></script>

 

</body>

</html>