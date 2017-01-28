package lesson7.task1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left + ", " + right + ")";
    }

    public static class Builder<L, R> {
        private L l;
        private R r;

        public Builder<L, R> setLeft(@NotNull L left) {
            l = left;
            return this;
        }

        public Builder<L, R> setRight(@NotNull R right) {
            r = right;
            return this;
        }

        public Pair<L, R> build() {
            if (l == null || r == null) {
                throw new NullPointerException(l == null ? "left not set" : "right not set");
            }
            return new Pair<L, R>(l, r);
        }
    }
}
