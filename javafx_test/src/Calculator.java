import java.util.Stack;

public class Calculator {

    String expr;

    public Calculator(String expr) {
        this.expr = expr;
    }

    public Double Execute() {
        String exp[] = this.expr.split(" ");
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for (int i = 0; i < exp.length; i++) {
            String s = exp[i];
            if (s.equals("(")) {

            } else if (s.equals("+") || s.equals("*")) {
                ops.push(s);
            } else if (s.equals(")")) {
                getComp(ops, vals);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        getComp(ops, vals);

        return vals.pop();
    }

    private static void getComp(Stack<String> ops, Stack<Double> vals) {
        String op = ops.pop();
        if (op.equals("+")) {
            vals.push(vals.pop() + vals.pop());
        } else if (op.equals("*")) {
            vals.push(vals.pop() * vals.pop());
        }
    }
}