package employ;

import java.io.File;
import java.io.FileWriter;
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
 public void createFile() {
  Scanner sc = Scanner(System.in);

  JobDetail job = new JobDetail();
  job.getInfo();

  try {
   File file = new File("file" + job.job_id + ".txt");
   if (file.createNewFile()) {
    FileWriter myWriter = new FileWriter("file" + job.job_id + ".txt");
    myWriter.write("Employee ID: " + job.job_id + "\n" + "Employee Name: " + job.name + "\n" + "Father's Name: "
      + job.father_name + "\n" + "Employee Contact: " + job.job_contact + "\n" + "Email Information: " + job.email
      + "\n" + "Employee Position: " + job.position + "\n" + "Employee Salary: " + job.salary);
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