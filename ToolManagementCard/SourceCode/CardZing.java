/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoX;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CardZing implements Serializable{
    private String seri, code;

    public CardZing() {
    }
    
    

    public CardZing(String seri, String code) {
        this.seri = seri;
        this.code = code;
    }

    public String getSeri() {
        return seri;
    }

    public String getCode() {
        return code;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String show(){
        return (getSeri()+" "+getCode());
    }
}
