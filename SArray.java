import org.apache.commons.lang.ArrayUtils;

public class SArray {
  public SObject[] array = new SObject[0];
  // yes, i want to have a length variable of my own, now bugger off
  public int length = 0;

  public void append(SObject value) {
    SObject[] newArray = new SObject[this.length + 1];
    for (int i = 0; i < this.length; i++){
      newArray[i] = this.array[i];
    }
    newArray[this.length] = value;
    this.array = newArray;
    // could also do: "this.length = this.array.length;" but didn't
    this.length++;
  }

  public SObject pop(int index) {
    SObject item = this.getItem(index);
    // this also works: this.remove(item);
    this.remove(index);
    this.length--;
    return item;
  }

  public static remove(int index){
    this.array = ArrayUtils.remove(this.array, index);
    }
  }

  public SObject getItem(int index){
    return this.array[i];
  }


  public SObject pop() {
    // default pop operation
    return this.pop(this.length - 1);
  }

  public SArray copy() {
    SArray array = new SArray();
    for (SObject obj : this.array){
      array.append(obj.copy());
    }
    return array;
  }

  public void print() {
    // do not print an empty array plz, java does not take that kindly
    if (this.length == 0){
      // you were warned, were you not?
      // now your code shall be bricked
      throw new CustomException("Cannot print a blank array");
    }
    for (int i = 0; i < this.array.length; i++){
      SObject obj = this.array[i];
      System.out.println(obj);
    }
  }
}
