package ExprNode;

import java.util.Optional;
import DataStructure.IBinTree;

public class Floating implements Evaluable, IBinTree<Evaluable>{
    private final double f;
    public Floating(double value) {
        this.f = value;
    }

    @Override
    public Number eval() {
        return f;
    }

    @Override
    public Evaluable getValue() {
        return this;
    }

    @Override
    public void addLeft(IBinTree<Evaluable> n) {}

    @Override
    public void addRight(IBinTree<Evaluable> n) {}

    @Override
    public Optional<IBinTree<Evaluable>> getLeft() {
        return Optional.empty();
    }

    @Override
    public Optional<IBinTree<Evaluable>> getRight() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Floating[" + f + "]";
    }
}
