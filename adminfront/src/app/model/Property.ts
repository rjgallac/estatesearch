import { Image } from './Image'

export class Property {
    id: number = 0;
    address: string = "";
    addressId: string = "";
    bathrooms: number = 0;
    bedrooms: number = 0;
    datePosted: string = "";
    description: string = ""; 
    price: number = 0;
    image: string = "";
    images: Array<Image> = new Array();
}