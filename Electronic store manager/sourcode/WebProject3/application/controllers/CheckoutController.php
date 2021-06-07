<?php
class CheckoutController extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('InvoiceModel');
		$this->load->model('GuestModel');
	}
	public function index()
	{
		$this->read();
	}

	public function read()
	{
		$CartList = $this->cart->contents();
		$id = $this->session->userdata('idkh');
		$rs = $this->GuestModel->read($id);
		$data['CartList'] = $CartList;
		foreach ($rs as $row) 
		{
			$data['kh_ten'] = $row['kh_ten'];
			$data['kh_sdt'] = $row['kh_sdt'];
			$data['kh_diachi'] = $row['kh_diachi'];
		}
		$this->load->view('checkout', $data);
	}
	public function insert()
	{
		$diachi = $this->input->post('diachi');
		$nguoinhan = $this->input->post('nguoinhan');
		$ghichu = $this->input->post('ghichu');

		$date = getdate();
		$today = $date['year']."-".$date['mon']."-".$date['mday'];

		$ngaygiao = Date('20y-m-d', strtotime('+3 days'));

		$total = $this->cart->total();
		$hdid = $this->nextId();
		$invoice = 
		array(
			'hd_id' => $hdid,
        	'hd_ngaylap' => $today,
        	'kh_id' => $this->session->userdata('idkh'),
        	'hd_nguoinhan' => $nguoinhan,
        	'hd_diachi' => $diachi,
        	'hd_ghichu' => $ghichu,
        	'hd_ngaygiao' => $ngaygiao,
        	'hd_total' => $total,
        	'hd_status' => 1
    	);
		$this->InvoiceModel->insert($invoice);

		//chitiethoadon
		$CartList = $this->cart->contents();
		foreach ($CartList as $row) 
		{
			$temp =
			array(
			'hd_id' => $hdid,
        	'sp_id' => $row['id'],
        	'ct_dongia' => $row['price'],
        	'ct_soluong' => $row['qty'],
        	'ct_thanhtien' => $row['qty']*$row['price']
    		);
    		$this->InvoiceModel->insertDetail($temp);
		}
	}
	public function nextId()
	{
		$data = $this->InvoiceModel->readNextId();
		return (int)$data + 1;
	}
}
?>