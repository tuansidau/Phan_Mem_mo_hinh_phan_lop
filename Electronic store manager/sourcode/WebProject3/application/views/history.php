<body>

<?php include (APPPATH.'views/header.php') ?>   
    <!-- Shoping Cart Section Begin -->
    <h2 style="text-align: center; margin-top: 50px;">Your Invoice History</h2>
    <section class="shoping-cart spad" style="margin-top: -50px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product"></th>
                                    <th class="shoping__product">Ngày đặt</th>
                                    <th class="shoping__product">Người nhận</th>
                                    <th class="shoping__product">Ngày giao</th>
                                    <th class="shoping__product">Nơi giao</th>
                                    <th class="shoping__product">Total</th>
                                    <th class="shoping__product">Status</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php 
                                $count = 1;
                                foreach ($InvoiceList as $row) {
                                 ?>
                                <tr>
                                    <td class="shoping__cart__item">
                                        <h5><?=$count++?></h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5><?=$row['hd_ngaylap']?></h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5><?=$row['hd_nguoinhan']?></h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5><?=$row['hd_ngaygiao']?></h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5><?=$row['hd_diachi']?></h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5><?= number_format($row['hd_total'], 0, '', '.')?>đ</h5>
                                    </td>
                                    <td class="shoping__cart__item">
                                        <h5 style="color: blue; font-weight: bold;">SUCCESS</h5>
                                    </td>
                                    <td class="shoping__cart__button" style="">
                                        <button style="background-color: lightblue; color: black; font-weight: bold;" class="infoInvoiceBtn" anlong="<?=$row['hd_id']?>"><span></span>Info</button>
                                    </td>
                                </tr>
                            <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- modal info -->
<div class="modal fade infoInvoiceModal" id="infoInvoiceModal" role="dialog" aria-hidden="true">
                            <div class="modal-dialog modal-dialog modal-lg">
                            <div class="modal-content">
        
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                              </button>
                            </div>
            
                            <div class="modal-body">
                              <!-- body -->
                                  <!-- Product Details Section Begin -->
<section class="shoping-cart spad" style="margin-top: -40px;">
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
                                </tr>
                            </thead>
                            <tbody id="infoInvoiceArea">
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
                              <!-- end body -->
                            </div>
            
                            <div class="modal-footer" style="margin-top: -100px;">
                              </div>
                            </div>
                            </div>
                            </div>
    <!-- Shoping Cart Section End -->
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