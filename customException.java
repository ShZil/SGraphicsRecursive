class CustomException extends Exception {
  // you gotta have an excuse for this
  String excuse;

  public CustomException(String excuse) {
    this.excuse = excuse;
  }

  public String toString() {
    return "Exception: " + this.excuse;
  }
}
