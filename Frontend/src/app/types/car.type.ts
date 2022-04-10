import { Repair } from './repair.type';

export class Car{
    id!: String;
    repairs!: Repair[];
    manufacture_date!: String;
    spz!: String;
    type!: String;

    constructor(id: String, manufacture_date: String, spz: String, type: String){
        this.id = id;
        this.manufacture_date = manufacture_date;
        this.spz = spz;
        this.type = type;
    }

}