    <head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Web | SGU</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<?= base_url('assets/css/bootstrap.min.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/font-awesome.min.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/elegant-icons.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/nice-select.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/jquery-ui.min.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/owl.carousel.min.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/slicknav.min.css');?>" type="text/css">
    <link rel="stylesheet" href="<?= base_url('assets/css/style.css');?>" type="text/css">
    <style>
body {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
}

#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: lightblue;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 10px;
  font-weight: bold;
}

#myBtn:hover {
  background-color: #555;
}
</style>
</head>
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href=""><img src="<?= base_url('assets/img/logo.png');?>"></a>
                    </div>
                </div>
                <div class="col-lg-4">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="<?= base_url('index.php/IndexController/');?>">Home</a></li>
                            <li style="cursor: pointer;"><a href="<?= base_url('index.php/IndexController/readShopDetail');?>">SHOP</a></li>
                            <?php if($this->session->userdata('email') != "")
                            {?>
                            <li style="cursor: pointer;"><a href="<?= base_url('index.php/IndexController/history');?>">History</a></li>
                        <?php } ?>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-5">
                    <div class="header__cart">
                        <ul>
                            <?php if($this->session->userdata('email') == "")
                            {?>
                            <li><div class="header__top__right__auth">
                            <a href="<?= base_url('index.php/LogController/');?>"><i class="fa fa-user"></i> Login</a>
                            </div></li>
                        <?php } else {?>
                            <li style="border: 2px solid black; padding: 3px;"><div class="header__top__right__auth">
                            <a style="cursor: pointer;" class="infoGuestBtn"><i class="fa fa-user"></i><?=$this->session->userdata('email')?></a>
                            </div></li>
                        <?php }?>
                            <li><a href="<?= base_url('index.php/CartController/readCart');?>"><i class="fa fa-shopping-bag"></i> <span><?=$this->cart->total_items()?></span></a></li>
                        </ul>
                        <div class="header__cart__price">Total: <span><?= number_format($this->cart->total(), 0, '', '.')?>đ</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
        <!-- modal info -->
<div class="modal fade infoGuestModal" id="infoGuestModal" role="dialog" aria-hidden="true">
                            <div class="modal-dialog modal-dialog">
                            <div class="modal-content">
        
                            <div class="modal-header">
                              <h4>Your Information</h4>
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
                <div class="col-lg-12 col-md-12">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Your Name<span></span></p>
                                        <input id="tenhientai" style="color: black;" type="text" value="">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone</p>
                                        <input id="sdthientai" style="color: black;" type="text" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Email</p>
                                <input type="text" placeholder="Address" class="checkout__input__add" style="color: black;" id="emailhientai" value="" readonly>
                            </div>
                            <div class="checkout__input">
                                <p>Address</p>
                                <input type="text" placeholder="Address" class="checkout__input__add" style="color: black;" id="diachihientai" value="">
                            </div>
                            <div class="checkout__input">
                                <p>Password<span></span></p>
                                <input type="text" style="color: black;" id="passhientai" value="">
                            </div>
                            <div class="checkout__input">
                                <p>Join Date<span></span></p>
                                <input style="color: black;" type="text" id="ngaygianhap" value="" readonly>
                            </div>
                            
                        </div>
                      </div>
                      <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="product__details__text">
                      <a style="cursor: pointer;color: white;" class="primary-btn updateGuestInfo" anlong="">UPDATE</a>
                        <a href="<?= base_url('index.php/LogController/logout');?>" class="primary-btn" anlong="">LOG OUT</a>
                        
                    </div>
                </div>

            </div>
        </div>
    </section>
                              <!-- end body -->
                            </div>
            
                            <!-- <div class="modal-footer" style="margin-top: -100px;">
                              </div> -->
                            </div>
                            </div>
                            </div>