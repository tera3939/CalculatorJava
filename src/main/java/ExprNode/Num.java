package ExprNode;

import java.util.Optional;
import DataStructure.IBinTree;

public class Num implements Evaluable, IBinTree<Evaluable>{
    private final int i;
    public Num(int value) {
        this.i = value;
    }

    @Override
    public Number eval() {
        return i;
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
        return "Num[" + i + "]";
    }
}
