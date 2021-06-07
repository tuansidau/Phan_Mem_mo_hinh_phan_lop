<?php
class IndexController extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('ProductModel');
		$this->load->model('InvoiceModel');
	}
	public function index()
	{
		$this->read();
	}
	public function read()
	{
		$ProductList = $this->ProductModel->read();
		$CatalogList = $this->ProductModel->readCatalog();
		$data = array(
			'ProductList' => $ProductList,
			'CatalogList' => $CatalogList,
			'controller' => $this
		);
		$this->load->view('IndexView', $data);
	}
	public function checkInfo()
	{
		$id = $this->input->post('id');
		$output = array();
		$data = $this->ProductModel->readInfoProduct($id);
		foreach ($data as $row) 
		{
			$output['sp_id'] = $row['sp_id'];
			$output['sp_ten'] = $row['sp_ten'];
			$output['sp_dongia'] = number_format($row['sp_dongia'], 0, '', '.')."đ";
			$output['sp_mota'] = $row['sp_mota'];
			$output['sp_tonkho'] = $row['sp_tonkho'];
		}

		echo json_encode($output);
	}
	public function history()
	{
		$data['InvoiceList'] = $this->InvoiceModel->read($this->session->userdata('idkh'));
		$this->load->view('history', $data);
	}
	public function historyDetail()
	{
		$id = $this->input->post('id');
		$data = $this->InvoiceModel->readDetail($id);
		foreach ($data as $row) 
		{
			$name = $this->InvoiceModel->readNameProduct($row['sp_id']);
			echo '
			<tr>
			<td class="shoping__cart__item">
                                        <img src="'.base_url('assets/img/product/').$row['sp_id'].'.jpg" alt="" style="max-width: 101px; max-height: 100px;">
                                        <h5>'.$name.'</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        '.number_format($row['ct_dongia'], 0, '', '.').'đ
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        '.$row['ct_soluong'].'
                                    </td>
                                    
                                    <td class="shoping__cart__total">
                                        '.number_format($row['ct_thanhtien'], 0, '', '.').'đ
                                    </td>
                                    </tr>                                               ';
		}
	}
	public function readShopDetail()
	{
		$ProductList = $this->ProductModel->read();
		$CatalogList = $this->ProductModel->readCatalog();
		$data = array(
			'ProductList' => $ProductList,
			'CatalogList' => $CatalogList
		);
		$this->load->view('shop-grid', $data);
	}
	public function phanloai($idloai)
	{
		$ProductList = $this->ProductModel->readProduct($idloai);
		$CatalogList = $this->ProductModel->readCatalog();
		$data = array(
			'ProductList' => $ProductList,
			'CatalogList' => $CatalogList
		);
		$this->load->view('shop-grid', $data);
	}
	public function search()
	{
		$content = $this->input->post('content');
		$ProductList = $this->ProductModel->search($content);
		$CatalogList = $this->ProductModel->readCatalog();
		$data = array(
			'ProductList' => $ProductList,
			'CatalogList' => $CatalogList
		);
		$this->load->view('shop-grid', $data);
	}
}
?>