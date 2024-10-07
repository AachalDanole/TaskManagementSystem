import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/Employee';
import { TaskServices } from 'taskService';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit{



  emps: Employee[] = [];
  empId: number = 0;
  emp: any = [];
 
  constructor(private employeeService: TaskServices,
    private router: Router) { }

  ngOnInit(): void {
    this.getEmpList(this.empId);
  }

  private getEmpList(empId:number){
    this.employeeService.getEmpList(empId).subscribe((data: any) => {
      this.emps = data;

      //int num[]
      //int num1[]
      //num = num1
    });
  }

     empDetails(empId: number){
    this.router.navigate(['emp-details', empId]);
  }

  updateTask(empId: number){
    this.router.navigate(['update-task', empId]);
  }

  deletetaskById(empId: number){
    console.log(empId)
    this.employeeService.deletetaskById(empId).subscribe( (data: any) => {
      console.log(data);
      this.getEmpList(empId);
    })
  }

getEmployeById(empId?: number){
  
  

  var status = confirm("Are you sure to See this record?");
  if (status == true) {
  this.router.navigate(['user-list', empId]);
  }
  else{
    this.getEmpList(this.empId);
    }
 
  }
}





