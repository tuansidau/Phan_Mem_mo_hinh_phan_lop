<?php
class CartController extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('ProductModel');
	}
	public function index()
	{
		$this->readCart();
	}

	public function readCart()
	{
		$data['list'] = $this->cart->contents();
		$this->load->view('shoping-cart', $data);
	}
	public function insert()
    {
    	$id = $this->input->post('id');
    	$list = array();
    	$ProductList = $this->ProductModel->read();
    	foreach ($ProductList as $key) 
    	{
    		if($key['sp_id'] == $id)
    		{
    			$list['id'] = $id;
    			$list['name'] = $key['sp_ten'];
    			$list['qty'] = 1;
    			$list['price'] = $key['sp_dongia'];
    			break;
    		}
    	}
		$this->cart->insert($list);
		echo "Thêm thành công";
    }
    public function delete($rowid)
    {
        $this->cart->update(array('rowid' => $rowid, 'qty' => 0));
        //load lai trang
        redirect("index.php/CartController/index");
    }
    public function update()
    {
    	$rowid = $this->input->post('rowid');
    	$id = $this->input->post('id');
    	$qty = $this->input->post('qty');
    	$ProductList = $this->ProductModel->read();
    	foreach ($ProductList as $key) 
    	{
    		if($key['sp_id'] == $id)
    		{
    			if($key['sp_tonkho'] < $qty)
    			{
    				echo "false";
    			} else {
    				$this->cart->update(array('rowid' => $rowid, 'qty' => $qty));
    				echo "true";
    			}
    		}
    	}
    }
    public function deleteAll()
   	{
        $this->cart->destroy();
    }
}
?>