/* we want to create an interface so that we can specify the data the request going to serve, define all http requests */
export interface Employee {
    /* we define all the attributes employee has */
    id: number;
    name: string;
    email: string;
    phone: string;
    jobTitle: string;
    imageUrl: string;
    employeeCode: string; 
    
}
