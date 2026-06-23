public class TaskManagement {
    static class Task {
        int taskId;
        String taskName;
        String status;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId; this.taskName = taskName; this.status = status;
        }

        public String toString() { return String.format("%d:%s[%s]", taskId, taskName, status); }
    }

    static class TaskList {
        private static class Node { Task t; Node next; Node(Task t){this.t=t;} }
        private Node head;

        public void add(Task t) {
            Node n = new Node(t);
            n.next = head; head = n;
        }

        public Task search(int taskId) {
            Node cur = head;
            while (cur != null) { if (cur.t.taskId == taskId) return cur.t; cur = cur.next; }
            return null;
        }

        public void traverse() { Node cur = head; while (cur != null) { System.out.println(cur.t); cur = cur.next; } }

        public boolean delete(int taskId) {
            Node cur = head, prev = null;
            while (cur != null) {
                if (cur.t.taskId == taskId) {
                    if (prev == null) head = cur.next; else prev.next = cur.next;
                    return true;
                }
                prev = cur; cur = cur.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TaskList tl = new TaskList();
        tl.add(new Task(1, "Write tests", "open"));
        tl.add(new Task(2, "Deploy", "open"));
        System.out.println("Traverse:"); tl.traverse();
        System.out.println("Search 1: " + tl.search(1));
        tl.delete(2);
        System.out.println("After delete:"); tl.traverse();
    }
}
