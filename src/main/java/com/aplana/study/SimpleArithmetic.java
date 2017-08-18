package com.aplana.study;


public class SimpleArithmetic {

    private String expression;

    public int calc(String expression){

        int mark = 0;
        int result = Integer.parseInt(expression.substring(0, 1));

        for (int i = 1; i < expression.length(); i++){
            if (expression.substring(i, i+1).equals(Function.PLUS)){
                result += Integer.parseInt(expression.substring(i+1, i+2));
                mark = i+1;
            }
            if (expression.substring(i, i+1).equals(Function.MINUS)){
                result -= Integer.parseInt(expression.substring(i+1, i+2));
            }
        }

        return result;
    }

   private class Function{

       final static String PLUS = "+";
       final static String MINUS = "-";

   }
}
