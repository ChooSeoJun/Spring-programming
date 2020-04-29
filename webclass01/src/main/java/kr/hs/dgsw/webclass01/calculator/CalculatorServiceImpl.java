package kr.hs.dgsw.webclass01.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public int calculator(String num1, String num2, String sign) {
        
        int result = 0;
        switch(sign){
            case "plus":
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "minus":
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
            case "multi":
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;    
            case "divide":
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                break;
        }
        return result;
    }
    @Override
    public boolean hasNull(String num) {
        if(num.equals(null))
            return true;
        return false;
    }
    @Override
    public boolean isZeroDivide(String num, String sign) {
        if(sign.equals("divide") && Integer.parseInt(num) == 0)
            return true;
        return false;
    }

}