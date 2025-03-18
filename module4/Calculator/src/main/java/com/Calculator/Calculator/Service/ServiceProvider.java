package com.Calculator.Calculator.Service;

import com.Calculator.Calculator.Request.RequestHandeling;
import com.Calculator.Calculator.Response.ResponseHandling;
import org.springframework.stereotype.Service;

@Service
public class ServiceProvider {
    public ResponseHandling performOperation(RequestHandeling request){
        double input1=request.getInput1();
        double input2=request.getInput2();
        String operation=request.getOperation();
        double result=0;
        String message="Success";

        switch(request.getOperation().toLowerCase()){
            case "add": result= request.getInput1()+request.getInput2();
                        break;
            case "sub": result= request.getInput1()-request.getInput2();
                break;
            case "multiply": result= request.getInput1()*request.getInput2();
                break;
            case "divide":
                if(request.getInput2()==0){
                return new ResponseHandling(input1,input2,operation,0,"you are dividing by 0");
            }
                result= request.getInput1()/request.getInput2();
                break;
            case "modulo": result= request.getInput1()%request.getInput2();
                break;
            default:
                return new ResponseHandling(input1,input2,operation,0,"No valid input");
        }
        return new ResponseHandling(input1,input2,operation,Double.parseDouble(String.format("%.2f", result)),message);
    }
}
