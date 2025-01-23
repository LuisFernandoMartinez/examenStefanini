import axios from "axios";

export class PersonaService{
    baseUrl="http://localhost:8080/root/"

    getAll(){
        return axios.get(this.baseUrl + "getAll").then(res => res.data);
    }
}