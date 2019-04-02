public class Radix{
  public static void radixsort(int[]data) {
    @SuppressWarnings({"uncheked","rawtypes"})
    LinkedList<Integer>[]buckets = new LinkedList[20];
    for (int j = 0;j < buckets.length;j += 1) {
      buckets[j] = new LinkedList<Integer>();
    }
    for (int j = 0;j < data.length;j += 1) {
      if (data[j] < 0) {
        buckets[9 - ((data[j] / (10^0)) % 10)].add(data[j]);
      }
      else {
        buckets[10 + ((data[j] / (10^0)) % 10)].add(data[j]);
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
