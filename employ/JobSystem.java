package employ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
  public void add() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Job ID: ");
    int id = sc.nextInt();
    System.out.println("Enter the Job Title: ");
    String title = sc.next();
    System.out.println("Enter the Job Description: ");
    String description = sc.next();
    System.out.println("Enter the Job Location: ");
    String location = sc.next();
    System.out.println("Enter the Job Salary: ");
    int salary = sc.nextInt();
    System.out.println("Enter the Job Company: ");
    String company = sc.next();
    System.out.println("Enter the Job Skills: ");
    String skills = sc.next();
    System.out.println("Enter the Job Experience: ");
    String experience = sc.next();
    System.out.println("Enter the Job Qualification: ");
    String qualification = sc.next();
    System.out.println("Enter the Job Posted Date: ");
    String postedDate = sc.next();
    System.out.println("Enter the Job Last Date: ");
    String lastDate = sc.next();
    System.out.println("Enter the Job Contact: ");
    String contact = sc.next();
    System.out.println("Enter the Job Email: ");
    String email = sc.next();
    System.out.println("Enter the Job Website: ");
    String website = sc.next();
    System.out.println("Enter the Job Status: ");
    String status = sc.next();
    System.out.println("Enter the Job Type: ");
    String type = sc.next();
    System.out.println("Enter the Job Category: ");
    String category = sc.next();
    System.out.println("Enter the Job Vacancy: ");
    int vacancy = sc.nextInt();
    System.out.println("Enter the Job Company Description: ");
    String companyDescription = sc.next();
    System.out.println("Enter the Job Company Address: ");
    String companyAddress = sc.next();
    System.out.println("Enter the Job Company Contact: ");
    String companyContact = sc.next();
    System.out.println("Enter the Job Company Email: ");
    String companyEmail = sc.next();
    System.out.println("Enter the Job Company Website: ");
    String companyWebsite = sc.next();
    System.out.println("Enter the Job Company Logo: ");
    String companyLogo = sc.next();
    System.out.println("Enter the Job Company Video: ");
    String companyVideo = sc.next();
    System.out.println("Enter the Job Company Map");
    String companyMap = sc.next();
    System.out.println("Enter the Job Company Map Address: ");
    String companyMapAddress = sc.next();
    System.out.println("Enter the Job Company Map Latitude: ");
    String companyMapLatitude = sc.next();

    try {
      File file = new File("job.txt");
      FileWriter fw = new FileWriter(file, true);
      fw.write(id + " " + title + " " + description + " " + location + " " + salary + " " + company + " " + skills + " "
          + experience + " " + qualification + " " + postedDate + " " + lastDate + " " + contact + " " + email + " "
          + website + " " + status + " " + type + " " + category + " " + vacancy + " " + companyDescription + " "
          + companyAddress + " " + companyContact + " " + companyEmail + " " + companyWebsite + " " + companyLogo + " "
          + companyVideo + " " + companyMap + " " + companyMapAddress + " " + companyMapLatitude + "\n");
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/************************ To view details of the Job *********************/

class ViewJob {
  public void view() {
    try {
      File file = new File("job.txt");
      try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
          System.out.println(sc.nextLine());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/************************ To delete details of the Job *********************/

class DeleteJob {
  public void delete() {
    try {
      File file = new File("job.txt");
      try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
          System.out.println(sc.nextLine());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/************************ To update details of the Job *********************/

class UpdateJob {
  public void update() {
    try {
      File file = new File("job.txt");
      try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
          System.out.println(sc.nextLine());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/************************ To exit from the Job System *********************/

class ExitJob {
  public void exit() {
    System.out.println("Thank you for using the Job System");
    System.exit(0);
  }
}

/************************
 * To select the option from the menu
 *********************/

class JobSystem {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      MainMenu m = new MainMenu();
      AddJob a = new AddJob();
      ViewJob v = new ViewJob();
      DeleteJob d = new DeleteJob();
      UpdateJob u = new UpdateJob();
      ExitJob e = new ExitJob();
      int option;
      do {
        m.menu();
        System.out.println("Enter your option: ");
        option = sc.nextInt();
        switch (option) {
          case 1:
            a.add();
            break;
          case 2:
            v.view();
            break;
          case 3:
            d.delete();
            break;
          case 4:
            u.update();
            break;
          case 5:
            e.exit();
            break;
          default:
            System.out.println("Invalid option");
            break;
        }
      } while (option != 5);
    }
  }
}

/******************************** END ****************************/