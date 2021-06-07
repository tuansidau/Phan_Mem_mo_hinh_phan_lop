<?php
class GuestModel extends CI_Model
{
	public function readAll()
	{
		$query = $this->db->query("SELECT * from sale_customer");
		return $query->result_array();
	}
	public function read($id)
	{
		$query = $this->db->query("SELECT * from sale_customer where kh_id = ".$id);
		return $query->result_array();
	}
	public function readLogin($email, $pass)
	{
		$query = $this->db->query('SELECT * from sale_customer where kh_email = "'.$email.'" and kh_password = "'.$pass.'"');
		return $query->result_array();
	}
	public function getId($email)
	{
			$query = $this->db->query("select * from sale_customer where kh_email= '".$email."'");
		$data = $query->result_array();
		$list = "";
		foreach ($data as $key) 
		{
			$list = $key['kh_id'];
		}
		return $list;			
	}
	public function update($id, $data)
	{
		$this->db->where('kh_id', $id);
		$this->db->update('sale_customer', $data);
	}
	public function insert($data)
	{
		$this->db->insert('sale_customer', $data);
	}
}
?>