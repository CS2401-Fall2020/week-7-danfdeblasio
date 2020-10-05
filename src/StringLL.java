
public class StringLL {
  public String val;
  public StringLL next; 
  
  public static StringLL mergeSortLengths(StringLL inList) {
    if(inList == null) return null;
    if(inList.countElements() == 1) return inList;
    
    int leftSize = (inList.countElements()+1)/2;
    StringLL right = inList;
    for(int i=0; i<leftSize-1; i++) {
      right = right.next;
    }
    right = right.cut();
    
    inList = mergeSortLengths(inList);
    right = mergeSortLengths(right);
    
    StringLL outList = null;
    while(inList!=null && right!=null) {
      boolean left_shorter = inList.val.length() < right.val.length();
      boolean same_size = inList.val.length() == right.val.length();
      boolean left_first = inList.val.compareTo(right.val) < 0;
      if(left_shorter || (same_size && left_first)) {
        if(outList == null) outList = inList;
        else outList.append(inList);
        inList = inList.cut();
      }else {
        if(outList == null) outList = right;
        else outList.append(right);
        right = right.cut();
      }
    }
    if(inList != null) outList.append(inList);
    else if(right != null) outList.append(right);
    
    return outList;
    
  }
  
  public static StringLL quicksortLengths(StringLL stringListHead){
    if(stringListHead == null) return null;
    System.out.println(stringListHead.toString());
    if(stringListHead.countElements() == 1) return stringListHead;
    StringLL left = null;
    StringLL right = null;
    
    String pivot_value = stringListHead.val;
    StringLL pivot = stringListHead;
    stringListHead = stringListHead.next;
    pivot.next = null;
    
    while(stringListHead != null) {
      boolean middle_larger = (stringListHead.val.length() < pivot_value.length());
      boolean middle_same = (stringListHead.val.length() == pivot_value.length());
      boolean middle_after = (stringListHead.val.compareTo(pivot_value) <= 0);
      if(middle_larger || (middle_same && middle_after)) {
        if(left==null) left = stringListHead;
        else left.append(stringListHead);
      }else {
        if(right==null) right = stringListHead;
        else right.append(stringListHead);
      }
      StringLL temp = stringListHead.next;
      stringListHead.next = null;
      stringListHead = temp;
    }
    if(left == null) {
      left = pivot;
    } else if(right== null) {
      right = pivot;
    } else if(left.countElements() < right.countElements()) {
      left.append(pivot);
    } else {
      right.append(pivot);
    }
    left = quicksortLengths(left);
    right = quicksortLengths(right);
    left.append(right);
    return left;
  }
  
  public int countElements() {
    if(next == null) return 1;
    else return 1 + next.countElements();
  }
  
  public String toString() {
    if(next == null) return val;
    else return val + ", " + next.toString();
  }
  
  public void append(StringLL inNode) {
    if(next == null) next = inNode;
    else next.append(inNode);
  }
  
  public StringLL cut() {
    StringLL temp = next;
    next = null;
    return temp;
  }
  
}
