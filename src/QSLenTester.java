
public class QSLenTester {

  public static void main(String[] args) {
    StringLL current;

    
    StringLL example1 = new StringLL();
    example1.val = "DeBlasio";
    example1.next = new StringLL();
    example1.next.val = "Gastelum";
    example1.next.next = new StringLL();
    example1.next.next.val = "Flores";
    example1.next.next.next = new StringLL();
    example1.next.next.next.val = "Alvorado";
    example1.next.next.next.next = new StringLL();
    example1.next.next.next.next.val = "Berkowitz";
    example1 = StringLL.quicksortLengths(example1);
    assert(example1.val.equals("Flores"));
    assert(example1.next.val.equals("Alvorado"));
    assert(example1.next.next.val.equals("DeBlasio"));
    assert(example1.next.next.next.val.equals("Gastelum"));
    assert(example1.next.next.next.next.val.equals("Berkowitz"));
    
    StringLL example2 = new StringLL(); 
    example2.val = "AAAAA";
    example2.next = new StringLL();
    example2.next.val = "BBBB";
    example2.next.next = new StringLL();
    example2.next.next.val = "CCC";
    example2.next.next.next = new StringLL();
    example2.next.next.next.val = "DD";
    example2.next.next.next.next = new StringLL();
    example2.next.next.next.next.val = "E";
    example2 = StringLL.quicksortLengths(example2);
    assert(example2.val.equals("E"));
    assert(example2.next.val.equals("DD"));
    assert(example2.next.next.val.equals("CCC"));
    assert(example2.next.next.next.val.equals("BBBB"));
    assert(example2.next.next.next.next.val.equals("AAAAA"));
    
    StringLL example3 = new StringLL();
    example3.val = "A";
    example3.next = new StringLL();
    example3.next.val = "B";
    example3.next.next = new StringLL();
    example3.next.next.val = "C";
    assert(example3.countElements() == 3);
    assert(example3.next.countElements() == 2);
    assert(example3.next.next.countElements() == 1);
    current = example3;
    int ctr = 3;
    while(current != null) {
      assert(current.countElements() == ctr--);
    }
    
    StringLL example4 = new StringLL();
    example4.val = "A";
    example4.next = new StringLL();
    example4.next.val = "B";
    example4.next.next = new StringLL();
    example4.next.next.val = "C";
    assert(example4.toString().equals("A, B, C"));
    assert(example3.next.toString().equals("B, C"));
    assert(example3.next.next.toString().equals("C"));

    

  }

}
