import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
    //Quadrant q = new Quadrant();
    ChokladOptimering co = new ChokladOptimering();
    int[] ord = new int[8];
    String word;
    int i = 0;
    while((word = br.readLine()) != null) {
      ord[i] = Integer.parseInt(word);
      i++;
    }
    br.close();
    for(int k: ord) {
      System.out.println(k);
    }
    //q.fyllKvadrat(ord[0]);
    co.chokladOptimering(ord);
  }
}
