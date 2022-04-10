export class User {   
    id: number = 0;
    type: number = 1;
    username: String = "Zakaznik";
    password: String = "";

    constructor(username: String, password: String){
        this.username = username;
        this.password = password;

    }
}