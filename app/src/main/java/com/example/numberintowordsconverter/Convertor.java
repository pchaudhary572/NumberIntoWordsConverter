package com.example.numberintowordsconverter;

public class Convertor {
    private final char[] array;
    private final int arrayLength;
    private final String[] firstNumber ={"zero","One","Two","Three","Four"
            ,"Five","Six","Seven","Eight","Nine"};
    private final String[] tensNumber ={"Ten","Eleven","Twelve","Thirteen",
            "Fourteen","Fifteen","Sixteen","Seventeen", "Eighteen","Nineteen",};
    private final String[] twentyAbove ={"Twenty","Thirty","Forty","Fifty",
            "Sixty","Seventy","Eighty","Ninety"};
    private final String[] hundreds ={"Hundred","Hundreds"};
    public Convertor(int item){
        array = String.valueOf(item).toCharArray();
        arrayLength = array.length;
    }
    public String Validate(){
        switch (arrayLength){
            case 1:
                return oneDigitHere(Character.getNumericValue(array[0]));
            case 2:
                return twoDigitHere(Character.getNumericValue(array[0]),
                        Character.getNumericValue(array[1]));
            case 3:
                return threeDigitHere(Character.getNumericValue(array[0]),Character.
                        getNumericValue(array[1]),Character.getNumericValue(array[2]));
        }
        return "Invalid Number Format";
    }


    private String oneDigitHere(int x){
        return firstNumber[x];
    }
    private String twoDigitHere(int x, int y){
        if(x == 1){
            return tensNumber[y];
        }
        else if(x == 0){
            if( y == 0 ){
                return "";
            }else{
                return firstNumber[y];
            }
        }
        else{
            if(y == 0){
                return twentyAbove[x-2];
            }
            return twentyAbove[x-2]+oneDigitHere(y);
        }
    }
    private String threeDigitHere(int x, int y, int z){
        if(x == 1){
            return firstNumber[x]+" "+hundreds[0]+" and "+twoDigitHere(y,z);
        }else{
            if(y ==0 && z == 0){
                return firstNumber[x]+" "+hundreds[1]+twoDigitHere(y,z);
            }
            return firstNumber[x]+" "+hundreds[1]+" and "+twoDigitHere(y,z);
        }
    }
}
