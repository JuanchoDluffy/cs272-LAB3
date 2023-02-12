import java.io.*;
import java.util.*;

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
    if (!contains(a.getID())) {
      if (manyEmployee == storage.length) {
        ensureCapacity(capacity * 2);
      }
      storage[manyEmployee] = a;
      manyEmployee++;
    }
  }

  public boolean remove(int targetID) {
    boolean removed = false;
    for (int index = 0; index < manyEmployee; index++) {
      if (storage[index].getID() == targetID) {
        manyEmployee--;
        storage[index] = storage[manyEmployee];
        removed = true;
      }
    }
    return removed;
  }

  private void ensureCapacity(int minimumCapacity) {
    if (capacity < minimumCapacity) {
      capacity = minimumCapacity;
      Employee[] minimumcap = new Employee[minimumCapacity];
      System.arraycopy(storage, 0, minimumcap, 0, manyEmployee);
      storage = minimumcap;
    }
  }

  public boolean contains(int eid) {
    boolean isPresent = false;
    for (int i = 0; i < manyEmployee; i++) {
      if (storage[i].getID() == eid) {
        isPresent = true;
      }
    }
    return isPresent;
  }

  public Employee getAtIndex(int f) {
    return storage[f];
  }

  public void writeToFile(String fileTarget) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new File(fileTarget))) {
      for (int x = 0; x < manyEmployee; x++) {
        writer.println(storage[x].toString());
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String csvFile = "core_dataset.csv";
    String line;
    String[] fields;

    EmployeeSet csvTest = new EmployeeSet();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      br.readLine();
      while ((line = br.readLine()) != null) {
        fields = line.split(",");

        String name = fields[0] + " " + fields[1]; // Combine first and last name
        name = (name.replaceAll("[^a-zA-Z0-9]", " ")).trim();
        int id = Integer.valueOf(fields[2]);
        String state = fields[3];
        int zip = Integer.valueOf(fields[4]);
        int age = Integer.valueOf(fields[5]);
        String advisor = fields[6];

        Employee current = new Employee();
        current.setName(name);
        current.setID(id);
        current.setState(state);
        current.setZipCode(zip);
        current.setAge(age);
        current.setAdvisor(advisor);
        csvTest.add(current);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    csvTest.writeToFile("store.csv");
  }
}
