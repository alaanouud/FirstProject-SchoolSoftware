package com.example.school.Controller;


import com.example.school.Model.Teacher;
import com.example.school.Services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController

{
    private final TeacherService TeacherAPI;
    @GetMapping("/all")
    public ResponseEntity getAll(){return ResponseEntity.status(200).body(TeacherAPI.getAll());}

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher, Errors er){
        if (!er.hasErrors())
        {
            TeacherAPI.add(teacher);
            return ResponseEntity.status(201).body("Teacher added successfully");
        }
        else
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
    }

    @GetMapping("/getByID/{TeacherID}")
    public ResponseEntity getTea(@PathVariable int TeacherID){

        if(TeacherAPI.isTeacher(TeacherID))
            return ResponseEntity.status(200).body(TeacherAPI.getTeacher(TeacherID));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");

    }
    @PutMapping("/update/{TeacherID}")
    public ResponseEntity updateTea(@PathVariable int TeacherID, @RequestBody @Valid Teacher Teacher){

        if(TeacherAPI.isTeacher(TeacherID))
            return ResponseEntity.status(202).body(TeacherAPI.updateTea(Teacher));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");
    }
    @DeleteMapping("/delete/TeacherID")
    public ResponseEntity delTea(@PathVariable int TeacherID){

        if(TeacherAPI.isTeacher(TeacherID))
            return ResponseEntity.status(202).body(TeacherAPI.delTea(TeacherID));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");
    }

    @GetMapping("/getBySalary/{salary}")
    public ResponseEntity getTea(@PathVariable double salary){

        return ResponseEntity.status(200).body(TeacherAPI.getTeacherOver(salary));

    }
}
