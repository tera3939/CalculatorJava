package ExprNode;

import java.util.Optional;
import DataStructure.IBinTree;

public class Unary implements Evaluable, IBinTree<Evaluable>{
    private final String op;
    private IBinTree<Evaluable> number;
    public Unary(String op, IBinTree<Evaluable> number) {
        this.op = op;
        this.number = number;
    }

    @Override
    public Number eval() {
        Evaluable e = number.getValue();
        switch (op) {
            case "+":
                return e.eval();
            case "-":
                if (e.eval() instanceof Integer){
                    return -e.eval().intValue();
                } else {
                    return -e.eval().doubleValue();
                }
            default:
                // TODO: something good error
                return 0;
        }
    }

    @Override
    public Evaluable getValue() {
        return this;
    }

    @Override
    public Optional<IBinTree<Evaluable>> getLeft() {
        return Optional.of(number);
    }

    @Override
    public Optional<IBinTree<Evaluable>> getRight() {
        return Optional.empty();
    }

    @Override
    public void addLeft(IBinTree<Evaluable> n) {
        number = n;
    }

    @Override
    public void addRight(IBinTree<Evaluable> n) {}

    @Override
    public String toString() {
        return "Unary[" + op + ", " + number + "]";
    }
}
