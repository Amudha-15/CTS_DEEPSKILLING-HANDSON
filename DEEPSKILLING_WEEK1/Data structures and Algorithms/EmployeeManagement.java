import java.util.Arrays;

public class EmployeeManagement {
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() { return String.format("%d:%s(%s)=%.2f", employeeId, name, position, salary); }
    }

    static class EmployeeArray {
        private Employee[] arr;
        private int size = 0;

        EmployeeArray(int capacity) { arr = new Employee[capacity]; }

        public boolean add(Employee e) {
            if (size >= arr.length) return false;
            arr[size++] = e; return true;
        }

        public Employee search(int employeeId) {
            for (int i = 0; i < size; i++) if (arr[i].employeeId == employeeId) return arr[i];
            return null;
        }

        public void traverse() { for (int i = 0; i < size; i++) System.out.println(arr[i]); }

        public boolean delete(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (arr[i].employeeId == employeeId) {
                    System.arraycopy(arr, i+1, arr, i, size - i - 1);
                    arr[--size] = null; return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeArray ea = new EmployeeArray(10);
        ea.add(new Employee(1, "John", "Engineer", 70000));
        ea.add(new Employee(2, "Mary", "Manager", 90000));
        System.out.println("Traverse:"); ea.traverse();
        System.out.println("Search id=2: " + ea.search(2));
        ea.delete(1);
        System.out.println("After delete:"); ea.traverse();
    }
}
