public class Radix{
  public static void radixsort(int[]data) {
    LinkedList<Integer>[]buckets = new LinkedList[20];
    for (int i = 0;i < getLargest(data);i += 1) {
      for (int j = 0;j < buckets.length;j += 1) {
        buckets[j] = new LinkedList<Integer>();
      }

    }
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
}
