/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SanphamDAL;
import DTO.SanphamDTO;
import java.util.ArrayList;
/**
 *
 * @author nngia
 */
public class SanphamBLL {
    ArrayList<SanphamDTO> dssp = new ArrayList();
    SanphamDAL data = new SanphamDAL();
    
    public ArrayList<SanphamDTO> docdsdd(){
                System.out.println(dssp.size());
        return dssp = data.docDssp();

    }
   
}
