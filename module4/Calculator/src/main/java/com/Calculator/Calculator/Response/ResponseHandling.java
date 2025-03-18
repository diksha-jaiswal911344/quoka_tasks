package com.Calculator.Calculator.Response;

public class ResponseHandling {
    private double input1;
    private double input2;
    private String operation;
    private double result;
    private String message;

//    public ResponseHandling(int result, String message) {
//        this.result = result;
//        this.message = message;
//    }
//
//    public double getResult() {
//        return result;
//    }
//
//    public void setResult(int result) {
//        this.result = result;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    public ResponseHandling(double input1, double input2, String operation, double result, String message) {
        this.input1 = input1;
        this.input2 = input2;
        this.operation = operation;
        this.result = result;
        this.message = message;
    }

    public double getInput1() {
        return input1;
    }

    public void setInput1(double input1) {
        this.input1 = input1;
    }

    public double getInput2() {
        return input2;
    }

    public void setInput2(double input2) {
        this.input2 = input2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
