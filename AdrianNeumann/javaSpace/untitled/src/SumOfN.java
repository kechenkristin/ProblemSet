import java.util.Scanner;

@FunctionalInterface
interface Condition {
    boolean satisfy(int i);
}

class Task {
    // constructor
    Condition condition;
    boolean sumFlag;
    boolean productFlag;
    int n;
    int option;

    public Task(Condition condition) {
        this.condition = condition;
    }

    public void getN() {
        Scanner scanner = new Scanner(System.in);  // create a Scanner object
        System.out.println("Enter your a number: ");
        n = scanner.nextInt();
    }

    public void getOption() {
        while (true) {
            Scanner scanner = new Scanner(System.in);  // create a Scanner object
            System.out.println("Choose your option, type 0 for sum, 1 for product: ");
            option = scanner.nextInt();

            if (option == 0) {
                sumFlag = true;
                return;
            } else if (option == 1) {
                productFlag = true;
                return;
            }
            System.out.println("You choose the wrong option!");
        }
    }


    public int getProduct(int n) {
        int pro = 1;

        for (int i = 1; i <= n; i++) {
            if (condition.satisfy(i)) pro *= i;
        }

        return pro;
    }


    public int getSum(int n) {
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            if (condition.satisfy(i)) sum += i;
        }

        return sum;
    }

    public int getResult() {
        System.out.println("Calculation complete...");
        if (sumFlag) return getSum(n);
        if (productFlag) return getProduct(n);
        return 0;
    }

    public int execute() {
        System.out.println("Calculating...");
        getN();
        getOption();
        return getResult();
    }

    public static void main(String[] args) {
        Condition nonCon = (i) -> true;
        Task task = new Task(nonCon);
        System.out.println(task.execute());
    }
}