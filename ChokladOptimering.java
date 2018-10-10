public class ChokladOptimering {

  public ChokladOptimering() {
  }

  public int chokladOptimering(int[] mums) {

    int totalMums = 0;
    int len = mums.length - 1;
    int i = 0;
    int k = 1;

    while(i <= len) {
      int left = mums[i];
      int right = mums[len];
      if(left <= right){
        System.out.println("vänster");
        i++; //ät upp vänsterbit
        totalMums += left*k;
      } else {
        System.out.println("höger");
        len--;
        totalMums += right*k;
      }
      k++;
    }
    System.out.println(totalMums);

    return totalMums;
  }
}
