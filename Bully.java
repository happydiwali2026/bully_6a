import java.util.Scanner;

class Bully_Algo
{
    static boolean[] state = {true, true, true, true, true};
    static int coordinator = 5;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("Processes are:");
        System.out.println("P1 P2 P3 P4 P5");

        System.out.println("Initial Coordinator is P5");

        do
        {
            System.out.println("\n1. Down Process");
            System.out.println("2. Up Process");
            System.out.println("3. Start Election");
            System.out.println("4. Display Coordinator");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:

                    System.out.print("Enter process to DOWN: ");
                    int down = sc.nextInt();

                    if(state[down - 1])
                    {
                        state[down - 1] = false;

                        System.out.println("Process P" +
                                           down + " is DOWN");

                        if(down == coordinator)
                        {
                            System.out.println(
                            "Coordinator failed");

                            for(int i = 5; i >= 1; i--)
                            {
                                if(state[i - 1])
                                {
                                    election(i);
                                    break;
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println(
                        "Process already DOWN");
                    }

                    break;

                case 2:

                    System.out.print("Enter process to UP: ");
                    int up = sc.nextInt();

                    if(!state[up - 1])
                    {
                        state[up - 1] = true;

                        System.out.println(
                        "Process P" + up + " is UP");

                        System.out.println(
                        "P" + up +
                        " starts election automatically");

                        election(up);
                    }
                    else
                    {
                        System.out.println(
                        "Process already UP");
                    }

                    break;

                case 3:

                    System.out.print(
                    "Enter process starting election: ");

                    int process = sc.nextInt();

                    election(process);

                    break;

                case 4:

                    System.out.println(
                    "Current Coordinator is P"
                    + coordinator);

                    break;

                case 5:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }

    static void election(int process)
    {
        if(!state[process - 1])
        {
            System.out.println(
            "Process P" + process +
            " is DOWN");

            return;
        }

        System.out.println(
        "\nElection started by P" + process);

        for(int i = process + 1; i <= 5; i++)
        {
            if(state[i - 1])
            {
                System.out.println(
                "Election message sent from P"
                + process + " to P" + i);

                System.out.println(
                "Alive message sent from P"
                + i + " to P" + process);
            }
        }

        for(int i = 5; i >= 1; i--)
        {
            if(state[i - 1])
            {
                coordinator = i;
                break;
            }
        }

        System.out.println(
        "Coordinator message sent by P"
        + coordinator + " to all processes");

        System.out.println(
        "New Coordinator is P"
        + coordinator);
    }
}
