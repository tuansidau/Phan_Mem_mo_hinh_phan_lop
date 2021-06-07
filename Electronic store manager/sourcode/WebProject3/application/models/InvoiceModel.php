<?php
class InvoiceModel extends CI_Model
{
	public function read($id)
	{
		$query = $this->db->query("SELECT * from sale_invoice where kh_id = ".$id);
		return $query->result_array();
	}
	public function readDetail($id)
	{
		$query = $this->db->query("SELECT * from sale_invoicedetail where hd_id = ".$id);
		return $query->result_array();
	}
	public function readNameProduct($id)
	{
		$query = $this->db->query("select sp_ten from sale_product where sp_id = ".$id);
		$data = $query->result_array();
		foreach ($data as $key) 
		{
			$list = $key['sp_ten'];
		}
		return $list;
	}
	public function insert($data)
	{
		$this->db->insert('sale_invoice', $data);
	}
	public function insertDetail($data)
	{
		$this->db->insert('sale_invoicedetail', $data);
	}
	public function readNextId()
	{
		$query = $this->db->query("select hd_id from sale_invoice");
		$data = $query->result_array();
		foreach ($data as $key) 
		{
			$list = $key['hd_id'];
		}
		return $list;
	}
}
?>