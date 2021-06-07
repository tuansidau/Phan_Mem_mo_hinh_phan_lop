<?php
class ProductModel extends CI_Model
{
	public function read()
	{
		$query = $this->db->query("SELECT * from sale_product where sp_tonkho > 0 order by sp_id desc");
		return $query->result_array();
	}
	public function readProduct($id)
	{
		$query = $this->db->query("SELECT * from sale_product where loai_id = ".$id." and sp_tonkho > 0 order by sp_id desc");
		return $query->result_array();
	}
	public function readCatalog()
	{
		$query = $this->db->query("SELECT * from sale_catalog");
		return $query->result_array();
	}
	public function readInfoProduct($id)
	{
		$query = $this->db->query("SELECT * from sale_product where sp_id = ".$id);
		return $query->result_array();
	}
	public function search($content)
	{
		$query = $this->db->query("SELECT * FROM sale_product
			WHERE sp_ten LIKE '%".$content."%' and sp_tonkho > 0 order by sp_id desc");
		return $query->result_array();
	}
}
?>