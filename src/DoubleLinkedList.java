public class DoubleLinkedList<T extends Comparable<T>> {
    Node<T> head;

    public void addElement(T el)
    {
        if(isEmpty())
            head = new Node<T>(el);
        else
        {
            Node<T> newEl = new Node<T>(el);
            Node<T> last = getNode(getLength() - 1);
            last.nxt = newEl;
            newEl.prev = last;
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public Node<T> getNode(int index)
    {
        if (index >= getLength())
            throw new IndexOutOfBoundsException();
        Node<T> cur = head;
        for (int i = 0; i < index; i++)
        {
            cur = cur.nxt;
        }
        return cur;
    }

    public T getElement(int index)
    {
        return getNode(index).value;
    }

    public int getLength()
    {
        if (isEmpty())
            return 0;
        int cnt = 1;
        Node<T> cur = head;
        while (cur.nxt != null)
        {
            cnt += 1;
            cur = cur.nxt;
        }
        return cnt;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Empty DoubleLinkedList";
        StringBuilder result = new StringBuilder("DoubleLinkedList:");
        Node<T> cur = head;
        for (int i = 0; i < getLength(); i++)
        {
            result.append(" ").append(cur.value);
            cur = cur.nxt;
        }
        return result.toString();
    }

    public void sort()
    {
        int length = getLength();
        int sortedIndex = 0;
        Node<T> lastSorted = null;
        Node<T> firstNotSorted = head;
        for (int e = 0; e < getLength(); e++)
        {
            Node<T> min  = firstNotSorted;
            Node<T> cur = firstNotSorted;

            for (int i = sortedIndex + 1; i < length; i++)
            {
                cur = cur.nxt;
                if (cur.value.compareTo(min.value) < 0)
                    min = cur;
            }

            if (min != firstNotSorted)
            {
                Node<T> left = min.prev;
                Node<T> right = min.nxt;
                if (left != null)
                    left.nxt = right;
                if (right != null)
                    right.prev = left;

                if (lastSorted != null)
                {
                    lastSorted.nxt = min;
                    min.prev = lastSorted;
                }
                else
                    head = min;

                if (firstNotSorted != null)
                {
                    firstNotSorted.prev = min;
                    min.nxt = firstNotSorted;
                }
            }

            sortedIndex += 1;
            lastSorted = min;
            firstNotSorted = lastSorted.nxt;
        }
    }
}
