public class Main {

  public static void main(String[] args) {
    Quadrant q = new Quadrant();
    if(args.length != 0) {
      q.fyllKvadrat(Integer.parseInt(args[0]));
    } else {
      System.exit(0);
    }

  }
}
