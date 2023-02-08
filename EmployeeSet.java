public class EmployeeSet {
  private Employee[] storage;
  private int manyEmployee;
  private int capacity;

  public EmployeeSet() {
    storage = new Employee[10];
    capacity = 10;
    manyEmployee = 0;
  }

  public int size() {
    return manyEmployee;
  }

  public int capacity() {
    return capacity;
  }

  public void add(Employee a) {
    // TODO
  }

  public boolean remove(int eid) {
    // TODO remeve emploeyee with ID
    boolean removed = false;

    return removed;
  }

  private void ensureCapacity(int minimumCapacity) {

  }

  public boolean contains(int eid) {
    // TODO ceck if emplyee with eid ID is in the colection

    boolean isPresent = false;

    return isPresent;
  }

}