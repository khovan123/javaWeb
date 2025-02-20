package com.model;

public class TestDB {

    public static void main(String[] args) throws Exception {      
        ArticleModel artical = new ArticleModel();
        System.out.println("id="+artical.getTotalRows());
        ViewModel v = new ViewModel();
        System.out.println(""+v.getView());
        v.updateView();
       
    }
    
}
