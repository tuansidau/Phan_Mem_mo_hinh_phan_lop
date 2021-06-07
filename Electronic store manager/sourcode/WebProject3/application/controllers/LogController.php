<?php
class LogController extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('GuestModel');
	}
	public function index()
	{
		$this->read();
	}
	public function read()
	{
		$this->load->view('LogView');
	}
	public function login()
	{
		$email = $this->input->post('email');
		$pass = $this->input->post('pass');
		$rs = $this->GuestModel->readLogin($email, $pass);
		$id =  $this->GuestModel->getId($email);
		if(empty($rs))
		{
			echo "false";
		} else {
			$session_data = array(
				'email' => $email,
				'idkh' => $id 
			);
			$this->session->set_userdata($session_data);
		}
	}
	public function logout()
	{
		$session_data = array(
				'email' => "",
				'idkh' => ""
			);
		$this->session->set_userdata($session_data);
		//xoa gio hang
		$this->cart->destroy();
		redirect('index.php/IndexController/index');
	}
	public function checkInfo()
	{
		$temp = $this->input->post('id');
		$id = $this->session->userdata('idkh');
		$rs = $this->GuestModel->read($id);
		$data = array();
		foreach ($rs as $row) 
		{
				$data['email'] = $row['kh_email'];
				$data['ten'] = $row['kh_ten'];
				$data['pass'] = $row['kh_password'];
				$data['phone'] = $row['kh_sdt'];
				$data['address'] = $row['kh_diachi'];
				$data['joindate'] = $row['kh_joindate'];
		}
		echo json_encode($data);
	}
	public function updateGuest()
	{
		$ten = $this->input->post('ten');
		$pass = $this->input->post('pass');
		$phone = $this->input->post('phone');
		$diachi = $this->input->post('diachi');
		$id = $this->session->userdata('idkh');
		$data = array(
			'kh_ten' => $ten,
			'kh_password' => $pass,
			'kh_sdt' => $phone,
			'kh_diachi' => $diachi
		);
		$this->GuestModel->update($id, $data);
	}
	public function signup()
	{
		$result = $this->input->post();
		$rs = $this->GuestModel->readAll();
		$date = getdate();
		$today = $date['year']."-".$date['mon']."-".$date['mday'];
		foreach ($rs as $row) 
		{
			if($row['kh_email'] == $result['email'])
			{
				echo "false";
				$check = 0;
				break;
			} else {
				$check = 1;
			}
		}

		if($check != 0)
		{
			$data = array(
			'kh_ten' => $result['name'],
			'kh_password' => $result['pass'],
			'kh_sdt' => $result['phone'],
			'kh_diachi' => $result['address'],
			'kh_email' => $result['email'],
			'kh_joindate' => $today
			);

			$this->GuestModel->insert($data);

			$id =  $this->GuestModel->getId($result['email']);
			$session_data = array(
				'email' => $result['email'],
				'idkh' => $id 
			);
			$this->session->set_userdata($session_data);
		}
	}
}
?>