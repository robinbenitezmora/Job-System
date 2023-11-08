package employ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import employ.JobDetail;
import java.util.Scanner;

/******************************** MENU ****************************/

class MainMenu {
  public void menu() {
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t  JOB SYSTEM");
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\t\t\t     ~$ Robin Benitez");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\n\n Click on 1: To Add a Job Details");
    System.out.println(" Click on 2: To View Job Details");
    System.out.println(" Click on 3: To Delete Job Details");
    System.out.println(" Click on 4: To Update Job Details");
    System.out.println(" Click on 5: To Exit");
  }
}

/************************ To add details of the Job *********************/

class AddJob {
  public void createFile() {
    Scanner sc = Scanner(System.in);

    JobSystem job = new JobSystem();
    job.getInfo();

    try {
      File file = new File("file" + job.job_id + ".txt");
      if (file.createNewFile()) {
        FileWriter myWriter = new FileWriter("file" + job.job_id + ".txt");
        myWriter.write("Employee ID: " + job.job_id + "\n" + "Employee Name: " + job.name + "\n" + "Father's Name: "
            + job.father_name + "\n" + "Employee Contact: " + job.job_contact + "\n" + "Email Information: "
            + job.job_email
            + "\n" + "Employee Position: " + job.position + "\n" + "Employee Salary: " + job.job_salary);
        myWriter.close();
        System.out.println("\nEmployee has been Created: )\n");

        System.out.println("\nPress Enter to Continue...");
        sc.nextLine();
      } else {
        System.out.println("\nEmployee already exists.\n");
      }
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private Scanner Scanner(InputStream in) {
    return null;
  }

}

/************************ To View details of the Job *********************/

public class JobDetail {

  public String job_id;
  public String name;
  public String father_name;
  public String job_contact;
  public String job_email;
  public String job_salary;
  public String position;

  public void getInfo() {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println("\nEnter Employee ID: ");
      job_id = sc.nextLine();

      System.out.println("\nEnter Employee Name: ");
      name = sc.nextLine();

      System.out.println("\nEnter Father's Name: ");
      father_name = sc.nextLine();

      System.out.println("\nEnter Employee Contact: ");
      job_contact = sc.nextLine();

      System.out.println("\nEnter Email Information: ");
      job_email = sc.nextLine();

      System.out.println("\nEnter Employee Position: ");
      position = sc.nextLine();

      System.out.println("\nEnter Employee Salary: ");
      job_salary = sc.nextLine();
    }
  }

  /************************ To Show details of Job *********************/

  class JobShow {
    public void viewFile(String s) throws Exception {
      File file = new File("file" + s + ".txt");
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String data = sc.nextLine();
        System.out.println(data);
      }
      sc.close();
    }
  }
}

/************************ To Delete details of Job *********************/

class DeleteJob {
  public void deleteFile(String ID) {
    File file = new File("file" + ID + ".txt");
    if (file.exists()) {
      if (file.delete()) {
        System.out.println("\nEmployee has been Deleted: )\n");
      } else {
        System.out.println("\nFailed to Delete Employee.\n");
      }
    } else {
      System.out.println("\nEmployee does not exist.\n");
    }
  }
}

/************************ To Update details of Job *********************/

class UpdateJob {
  public void updateFile(String s, String o, String n) throws IOException {
    File file = new File("file" + s + ".txt");
    try (Scanner sc = new Scanner(file)) {
      StringBuffer inputBuffer = new StringBuffer();
      while (sc.hasNextLine()) {
        inputBuffer.append(sc.nextLine());
        inputBuffer.append('\n');
      }
      FileWriter myWriter = new FileWriter("file" + s + ".txt");
      String inputStr = inputBuffer.toString();
      myWriter.write(inputStr.replace(o, n));
      myWriter.close();
    }
  }
}

/************************ To Exit details of Job *********************/

class Exit {
  public void exit() {
    System.out.println("\n*****************************************");
    System.out.println("\t\t  Thank you for Using my Application");
    System.out.println("\t\t\t  Have a Nice Day");
    System.out.println("\n*****************************************");
    System.out.println("\t\t\t    ~$ Robin Benitez");
    System.exit(0);
  }
}

/***************************** Main Class *******************************/

public class JobSystem {
  public String position;
  public String job_salary;
  public String job_email;
  public String father_name;
  public String job_contact;
  public String name;
  public String job_id;

  public static void main(String[] args) throws Exception {
    try (Scanner sc = new Scanner(System.in)) {
      MainMenu menu = new MainMenu();
      AddJob add = new AddJob();
      JobDetail job = new JobDetail();
      JobDetail.JobShow show = job.new JobShow();
      DeleteJob delete = new DeleteJob();
      UpdateJob update = new UpdateJob();
      Exit exit = new Exit();

      while (true) {
        menu.menu();
        System.out.println("\n\nEnter your Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
          case 1:
            add.createFile();
            break;
          case 2:
            System.out.println("\nEnter Employee ID: ");
            String s = sc.next();
            show.viewFile(s);
            System.out.println("\nPress Enter to Continue...");
            sc.nextLine();
            sc.nextLine();
            break;
          case 3:
            System.out.println("\nEnter Employee ID: ");
            String ID = sc.next();
            delete.deleteFile(ID);
            System.out.println("\nPress Enter to Continue...");
            sc.nextLine();
            sc.nextLine();
            break;
          case 4:
            System.out.println("\nEnter Employee ID: ");
            String id = sc.next();
            System.out.println("\nEnter Old Information: ");
            String o = sc.next();
            System.out.println("\nEnter New Information: ");
            String n = sc.next();
            update.updateFile(id, o, n);
            System.out.println("\nPress Enter to Continue...");
            sc.nextLine();
            sc.nextLine();
            break;
          case 5:
            exit.exit();
            break;
          default:
            System.out.println("\nInvalid Choice.\n");
            break;
        }
      }
    }
  }

  public void getInfo() {
  }
}
