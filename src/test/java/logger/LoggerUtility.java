package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LoggerUtility {

    //path-ul unde voi salva fisierele de loguri
    private static final String suiteLogsPath = "target/logs/suite/";
    //path-ul unde voi genera fisierul mare cu toate logurile
    private static final String regressionLogsPath = "target/logs/";

    private static final Logger logger = LogManager.getLogger();

    //vreau sa fac o metoda care ma asigura ca porneste un test
    public static synchronized void startTestCase(String testName) {
        ThreadContext.put("threadName", testName);
        logger.info("==========Execution started: " + testName + " ==========");
    }

    //metoda care se asigura ca a terminat un test
    public static synchronized void endTestCase(String testName) {
        logger.info("==========Execution finished: " + testName + " ==========");
    }

    //metoda care se asigura ca imi adauga un entry ca log
    public static synchronized void infoLog(String message) {
        logger.info(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    //metoda care se asigura ca logheaza o eroare
    public static synchronized void errorLog(String message) {
        logger.error(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    //metoda care se scoate informatii despre executia curenta
    private static synchronized String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + ":" + methodName + " ==> ";
    }

    //metoda care ia toate logurile si le pune intr-un singur fisier
    public static void mergeLogFilesIntoOne() {
        File dir = new File(suiteLogsPath);
        String[] fileNames = dir.list();

        try {
            PrintWriter pw = new PrintWriter(regressionLogsPath + "RegressionLogs.log");

            for (String fileName : fileNames) {
                System.out.println("Reading from " + fileName);
                File f = new File(dir, fileName);
                BufferedReader br = new BufferedReader(new FileReader(f));
                pw.println("Contents of file " + fileName);
                String line = br.readLine();
                while (line != null) {
                    pw.println(line);
                    line = br.readLine();
                }
                pw.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
