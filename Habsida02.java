import java.util.*;

public class Habsida02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] parts = input.split(" ");
        int a = 0, b = 0, c = 0;
        char op1 = ' ', op2 = ' ';
        if (parts.length == 3) {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
            op1 = parts[1].charAt(0);
            int result = calculate(a, b, c, op1, op2);
            System.out.println(result);
        } else if (parts.length == 5) {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
            op1 = parts[1].charAt(0);
            c = Integer.parseInt(parts[4]);
            op2 = parts[3].charAt(0);
            int result = calculate(a, b, c, op1, op2);
            System.out.println(result);
        } else {
            System.out.println("Maximum three integers and two operators!");
        }
    }

    private static int calculate(int a, int b, int c, char op1, char op2) {
        int result = 0;

        if (op2 == ' ') {
            result = evaluate(a, b, op1);
        } else {
            if (op2 == '*' || op2 == '/') { //prioritizing multiplication and division
                b = evaluate(b, c, op2); //b will be equal operation with b and c
                result = evaluate(a, b, op1);
            } else {
                int temp = evaluate(a, b, op1);
                result = evaluate(temp, c, op2);
            }
        }

        return result;
    }

    private static int evaluate(int a, int b, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.err.println("Division by 0. Error!");
                } else {
                    result = a / b;
                }
                break;
            default:
                System.out.println("Simple operators only.");
                break;
        }

        return result;
    }
}
