<!DOCTYPE html>
<html lang="zxx">
<body>
    <?php include (APPPATH.'views/header.php') ?>  
<section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form sticky-top">
                            <form action="<?= base_url('index.php/IndexController/search');?>" method="post">
                                <!-- <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div> -->
                                <input type="text" class="searchTxt" placeholder="What do you need?" name="content" style="color: black;">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>0123456789</h5>
                                <span>Hỗ trợ: 24/7</span>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <section class="product spad" style="margin-top: -100px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Department</h4>
                            <ul>
                                <?php foreach ($CatalogList as $row) 
                                {
                                ?>
                                <li><a href="<?= base_url('index.php/IndexController/phanloai/');?><?=$row['loai_id']?>"><?=$row['loai_ten']?></a></li>                               
                                <?php } ?>
                            </ul>
                        </div>
                        
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">                   
                    <div class="filter__item">
               
                    </div>
                    <div class="row">
                        <?php
                    foreach ($ProductList as $row) 
                    {
                    ?>
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="<?= base_url('assets/img/product/')?><?=$row["sp_id"]?>.jpg">
                                    <ul class="product__item__pic__hover">
                                <li><a class ="checkInfo" anlong="<?=$row['sp_id']?>" style="cursor: pointer;"><i class="fa fa-info"></i></a></li>
                                <li><a class="addCart" anlong="<?=$row['sp_id']?>" style="cursor: pointer;"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a><?=$row['sp_ten']?></a></h6>
                                    <h5><?=number_format($row['sp_dongia'], 0, '', '.')?>đ</h5>
                                </div>
                            </div>
                        </div>
                        <?php } ?>                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="modal fade infoModal" id="infoModal" role="dialog" aria-hidden="true">
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
    <section class="product-details spad" style="margin-top: -40px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large productImg"
                                src="" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3 class="productName" anlong=""></h3>
                        <div class="product__details__price productPrice"></div>
                        <p class="productContent"></p>
                        <a style="color: white;cursor: pointer;" class="primary-btn addCart addCartModal" anlong="">ADD TO CARD</a>
                        
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
    <!-- Product Section End -->
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