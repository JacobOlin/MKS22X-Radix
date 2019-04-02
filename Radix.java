public class Radix{
  public static void radixsort(int[]data) {
    @SuppressWarnings({"uncheked","rawtypes"})
    MyLinkedList<Integer>[]buckets = new MyLinkedList[20];
    for (int j = 0;j < buckets.length;j += 1) {
      buckets[j] = new MyLinkedList<Integer>();
    }
    for (int j = 0;j < data.length;j += 1) {
      if (data[j] < 0) {
        buckets[9 - ((data[j] / (10^0)) % 10)].add(data[j]);
      }
      else {
        buckets[10 + ((data[j] / (10^0)) % 10)].add(data[j]);
      }
    }
    MyLinkedList<Integer> l = mergeToLinkedList(buckets);
  }

  public static int getLargest(int[] data) {
    int max = 0;
    for (int i = 0;i < data.length;i += 1) {
      if (Math.abs(data[i]) >= max) {
        max = Math.abs(data[i]);
      }
    }
    int j = 0;
    while (max > 0) {
      max /= 10;
      j += 1;
    }
    return j;
  }

  public static MyLinkedList<Integer> mergeToLinkedList(MyLinkedList<Integer>[] buckets) {
    MyLinkedList<Integer> l = new MyLinkedList<Integer>();
    for (int i = 0;i < buckets.length;i += 1) {
      l.extend(buckets[i]);
    }
    return l;
  }
}
