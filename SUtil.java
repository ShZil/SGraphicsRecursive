class SUtil {
  public static final int CONSTANT_LENGTH = 0;
  public static final int AFTER_DOT_LIMIT = 1;

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

  public static int min(int x, int y) {
    return (x < y) ? x : y;
  }

  public static SColor getRandomColor() {
    return new SColor(getRandom(256), getRandom(256), getRandom(256));
  }

  public static int getRandom(int max) {
    return (int)(Math.random() * max);
  }

  public static String formatNumber(int number, int more, int mode) {
    String out = "";
    switch (mode) {
      case SUtil.CONSTANT_LENGTH:
        out = multiplyString("0", Math.abs(more - String.valueOf(number).length())) + String.valueOf(number);
        break;
    }
    return out;
  }

  public static String formatNumber(double number, int more, int mode) {
    String out = "";
    switch (mode) {
      case SUtil.AFTER_DOT_LIMIT:
        int multiplier = (int)Math.pow(10, more);
        double simplerDouble = ((int)(number * multiplier)) / (double)multiplier;
        out = String.valueOf(simplerDouble);
        break;
    }
    return out;
  }

  public static String multiplyString(String s, int m) {
    String t = "";
    for (int i = 0; i < m; i++) {
      t += s;
    }
    return t;
  }

  public static int constrain(int val, int min, int max) {
    if (val > max) {
      return max;
    }
    if (val < min) {
      return min;
    }
    return val;
  }

  public static int constrainColor(int val, int min, int max, boolean doSigmoid) {
    if (val > max) {
      return max;
    }
    if (val < min) {
      return min;
    }
    if (doSigmoid) {
      return (int)(sigmoid(val / 16.0)*255);
    } else {
      return val;
    }
  }

  public static double sigmoid(double val) {
    return val / Math.pow(1 + Math.pow(val, 2), 0.5);
  }
}
// The ONLY changes allowed in this class are optimization and adding functions!
