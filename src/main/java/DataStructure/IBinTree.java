package DataStructure;

import java.util.Optional;

public interface IBinTree<T>{
    void addRight(IBinTree<T> n);
    void addLeft(IBinTree<T> n);
    T getValue();
    Optional<IBinTree<T>> getRight();
    Optional<IBinTree<T>> getLeft();
}
