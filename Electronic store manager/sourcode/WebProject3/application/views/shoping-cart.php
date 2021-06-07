<!DOCTYPE html>
<html lang="zxx">


<body>

<?php include (APPPATH.'views/header.php') ?>   
    <!-- Shoping Cart Section Begin -->
    <h2 style="text-align: center; margin-top: 50px;">Shoping Cart</h2>
    <section class="shoping-cart spad" style="margin-top: -50px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php foreach ($list as $row) {
                                ?>
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img src="<?= base_url('assets/img/product/')?><?=$row['id']?>.jpg" alt="" style="max-width: 101px; max-height: 100px;">
                                        <h5><?=$row['name']?></h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        <?= number_format($row['price'], 0, '', '.')?>đ
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty" >
                                                <input type="text" value="<?=$row['qty']?>" class="quantityTxt">
                                            </div>
                                        </div>
                                    </td>
                                    
                                    <td class="shoping__cart__total">
                                        <?= number_format($row['qty']*$row['price'], 0, '', '.')?>đ
                                    </td>
                                    <td class="shoping__cart__button" style="">
                                        <button style="background-color: lightblue; color: black; font-weight: bold;" class="updateCartBtn" anlong="<?=$row['rowid']?>" along="<?=$row['id']?>"><span class="icon_loading" ></span>Update</button>
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <a href="<?= base_url('index.php/CartController/delete/');?><?=$row['rowid']?>"><span class="icon_close"></span></a>
                                    </td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns" >
                        <a href="<?= base_url('index.php/IndexController/');?>" class="primary-btn cart-btn" style="background-color: lightgreen;">CONTINUE SHOPPING</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>Total <span><?= number_format($this->cart->total(), 0, '', '.')?>đ</span></li>
                        </ul>
                        <?php if($this->session->userdata('idkh') == "")
                        { ?>
                        <a class="primary-btn" style="cursor: pointer; color: white;" onclick="alert('Vui long dang nhap de co the thanh toan');">PROCEED TO CHECKOUT</a>
                        <?php } else if($this->cart->total_items() == 0){?>
                            <a style="cursor: pointer; color: white;" onclick="alert('Giỏ hàng rỗng');" class="primary-btn">PROCEED TO CHECKOUT</a>
                        <?php } else {?>
                            <a href="<?= base_url('index.php/CheckoutController/read');?>" class="primary-btn">PROCEED TO CHECKOUT</a>
                        <?php }?>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

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