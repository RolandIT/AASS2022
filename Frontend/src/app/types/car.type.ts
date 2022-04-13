import { Repair } from './repair.type';

export class Car{
    id?: number;
    repairs?: Repair[];
    yearOfManufacture?: String;
    spz?: String;
    brand?: String;
    idOwner?: number;

    constructor(id?: number, yearOfManufacture?: String, spz?: String, brand?: String){
        this.id = id;
        this.yearOfManufacture = yearOfManufacture;
        this.spz = spz;
        this.brand = brand;
    }
}