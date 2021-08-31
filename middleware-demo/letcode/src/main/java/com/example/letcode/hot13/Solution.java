package com.example.letcode.hot13;

import javax.print.DocFlavor;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
    public int romanToInt(String s) {

        int sum = 0;
        while (s.length()>0){
            String title1 = s.substring(0,1);
            String title2 = s.length() > 1 ? s.substring(0,2) : "";
            if(title2.length()>0 && getInt(title2) > 0){
                sum += getInt(title2);
                s = s.substring(2);
            }else {
                sum += getInt(title1);
                s = s.substring(1);
            }

        }
        return sum;
    }

    public static int getInt(String title){

        switch (title){
            case "M": return  1000;
            case "CM": return  900;
            case "D": return  500;
            case "CD": return  400;
            case "C": return  100;
            case "XC": return  90;
            case "L": return  50;
            case "XL": return  40;
            case "X": return  10;
            case "IX": return  9;
            case "V": return  5;
            case "IV": return  4;
            case "I": return  1;
        }

        return -1;
    }
}

enum Roman{

    ROMAN_1(1,"I"),
    ROMAN_4(4,"IV"),
    ROMAN_5(5,"V"),
    ROMAN_9(9,"IX"),
    ROMAN_10(10,"X"),
    ROMAN_40(40,"XL"),
    ROMAN_50(50,"L"),
    ROMAN_90(90,"XC"),
    ROMAN_100(100,"C"),
    ROMAN_400(400,"CD"),
    ROMAN_500(500,"D"),
    ROMAN_900(900,"CM"),
    ROMAN_1000(1000,"M")

    ;

    Roman(int code,String title){
        this.code = code;
        this.title = title;
    }

    public int code;

    public String title;

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }


    public static int getByTitle(String title){
        for(Roman roman : values()){
            if(roman.title.equals(title)){
                return roman.code;
            }
        }
        return -1;
    }

}
