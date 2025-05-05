package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.ImageHtmlEmail;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.Base_Class;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class extentReportManager implements ITestListener
{

        public String timestamp= new SimpleDateFormat("yyyy-MM-DD-HH-mm-ss").format(new Date());
        public ExtentSparkReporter sparkReporter;
        public ExtentReports extent;
        public ExtentTest test;
        public String report= "C://Users//ADMIN//IdeaProjects//New Traveluro Automation//reports/" + timestamp+ ".html";


        public void onStart(ITestContext context)
        {
                sparkReporter = new ExtentSparkReporter(report);
                sparkReporter.config().setDocumentTitle("");
                sparkReporter.config().setReportName("");
                sparkReporter.config().setTheme(Theme.DARK);

                extent= new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("Website", "Traveluro");
                extent.setSystemInfo("Environment", "Prod");
                extent.setSystemInfo("Tester name", System.getProperty("user.name"));
                extent.setSystemInfo("Module", "Login");

                String os= context.getCurrentXmlTest().getParameter("os");
                extent.setSystemInfo("Operating System", os);

                String browser= context.getCurrentXmlTest().getParameter("browser");
                extent.setSystemInfo("Browser", browser);

                List<String> includegroups= context.getCurrentXmlTest().getExcludedGroups();
                if(!includegroups.isEmpty())
                {
                        extent.setSystemInfo("Groups", includegroups.toString());
                }

        }

        public void onTestSuccess(ITestResult result)
        {
                test=extent.createTest(result.getTestClass().getName());
                test.assignCategory(result.getMethod().getGroups()); //to display group in reports
                test.log(Status.PASS,  result.getName() + "got successfully executed");
        }

        public void onTestFailure(ITestResult result)
        {
                test=extent.createTest(result.getTestClass().getName());
                test.assignCategory(result.getMethod().getGroups()); //to display group in reports

                test.log(Status.FAIL, result.getName()+ "Test is failed");
                test.log(Status.INFO,"Test failed cause"+ result.getThrowable().getMessage());

                try
                {
                        String imgpath= new Base_Class().capturescreen(result.getName());
                        test.addScreenCaptureFromPath(imgpath);  //attach the image to the report
                }
                 catch (Exception e)
                {
                        e.printStackTrace();
                }



        }

        public void onTestSkipped(ITestResult result)
        {
                test=extent.createTest(result.getTestClass().getName());
                test.assignCategory(result.getMethod().getGroups());

                test.log(Status.SKIP, result.getName() + "Test is skipped:");
                test.log(Status.INFO,"Test Skip cause"+ result.getThrowable().getMessage());
        }

        public void onFinish(ITestContext context)
        {
                extent.flush();

                //for open the report automatically

                String pathofextentReport= report;
                File extentReport= new File(pathofextentReport);

                try
                {
                        Desktop.getDesktop().browse(extentReport.toURI());
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }


                //send report on email

//                try
//                {
//                        URL url= new URL(report);
//
//                        //create email message
//                        ImageHtmlEmail email= new ImageHtmlEmail();
//
//
//
//                } catch (Exception e)
//                {
//                        e.printStackTrace();
//                }


        }

}


