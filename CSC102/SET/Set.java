import jdk.nashorn.internal.runtime.arrays.NumericElements;

// ========================================================
// --------------------- CAUTION --------------------- 
// ========================================================
// - ArrayList, and every helper methods in Arrays Class are forbidden.
// ========================================================
// ========================================================
public class Set {
  // !! Do NOT modify this attribute !!
  // - Otherwise, any marks from this problem will not be given.
  private double[] number;
  
  // === Note that the way to construct an new empty set can be these following ways:
  // 1. Set mySet = new Set();
  // 2. Set mySet = new Set(new int[] {});
  // Whenever the variable named number contains nothing, that means the set is empty.
  // ==================================================================================
  
  // !! It is needed to implement. !!
  public Set() {
    
  }
  
  // !! It is needed to implement. !!
  public Set(double[] number) {
    this.number = new double[number.length];
    for(int i=0;i<number.length;i++){
      this.number[i] = number[i];
    }
  }
  
  // !! It is needed to implement. !!
  public Set(int[] number) {
    this.number = new double[number.length];
    for(int i=0;i<number.length;i++){
      this.number[i] = number[i];
    }
  }
  
  // !! It is needed to implement. !!
  // Any methods provided by Java API for sorting or manipulating elements in an array are prohibitted.
  // Please implement on your own only. Otherwise, your work will not be considered.
  // ==> This method will sort elements in this set.
  private void sortNumber() {
    for(int i=0;i<this.number.length;i++){
      double min = 99999999;
      for(int j=i;j<this.number.length;j++){
        if(this.number[j]<=min) min = this.number[j];
      }
      this.number[i] = min;
    }
  }
  
  // !! It is needed to implement. !!
  // Any methods provided by Java API for manipulating an array are prohibitted.
  // Please implement on your own only. Otherwise, your work will not be considered.  
  // ==> This method will remove the duplicated elements in this set.
  private void removeDuplicate() {
    double result[] = new double[this.number.length];
    result[0] = this.number[0];
    int count = 1;
    for(int i=1;i<this.number.length;i++){
      boolean isDup = false;
      for(int j=0;j<result.length;j++){
        if(this.number[i] == result[j]){
          isDup = true;
          break;
        }
      }
      if(!isDup) result[count] = this.number[i];
      count++;
    }
    this.number = result;
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return length of the set.
  // ==> Note that: this method will not count the duplicated elements.
  public int length() {
    double result[] = new double[this.number.length];
    result[0] = this.number[0];
    int count = 1;
    for(int i=1;i<this.number.length;i++){
      boolean isDup = false;
      for(int j=0;j<result.length;j++){
        if(this.number[i] == result[j]){
          isDup = true;
          break;
        }
      }
      if(!isDup) result[count] = this.number[i];
      count++;
    }
    return result.length;
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return TRUE/FALSE whether this set belongs to set Set.
  public boolean belongsTo(Set set) {
    double[] set1 = set.getValueInArray();
    int count = 0;
    for(int i=0;i<this.number.length;i++){
      for(int j=0;j<set1.length;j++){
        if(this.number[i] == set1[j]) count++;
      }
    }
    if(count>=this.number.length) return true;
    return false;
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return the set composed of elements in A or B.
  // ==> HINT : A U B
  // ==> {1.0, 2.0, 3.0} U {2.0, 4.0, 5.0, 6.0} equals {1.0, 2.0, 3.0, 4.0, 5.0, 6.0}
  public Set union(Set set) {
    double[] init = new double[this.number.length + set.length()];
    double[] set1 = set.getValueInArray();
    for(int i=0;i<set1.length;i++){
      init[i] = set1[i];
    }
    int count = 0;
    for(int j=set1.length-1;j<init.length;j++){
      init[j] = this.number[count];
      count++;
    }

  }
  
  // !! It is needed to implement. !!
  // ==> This method will return the set composed of elements being available both in A and B.
  // ==> HINT : A ∩ B
  // ==> {1.0, 2.0, 3.0} ∩ {2.0, 4.0, 5.0, 6.0} equals {2.0}
  public Set intersect(Set set) {
    double set1[] = set.getValueInArray();
    
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return the set composed of elements being in A except B.
  // ==> HINT : A - B
  // ==> {1.0, 2.0, 3.0} - {2.0, 4.0, 5.0, 6.0} equals {1.0, 3.0}
  public Set differ(Set set) {

  }
  
  // !! Do NOT modify this method !!
  // - Otherwise, any marks from this problem will not be given.
  public double[] getValueInArray() {
    return number;
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return TRUE/FALSE depending on whether this set equals to set Set or not.
  public boolean equals(Set set) {

  }
  
  // !! It is needed to implement. !!
  // ==> This method will return the String which shows the (sorted) list of elements in this set.
  // ==> e.g. {1.0, 2.0, 3.5, 5.0}
  public String getStringValue() {

  }
  
  // !! Do NOT modify this method !!
  // - Otherwise, any marks from this problem will not be given.
  public void print() {
    System.out.println(getStringValue());
  }
  
  // !! It is needed to implement. !!
  // ==> This method will return the summation of all elements in this set.
  // ==> if you have {1.0, 2.0, 3.5, 5.0}, you will get 11.5.
  public static double sumAllNumberInSet(Set set) {

  }
}
