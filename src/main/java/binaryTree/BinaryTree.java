package binaryTree;

import model.BinaryTreeNode;

public class BinaryTree<T extends Comparable> {
    BinaryTreeNode<T> head;
    private int count;

    public void add(T value) {
        if (head == null) {
            head = new BinaryTreeNode<T>(value);
        } else {
            addTo(head, value);
        }
    }

    private void addTo(BinaryTreeNode<T> node, T value) {
        // Случай 1: Вставляемое значение меньше значения узла
        if (value.compareTo(node.getValue()) < 0) {
            // Если нет левого поддерева, добавляем значение в левого ребенка,
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<T>(value));
            } else {
                // в противном случае повторяем для левого поддерева.
                addTo(node.getLeft(), value);
            }
        }
        // Случай 2: Вставляемое значение больше или равно значению узла.
        else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<T>(value));
            } else {
                addTo(node.getRight(), value);
            }
        }
    }

    BinaryTreeNode<T> parent;

    public boolean remove(T value) {
        BinaryTreeNode<T> current;

        // Находим удаляемый узел.
        current = findWithParent(value);
        if (current == null) {
            return false;
        }
        count--;

        // Случай 1: Если нет детей справа, левый ребенок встает на место удаляемого.
        if (current.getRight() == null) {
            if (parent == null) {
                head = current.getLeft();
            } else {
                int result = parent.compareTo(current.getValue());
                if (result > 0) {
                    // Если значение родителя больше текущего,
                    // левый ребенок текущего узла становится левым ребенком родителя.
                    parent.setLeft(current.getLeft());
                } else if (result < 0) { // Если значение родителя меньше текущего, левый ребенок текущего узла становится правым ребенком родителя.
                    parent.setRight(current.getLeft());
                }
            }
        }
        // Случай 2: Если у правого ребенка нет детей слева то он занимает место удаляемого узла.
        else if (current.getRight().getLeft() == null) {
            current.getRight().setLeft(current.getLeft());
            if (parent == null) {
                head = current.getRight();
            } else {
                int result = parent.compareTo(current.getValue());
                if (result > 0) {
                    // Если значение родителя больше текущего,
                    // правый ребенок текущего узла становится левым ребенком родителя.
                    parent.setLeft(current.getRight());
                } else if (result < 0) { // Если значение родителя меньше текущего, правый ребенок текущего узла становится правым ребенком родителя.
                    parent.setRight(current.getRight());
                }
            }
        }
        // Случай 3: Если у правого ребенка есть дети слева, крайний левый ребенок из правого поддерева заменяет удаляемый узел.
        else {
            // Найдем крайний левый узел.
            BinaryTreeNode leftmost = current.getRight().getLeft();
            BinaryTreeNode leftmostParent = current.getRight();
            while (leftmost.getLeft() != null) {
                leftmostParent = leftmost;
                leftmost = leftmost.getLeft();
            }
            // Левое поддерево родителя становится правым поддеревом крайнего левого узла.
            leftmostParent.setLeft(leftmost.getRight());
            // Левый и правый ребенок текущего узла становится левым и правым ребенком крайнего левого.
            leftmost.setLeft(current.getLeft());
            leftmost.setRight(current.getRight());
            if (parent == null) {
                head = leftmost;
            } else {
                int result = parent.compareTo(current.getValue());
                if (result > 0) {
                    // Если значение родителя больше текущего,
                    // крайний левый узел становится левым ребенком родителя.
                    parent.setLeft(leftmost);
                } else if (result < 0) {
                    // Если значение родителя меньше текущего,
                    // крайний левый узел становится правым ребенком родителя.
                    parent.setRight(leftmost);
                }
            }
        }

        return true;
    }

    public boolean contains(T value) {
        return findWithParent(value) != null;
    }

    private BinaryTreeNode findWithParent(T value) {
        // Попробуем найти значение в дереве.
        BinaryTreeNode current = head;
        parent = null;
        // До тех пор, пока не нашли...
        while (current != null) {
            int result = current.compareTo(value);
            if (result > 0) {
                // Если искомое значение меньше, идем налево.
                parent = current;
                current = current.getLeft();
            } else if (result < 0) {
                // Если искомое значение больше, идем направо.
                parent = current;
                current = current.getRight();
            } else {
                // Если равны, то останавливаемся
                break;
            }
        }
        return current;
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        count = 0;
    }

    public void preOrderTraversal() {
        preOrderTraversal(head);
    }

    private void preOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(head);
    }

    private void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(head);
    }

    private void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.println(node.getValue());
            inOrderTraversal(node.getRight());
        }
    }
}
