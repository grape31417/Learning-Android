package com.example.bluedream.myfirstapp;


/**
 * Created by USER on 2017/10/24.
 */

public class MarriageSuggestion {
    public String getSuggestion(String strSex,int iAge){
        String  strSug ="";
        if (strSex.equals("男"))
            if (iAge < 28) strSug += "還不急";
            else if (iAge > 33) strSug += "趕快結婚";
             else strSug += "開始找對象";
        else
            if (iAge < 28) strSug += "還不急";
            else if (iAge > 33) strSug += "趕快結婚";
            else strSug += "開始找對象";
            return strSug;
        
    }
}
