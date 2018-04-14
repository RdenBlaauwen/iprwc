/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.services;

import nl.IPRWC_RdenBlaauwen.dao.DataDAO;
import nl.IPRWC_RdenBlaauwen.models.CSVModel;

/**
 *
 * @author RdenBlaauwen
 */
public class ExportService {
    private DataDAO dataDao = new DataDAO();
    
    public CSVModel read(){
        return dataDao.getCsvData();
    }
}
