public class LinkedList <E>{
  private int size;
  private Node start,end;

  public LinkedList() {
    size = 0;
    start = null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add(E value) {
    Node n = new Node(value,end);
    if (size() == 0) {
      start = n;
      end = n;
      size += 1;
      return true;
    }
    end.setNext(n);
    end = n;
    size += 1;
    return true;
  }

  public String toString() {
    String answer = "[";
    if (size() == 0) {
      return "[]";
    }
    Node current = start;
    for (int i = 0;i < size();i++) {
      answer += current.getData();
      current = current.next();
      answer += ", ";
    }
    answer = answer.substring(0,answer.length() - 2);
    return answer + "]";
  }

  private Node getNthNode(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for (int i = 0;i < index;i += 1) {
      current = current.next();
    }
    return current;
  }

  public E get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    Node current = getNthNode(index);
    return current.getData();
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    Node current = getNthNode(index);
    E answer = current.getData();
    current.setData(value);
    return answer;
  }

  public boolean contains(E value) {
    boolean answer = false;
    Node current = start;
    for (int i = 0;i < size();i += 1) {
      if (current.getData() == value) {
        answer = true;
      }
      current = current.next();
    }
    return answer;
  }

  public int indexOf(E value) {
    int answer = -1;
    Node current = start;
    for (int i = 0;i < size();i += 1) {
      if (current.getData() == value) {
        return i;
      }
      current = current.next();
    }
    return answer;
  }

  public void add(int index,E value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException();
    }
    size += 1;
    if (index == 0) {
      start = new Node(value,null,start);
      if (size() > 1) {
        getNthNode(1).setPrev(start);
      }
      else {
        end = start;
      }
    }
    if (index == size() - 1) {
      if (size() > 1) {
        end.setNext(new Node(value,end));
        end = end.next();
      }
      else {
        start = new Node(value,null,null);
        end = start;
      }
    }
    if (index != 0 && index != size() - 1) {
      Node m = getNthNode(index - 1);
      Node n = new Node(value,m,m.next());
      m.setNext(n);
      n.next().setPrev(n);
    }
  }
  public E remove(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    E answer = start.getData();
    if (index == 0) {
      answer = start.getData();
      start = getNthNode(1);
      start.setPrev(null);
      size -= 1;
    }
    if (index != 0 && index != size() - 1) {
      Node m = getNthNode(index - 1);
      answer = m.next().getData();
      m.setNext(m.next().next());
      m.next().setPrev(m);
      size -= 1;
      return answer;
    }
    if (index == size() - 1) {
      answer = end.getData();
      end = end.prev();
      end.setNext(null);
      size -= 1;
    }
    return answer;
  }

  public boolean remove (E value) {
    Node current = start;
    for (int i = 0;i < size();i += 1) {
      if (current.getData().equals(value)) {
        remove(i);
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public void extend(LinkedList<E> other) {
    size = size() + other.size();
    end.setNext(other.start);
    other.start.setPrev(end);
    end = other.end;
    other.size = 0;
    other.end = null;
    other.start = null;
  }

  private class Node{
    private E data;
    private Node next,prev;
    public Node(E value,Node before,Node after) {
      data = value;
      next = after;
      prev = before;
    }

    public Node(E value,Node before) {
      data = value;
      prev = before;
      next = null;

    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public E getData() {
      return data;
    }

    public void setNext(Node n) {
      next = n;
    }

    public void setPrev(Node n) {
      prev = n;
    }

    public String toString() {
      return "" + getData();
    }

    public E setData(E i) {
      E ans = getData();
      data = i;
      return ans;
    }
  }
}
