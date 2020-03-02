package MVC_Student.Controller;

import MVC_Student.StudentService.StudentService;
import MVC_Student.Model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet",urlPatterns = {"/"})
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    ArrayList<Student> studentList = studentService.findAll();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            action="";
        }

        switch (action){
            case "create":
                createNewStudent(request,response);
                System.out.println("HAha");
                break;
            case "edit":
                editStudent(request,response);
                System.out.println("hihihi");
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                listStudent(request,response);
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
            case "view":
                viewStudent(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                System.out.println("hihi");
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            default:listStudent(request,response);
            break;
        }
    }

    public void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("MVC_List.jsp");
        request.setAttribute("studentList",studentList);
        dispatcher.forward(request,response);
    }
    public void createNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String image = request.getParameter("img");
        Student newStudent= new Student(Id,name,email,address,dateOfBirth,image);
        studentService.save(newStudent);
        studentList = studentService.findAll();

        String message = "New student is created";
        PrintWriter writer = response.getWriter();
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("MVC_Create.jsp");
        request.setAttribute("message",message);
        dispatcher.forward(request,response);
        */
        writer.println("<script type=\"text/javascript\">");
        writer.println("alert(\"" +message+ "\")");
        writer.println("location='MVC_Create.jsp';");
        writer.println("</script>");
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("MVC_Create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int Id = Integer.parseInt(String.valueOf(request.getParameter("Id")));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String image = request.getParameter("img");
        studentList = studentService.findAll();

        Student student = this.studentService.findById(Id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            student.setId(Id);
            student.setName(name);
            student.setEmail(email);
            student.setAddress(address);
            student.setDateOfBirth(dateOfBirth);
            student.setImage(image);
            this.studentService.update(Id, student);
            request.setAttribute("student", student);
            request.setAttribute("message", "Student information was updated");
            dispatcher = request.getRequestDispatcher("MVC_Edit.jsp");
        }
        try {
            dispatcher.forward(request, response);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        Student student = this.studentService.findById(Id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("MVC_Edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        Student student = this.studentService.findById(Id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            this.studentService.remove(Id);
            try {
                studentList = studentService.findAll();
                listStudent(request,response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        Student student = this.studentService.findById(Id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("MVC_Delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        Student student = this.studentService.findById(Id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("MVC_View.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
