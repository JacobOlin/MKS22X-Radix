public class Radix{
  public static void radixsort(int[]data) {
    int[]buckets = new int[20];
    for (int i = 0;i < getLargest(data);i += 1) {

    }
  }

  public static int getLargest(int[] data) {
    int max = 0;
    for (int i = 0;i < data.length;i += 1) {
      if (Math.abs(data[i]) >= max) {
        max = data[i];
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
