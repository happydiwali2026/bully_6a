import java.util.Scanner;

public class Bully
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Enter number of processes:");
        n = sc.nextInt();

        int processes[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            processes[i] = i + 1;
        }

        int coordinator = n;

        System.out.println(
        "Current Coordinator is P" + coordinator);

        System.out.println(
        "Enter process which will fail:");

        int fail = sc.nextInt();

        System.out.println(
        "Process P" + fail + " failed");

        if(fail == coordinator)
        {
            System.out.println(
            "Election started");

             int newCoordinator = fail - 1;

            for(int i = 0; i < n; i++)
            {
                if(processes[i] > fail)
                {
                    System.out.println(
                    "Election message sent from P"
                    + fail + " to P"
                    + processes[i]);

                    newCoordinator = processes[i];
                }
            }

            coordinator = newCoordinator;

            System.out.println(
            "New Coordinator is P"
            + coordinator);
        }
        else
        {
            System.out.println(
            "Coordinator alive, no election");
        }

        sc.close();
    }
}