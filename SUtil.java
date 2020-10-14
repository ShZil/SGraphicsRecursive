class SUtil {
  // Bascially append for a fixed length array with 'null's as placeholders.
  public static Object[] replaceSingleNull(Object[] array, Object element) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        array[i] = element;
        return array;
      }
    }
    return null;
  }

  // Bascially append for a fixed length SObject array with 'null's as placeholders.
  public static SObject[] replaceSingleNull(SObject[] array, SObject element) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        array[i] = element;
        return array;
      }
    }
    return null;
  }

  // IDK you copied some code from online
  public static Object[] pop(Object[] arr, int index) {
    if (arr == null || index < 0 || index >= arr.length) {
      return arr;
    }
    Object[] otherArray = new Object[arr.length];
    for (int i = 0, k = 0; i < arr.length; i++) {
      if (i == index) {
        continue;
      }
      otherArray[k++] = arr[i];
    }
    return otherArray;
  }

  // Stringify an array.
  public static String arrayToString(Object[] array) {
    String s = array.toString() + "[";
    short threeDots = (short) 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        s += "null, ";
      } else {
        s += array[i].toString() + ", ";
      }
      if (i > 0) {
        if (array[i] == array[i-1]) {
          threeDots++;
        } else {
          threeDots = (short) 0;
        }
      }
      if (threeDots >= Const.ARRAY_FORMAT_SAME_ELEMENT_LIMIT) {
        return s + "...]";
      }
    }
    return s.substring(0, s.length() - 2) + "]";
  }

  // Duplicate a SObject array without worring about reference types.
  public static SObject[] copyArray(SObject[] array) {
    SObject[] o = new SObject[array.length];
    for (int i = 0; i < o.length; i++) {
      SObject obj = array[i];
      if (obj == null) {
        o[i] = null;
      } else {
        o[i] = array[i].copy();
      }
    }
    return o;
  }

  public static int min(int x, int y) {
    return (x < y) ? x : y;
  }

  public static SColor getRandomColor() {
    return new SColor(getRandom(256), getRandom(256), getRandom(256));
  }

  public static int getRandom(int max) {
    return (int)(Math.random() * max);
  }
}
// The ONLY changes allowed in this class are optimization and adding functions!
