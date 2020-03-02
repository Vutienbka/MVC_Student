package MVC_Student.StudentService;

import MVC_Student.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentService implements I_StudentService {
    private static Map<Integer,Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1,new Student(1,"Vu Hoang", "vuhoang@gmail.com","Ha Noi","20-02-2000",
                "https://image.shutterstock.com/image-photo/close-isolated-portrait-cheerful-happy-260nw-763024246.jpg"));
        studentMap.put(2,new Student(2,"Nguyen Lanh", "lanhhanoi@gmail.com","Ha Noi","20-02-2000",
                "https://media.gettyimages.com/photos/portrait-of-smiling-young-man-wearing-eyeglasses-picture-id985138634?s=612x612"));
        studentMap.put(3,new Student(3,"Vu Hoang Nam", "hoangnamhaiphong@gmail.com","Hai Phong","20-02-2000",
                "https://upload.wikimedia.org/wikipedia/commons/f/f5/Poster-sized_portrait_of_Barack_Obama.jpg"));
        studentMap.put(4,new Student(4,"Nguyen Thi Tuyet", "nguyentuyet@gmail.com","Nam Dinh","20-02-2000",
                "https://images.pexels.com/photos/1130626/pexels-photo-1130626.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        studentMap.put(5,new Student(5,"Vu Hoang Linh", "hoanglinh@gmail.com","Sai Gon","20-02-2000",
                "https://lifetouch.com/wp-content/uploads/2018/06/seniorTB.jpg"));
    }
    @Override
    public ArrayList<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public Student findById(int Id) {
        Iterator<Map.Entry<Integer,Student>> entrySetKey = studentMap.entrySet().iterator();
        while(entrySetKey.hasNext()){
            Map.Entry<Integer, Student> currentEntry = entrySetKey.next();
            if(currentEntry.getKey()==Id)return currentEntry.getValue();
        }
        return null;
    }

    @Override
    public void update(int Id, Student student) {
        Iterator<Map.Entry<Integer,Student>> entrySetKey = studentMap.entrySet().iterator();
        while(entrySetKey.hasNext()){
            Map.Entry<Integer, Student> currentEntry = entrySetKey.next();
            if(currentEntry.getKey()==Id) {
                currentEntry.setValue(student);
            }
        }
    }

    @Override
    public void remove(int Id) {
        Iterator<Map.Entry<Integer,Student>> entrySetKey = studentMap.entrySet().iterator();
        while(entrySetKey.hasNext()){
            Map.Entry<Integer, Student> currentEntry = entrySetKey.next();
            if(currentEntry.getKey()==Id) {
                entrySetKey.remove();
            }
        }
    }
}
