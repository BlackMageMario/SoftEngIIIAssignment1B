package year4.softeng3.assignment1.courseDriver;
import org.joda.time.LocalDate;
import year4.softeng3.assignment1.courseLib.*;
import year4.softeng3.assignment1.courseLib.Module;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class courseDriver {
    public static void main(String... args) {
        List<Student> testStudents = new ArrayList<>();
        testStudents.add(new Student("Aucaman Dilys", new LocalDate(1997, 8, 1), "15320210"));
        testStudents.add(new Student("Chrizanne Zubin", new LocalDate(1997, 10, 12), "15373953"));
        testStudents.add(new Student("Ruth Delayahu", new LocalDate(1996, 1, 4), "15341764"));
        testStudents.add(new Student("Ibbie Teresa", new LocalDate(1997, 8, 1), "15328257"));
        testStudents.add(new Student("Benedetto Yeshayahu", new LocalDate(1996, 3, 17), "15358207"));

        List<Module> testModules = new ArrayList<>();
        testModules.add(new Module("Computer Systems I", "CS100", testStudents));
        testModules.add(new Module("Programming I", "CS150", testStudents));
        testModules.add(new Module("Professional Skills I", "PS101", testStudents));
        testModules.add(new Module("Physics I", "SP101", testStudents));

        CourseProg testCourse = new CourseProg("CS and IT Year 1", new LocalDate(2018, 9, 1), new LocalDate(2019, 5, 8), testModules);

        printMessageFormatString("Course Info. Name: {0}. Start Date: {1}. End Date: {2}. \n",
                    testCourse.name, testCourse.getStartLocalDate(), testCourse.getEndLocalDate());

        for(Module mod: testCourse.getModules()) {
            printMessageFormatString(
                    "Module Info. Name: {0}. ID: {1}. \n", mod.name, mod.getId()
            );
            System.out.println("Info on each student: \n");
            for(Student student: mod.getStudents()) {
                printMessageFormatString(
                        "\tName: {0}. Username: {1}. ID: {2}. Date of birth: {3}. Age: {4}.", student.getName(), student.getUsername(),
                        student.getID(), student.getDOB(), student.getAge()
                );
            }
            System.out.print("\n");
        }

    }
    // Small func to help print MessageFormat string and avoid boilerplate
    public static void printMessageFormatString(String stringFormat, Object... args) {
        System.out.println(MessageFormat.format(stringFormat, args));
    }
}
