/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

/**
 *
 * @author yasin93
 */
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class PostfixEvaluator {

    public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    public PostfixEvaluator() {
        operandStack = new Stack<Integer>();
    }

    private int evalOp(char op) {//hit skickar vi en operator den ska nu utföras på de två översta talen på stacken som ska tas bort. Sedan ska resultate t upp på stacken 
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

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {

        String[] tokens = expression.split(" +");//delar upp strängen vid mellanslag
        try {
            for (String nextToken : tokens) {
                char firstChar = nextToken.charAt(0);
                if (Character.isDigit(firstChar)) {
                    int value = Integer.parseInt(nextToken);
                    operandStack.push(value);
                } else if (isOperator(firstChar)) {
                    int result = evalOp(firstChar);
                    operandStack.push(result);
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }

            }
            int answer = operandStack.pop();
            if (operandStack.empty()) {
                return answer;
            } else {
                throw new SyntaxErrorException("syntax Error: Stack should be empty");
            }
        } //Vi har läst hela uttrycket och gjort alla beräkningar så dags att ta ut svaret som borde vara det enda kvar på stacken 
        //Om stacken inte är tom kasta ett syntax  error annars returnera resultatet            
        catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }

    }

    public static void main(String[] args
    ) {
        PostfixEvaluator evaluator
                = new PostfixEvaluator();
        String line;
        Scanner in
                = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a postfix expression to evaluate");
            line
                    = in.nextLine();
            if (!line.equals("")) {
                try {
                    int result
                            = evaluator.eval(
                                    line
                            );
                    System.out.println(
                            "Value is " + result
                    );
                } catch (PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax erro  "
                            + ex.getMessage()
                    );
                }
            } else {
                break;
            }
        }
    }

}
