/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Ly Quynh Tran
 */
public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        ArticleModel artical = new ArticleModel();
        System.out.println("id="+artical.getTotalRows());
        ViewModel v = new ViewModel();
        System.out.println(""+v.getView());
        v.updateView();
       
    }
    
}
