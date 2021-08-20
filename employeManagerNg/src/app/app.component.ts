import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response; 
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  /* onAddEmployee function will work here */
  public onAddEmployee(addForm: NgForm): void {
    
  }


  /* this modal we pass tells what user trying to do, add delete etc,
   to know which modal to open, returns void, has b */
    public onOpenModal(employee: Employee, mode: string): void {

      /* we add the buttons to main componenet div of app.component.html here */
      const container = document.getElementById('main-container');

      /* default button type = subit, we change it to "button",
       default not displayed, data-target which is id of modal will be dynamic */
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle','modal');
      /* check what mode user is in, which one button of nav bar user clicks,
       we get mode from just above function onopenModal, put # sign as 'modal' references an id */
       if ( mode == 'add') {
          button.setAttribute('data-target','#addEmployeeModal');
       }
      
       if ( mode == 'edit') {
          button.setAttribute('data-target','#updateEmployeeModal');
       }
      
       if ( mode == 'delete') {
          button.setAttribute('data-target','#deleteEmployeeModal');
       }

       /* here we know which data-target is used, we pass the button using appendChild of container, button exists in DOM of html now */
       container?.appendChild(button);
       button.click();


    }





}
