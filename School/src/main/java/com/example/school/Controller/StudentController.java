package com.example.school.Controller;


import com.example.school.Model.Student;
import com.example.school.Services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentAPI;
    @GetMapping("/all")
    public ResponseEntity getAll(){return ResponseEntity.status(200).body(studentAPI.getAll());}

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Student student, Errors er){
        if (!er.hasErrors())
        {
            studentAPI.add(student);
            return ResponseEntity.status(201).body("Student Added Successfully!!");
        }
        else
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
    }
    @GetMapping("/getByID/{studentID}")
    public ResponseEntity getStudent(@PathVariable int studentID){

        if(studentAPI.isStu(studentID))
            return ResponseEntity.status(200).body(studentAPI.getStudent(studentID));
        else
            return ResponseEntity.status(400).body("Student doesn't exist !");

    }
    @GetMapping("/getByName/{studentName}")
    public ResponseEntity getStuByName(@PathVariable String studentName){

        return ResponseEntity.status(200).body(studentAPI.getStuByName(studentName));

    }
    @PutMapping("/update/{stuID}")
    public ResponseEntity updateStudent(@PathVariable int stuID, @RequestBody @Valid Student student){

        if(studentAPI.isStu(stuID))
            return ResponseEntity.status(202).body(studentAPI.updateStudent(student));
        else
            return ResponseEntity.status(400).body("Student doesn't exist !");
    }
    @DeleteMapping("/delete/{studentID}")
    public ResponseEntity delStu(@PathVariable int studentID){

        if(studentAPI.isStu(studentID))
            return ResponseEntity.status(202).body(studentAPI.delStu(studentID));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");
    }


    @GetMapping("/getByMajor/{studentMajor}")
    public ResponseEntity getStu(@PathVariable String studentMajor){

        if(studentAPI.isMajor(studentMajor))
            return ResponseEntity.status(200).body(studentAPI.getStuMajoredIn(studentMajor));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");

    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity getStuByAge(@PathVariable int age){

        return ResponseEntity.status(200).body(studentAPI.getStudentOver(age));

    }


}
