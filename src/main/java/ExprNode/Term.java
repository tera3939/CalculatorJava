package ExprNode;

import java.util.Optional;
import DataStructure.IBinTree;

public class Term implements Evaluable, IBinTree<Evaluable>{
    private final String op;
    private IBinTree<Evaluable> left, right;
    public Term(String op, IBinTree<Evaluable> left, IBinTree<Evaluable> right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public Number eval() {
        Number l = left.getValue().eval();
        Number r = right.getValue().eval();
        switch (op) {
            case "*":
                if (l instanceof Integer && r instanceof Integer) {
                    return l.intValue() * r.intValue();
                } else {
                    return l.doubleValue() * r.doubleValue();
                }
            case "/":
                return l.doubleValue() / r.doubleValue();
            case "%":
                if (l instanceof Integer && r instanceof Integer) {
                    return l.intValue() % r.intValue();
                } else {
                    return l.doubleValue() % r.doubleValue();
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
        return Optional.of(left);
    }

    @Override
    public Optional<IBinTree<Evaluable>> getRight() {
        return Optional.of(right);
    }

    @Override
    public void addLeft(IBinTree<Evaluable> n) {
        left = n;
    }

    @Override
    public void addRight(IBinTree<Evaluable> n) {
        right = n;
    }

    @Override
    public String toString() {
        return "Term[" + op + ", " + left + ", " + right + "]";
    }
}
