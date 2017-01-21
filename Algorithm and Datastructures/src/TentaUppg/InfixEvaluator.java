/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author yasin93
 */
public class InfixEvaluator {

    public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";

    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;

    private int evalOp(char op) {

        int rhs = operandStack.pop();
        int lhs = operandStack.pop();
        int result = 0;

        switch (op) {
            case '+':
                result = lhs + rhs;
                break;
            case '-':
                result = lhs - rhs;
                break;
            case '/':
                result = lhs / rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;

        }
        return result;
    }

    private int precedence(char op) {

        switch (op) {
            case '+':
                return 0;
            case '-':
                return 0;
            case '/':
                return 1;
            case '*':
                return 1;
        }
        return -1;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {

        operandStack = new Stack<Integer>();
        operatorStack = new Stack<Character>();
        String[] tokens = expression.split(" +");
        boolean nextShouldBeDigit = true;
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0)) && nextShouldBeDigit) {
                    operandStack.push(Integer.parseInt(nextToken));
                    nextShouldBeDigit = false;
                } else if (isOperator(nextToken.charAt(0)) && !nextShouldBeDigit) {
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(nextToken.charAt(0));
                    } else if (precedence(nextToken.charAt(0)) > precedence(operatorStack.peek())) {
                        operatorStack.push(nextToken.charAt(0));
                    } else {
                        while (!operatorStack.isEmpty() && precedence(nextToken.charAt(0)) <= precedence(operatorStack.peek())) {
                            operandStack.push(evalOp(operatorStack.pop()));
                        }
                        operatorStack.push(nextToken.charAt(0));
                    }
                    nextShouldBeDigit = true;
                } else {
                    throw new SyntaxErrorException("Invalid expression encountered");
                }
            }
            while (!operatorStack.isEmpty()) {
                operandStack.push(evalOp(operatorStack.pop()));
            }
            int answer = operandStack.pop();
            if (operandStack.empty()) {
                return answer;
            } else {
                throw new SyntaxErrorException("Syntax Error: Stack should be empty");
            }
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }
    
    
    public static void main(String[] args) {

        InfixEvaluator evaluator = new InfixEvaluator();

        String line;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter a infix expression without parenthesises to evaluate");
            line = in.nextLine();
            if(!line.equals("")){
                try {
                    int result = evaluator.eval(line);
                    System.out.println("Value is " + result);
                } catch (InfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else {
                break;
            }
        }
        in.close();
    }
}
