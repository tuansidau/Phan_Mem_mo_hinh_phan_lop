<!DOCTYPE html>
<html lang="zxx">


<body>
    <!-- Header Section Begin -->
<?php include (APPPATH.'views/header.php') ?>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="latest-product__text">
                        <h4>Latest Update</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <?php for ($i = 0; $i < 3 ; $i++) 
                                { ?>
                                <a style="cursor: pointer;" class="latest-product__item checkInfo" anlong="<?=$ProductList[$i]['sp_id']?>">
                                    <div class="latest-product__item__pic">
                                        <img src="<?= base_url('assets/img/product/')?><?=$ProductList[$i]['sp_id']?>.jpg" alt="" style="max-width:110px; height: 110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6><?=$ProductList[$i]['sp_ten']?></h6>
                                        <span><?=number_format($ProductList[$i]['sp_dongia'], 0, '', '.')?>đ</span>
                                    </div>
                                </a>
                                <?php } ?>                             
                            </div>
                            <div class="latest-prdouct__slider__item">
                                <?php for ($i = 3; $i < 6 ; $i++) 
                                { ?>
                                <a style="cursor: pointer;" class="latest-product__item checkInfo" anlong="<?=$ProductList[$i]['sp_id']?>">
                                    <div class="latest-product__item__pic">
                                        <img src="<?= base_url('assets/img/product/')?><?=$ProductList[$i]['sp_id']?>.jpg" alt="" style="max-width:110px; height: 110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6><?=$ProductList[$i]['sp_ten']?></h6>
                                        <span><?=number_format($ProductList[$i]['sp_dongia'], 0, '', '.')?>đ</span>
                                    </div>
                                </a>
                                <?php } ?>
                            </div>
                        </div>
                    </div>
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
                    <div class="hero__item set-bg" data-setbg="<?= base_url('assets/img/hero/banner1.jpg');?>">
                        <div class="hero__text">
                            <span>BEST PRICE</span>
                            <h2>Gaming PC<br />100% Quality</h2>
                            <p style="color: orange">Free Delivery Available</p>
                            <div href="#" class="primary-btn">SHOP NOW</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <?php 
                    foreach ($ProductList as $row) 
                    {

                    ?>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="<?= base_url('assets/img/product/');?><?=$row['sp_id']?>.jpg">
                        </div>
                    </div>   
                    <?php } ?>                
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2 name="allProducts">All Products</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <?php foreach ($CatalogList as $row) 
                            {
                            ?>
                            <li class="loaiBtn" anlong="<?=$row['loai_id']?>"><?=$row['loai_ten']?></li>
                            <?php } ?>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter" id="productArea">
                    <?php
                    foreach ($ProductList as $row) 
                    {
                    ?>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="<?= base_url('assets/img/product/')?><?=$row["sp_id"]?>.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a class ="checkInfo" anlong="<?=$row['sp_id']?>" style="cursor: pointer;"><i class="fa fa-info"></i></a></li>
                                <li><a class="addCart" anlong="<?=$row['sp_id']?>" style="cursor: pointer;"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a><?=$row['sp_ten']?></a></h6>
                            <h5><?=number_format($row['sp_dongia'], 0, '', '.')?>đ</h5>
                        </div>
                    </div>
                    </div>
                <?php } ?>
            </div>
        </div>
    </section>
    <!-- Featured Section End -->
    <!-- modal info -->
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
                            <!-- end modal -->
    <!-- Latest Product Section End -->
    <button onclick="topFunction()" id="myBtn" title="Go to top">TOP</button>

    <!-- Footer Section Begin -->
    <footer class="footer spad" style="background-color: lightblue;">
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="<?= base_url('assets/js/jquery-3.3.1.min.js');?>"></script>
    <script src="<?= base_url('assets/js/bootstrap.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery.nice-select.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery-ui.min.js');?>"></script>
    <script src="<?= base_url('assets/js/jquery.slicknav.js');?>"></script>
    <script src="<?= base_url('assets/js/mixitup.min.js');?>"></script>
    <script src="<?= base_url('assets/js/owl.carousel.min.js');?>"></script>
    <script src="<?= base_url('assets/js/main.js');?>"></script>
<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>

<?php include (APPPATH.'controllers/AjaxController.php') ?>
</body>

</html>