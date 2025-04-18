package Salary_Management_System;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class salaryRaise implements Raiseable {

    @Override
    public void create(String fileName) {
        try {
            PrintWriter fileOut = new PrintWriter(fileName); 
            fileOut.flush();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display(String fileName) {
        try {
            Scanner fileIn = new Scanner(Paths.get(fileName));
            String line;
            while (fileIn.hasNext()) {
                line = fileIn.nextLine();
                System.out.println(line);
            }
            fileIn.close();
        } 
        catch (NoSuchFileException e) {} 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean addTo(String inFileName, String outFileName, int id, double salary, int yearsOfService) {
        try {
            Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);
            boolean b = false;
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                if (!b) {
                    int index = line.indexOf(':');
                    if (index > 0) {
                        String lineID = line.substring(0, index);
                        int lineIDint = Integer.parseInt(lineID);
                        if (lineIDint == id) {
                            return false;
                        } else if (lineIDint < id) {
                            fileOut.println(line);
                        } else {
                            fileOut.printf("%d:%.2f:%d", id, salary, yearsOfService);
                            fileOut.println();
                            fileOut.println(line);
                            b = true;
                        }
                    }
                } else {
                    fileOut.println(line);
                }
            }
            if (!b) {
                fileOut.printf("%d:%.2f:%d", id, salary, yearsOfService);
                fileOut.println();
            }
            fileOut.flush();
            fileOut.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeFrom(String inFileName, String outFileName, int id) {
        boolean b = false;
        try {
            Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                if (!b) {
                    int index = line.indexOf(':');
                    if (index > 0) {
                        String lineID = line.substring(0, index);
                        int lineIDint = Integer.parseInt(lineID);
                        if (lineIDint == id) {
                            b = true;
                        } else {
                            fileOut.println(line);
                        }
                    }
                } else {
                    fileOut.println(line);
                }
            }
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }

    @Override
    public void addService(String inFileName, String outFileName) {
        try {
            Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                int index = line.lastIndexOf(':');
                String YOSstring = line.substring(index + 1);
                int lineYOS = Integer.parseInt(YOSstring);
                ++lineYOS;
                fileOut.printf("%s:%d", line.substring(0, index), lineYOS);
                fileOut.println();
            }
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int raise(String inFileName, String outFileName, int yearsOfService, double salaryIncPercent) {
        int recordUpdate = 0; 
        try {
            Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                int index = line.lastIndexOf(':');
                String YOSstring = line.substring(index + 1);
                int lineYOS = Integer.parseInt(YOSstring);
                if (lineYOS == yearsOfService) {
                    int index1 = line.indexOf(':');
                    String salary = line.substring(index1 + 1, index);
                    double salaryD = Double.parseDouble(salary);
                    salaryD = salaryD + salaryD * (salaryIncPercent / 100); 
                    fileOut.printf("%s:%.2f:%d", line.substring(0, index1), salaryD, lineYOS);
                    fileOut.println();
                    ++recordUpdate;
                } else {
                    fileOut.println(line);
                }
            }
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recordUpdate;
    }

    @Override
    public void mergeFiles(String inFileName1, String inFileName2, String outFileName) {
        try {
            Scanner fileIn1 = new Scanner(Paths.get(inFileName1));
            Scanner fileIn2 = new Scanner(Paths.get(inFileName2));
            PrintWriter fileOut = new PrintWriter(outFileName);

            String line1 = null;
            int line1LeftIdx = -1;
            int id1 = 0;

            String line2 = null;
            int line2LeftIdx = -1;
            int id2 = 0;

            while ((fileIn1.hasNextLine() || line1 != null) && (fileIn2.hasNextLine() || line2 != null)) {
                if (line1 == null) {
                    line1 = fileIn1.nextLine();
                    line1LeftIdx = line1.indexOf(':');
                    id1 = Integer.parseInt(line1.substring(0, line1LeftIdx));
                }
                if (line2 == null) {
                    line2 = fileIn2.nextLine();
                    line2LeftIdx = line2.indexOf(':');
                    id2 = Integer.parseInt(line2.substring(0, line2LeftIdx));
                }

                if (id1 < id2) {
                    fileOut.println(line1);
                    line1 = null;
                } else if (id1 > id2) {
                    fileOut.println(line2);
                    line2 = null;
                } else {
                    int line1RightIdx = line1.lastIndexOf(':');
                    int line2RightIdx = line2.lastIndexOf(':');

                    double salary1 = Double.parseDouble(line1.substring(line1LeftIdx + 1, line1RightIdx));
                    double salary2 = Double.parseDouble(line2.substring(line2LeftIdx + 1, line2RightIdx));

                    if (salary1 >= salary2) {
                        fileOut.println(line1);
                    } else {
                        fileOut.println(line2);
                    }
                    line1 = null;
                    line2 = null;
                }
            }

            if (line1 != null) fileOut.println(line1);
            while (fileIn1.hasNextLine()) fileOut.println(fileIn1.nextLine());
            if (line2 != null) fileOut.println(line2);
            while (fileIn2.hasNextLine()) fileOut.println(fileIn2.nextLine());

            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}