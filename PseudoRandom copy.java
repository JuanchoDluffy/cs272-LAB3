public class PseudoRandom {
  private int seed;
  private int multiplier;
  private int increment;
  private int modulus;

  // constructor for the PseudoRandom object
  public PseudoRandom(int inMultiplier, int inSeed, int inIncrement, int inModulus) {
    seed = inSeed;
    multiplier = inMultiplier;
    increment = inIncrement;
    modulus = inModulus;
  }

  // setter method for instace variables
  public void setSeed(int newSeed) {
    seed = newSeed;
  }

  public void setMultiplier(int newMultiplier) {
    multiplier = newMultiplier;
  }

  public void setIncrement(int newIncrement) {
    increment = newIncrement;
  }

  public void setModulus(int newModulus) {
    modulus = newModulus;
  }

  // using the formula provided: a pseudo random number is generated
  // the instace variable seed is updated to the resul and the result
  // is returned.
  public int generateNextNum() {
    int result = (multiplier * seed + increment) % modulus;
    this.seed = result;
    return result;
  }

  public static void main(String[] args) {
    PseudoRandom test1 = new PseudoRandom(40, 1, 3641, 729);
    // loop to visualise 30 call to the generateNextNum() method.
    for (int i = 0; i < 30; i++) {
      System.out.println(test1.generateNextNum());
    }
  }
}
