import React, { useState, useEffect } from 'react';
import axios from 'axios';

function FormularioPersons() {
  const [persons, setPersons] = useState([]);
  const [person, setPerson] = useState({ id: '', namePerson: '', lastNamePerson: ''
      , dateBirth:'',jobPosition:'',salary:'' });

  // Fetch all persons from the backend
  const tokenDM=localStorage.getItem('token');
  
  const headers = {
    'Authorization': 'Bearer '+ tokenDM,
    'My-Custom-Header': 'foobar'
  };

  const fetchPersons = async () => {
    const response = await axios.get('http://localhost:9192/api/employeesBarrilito/getAll', {headers});
    setPersons(response.data);
  };

  useEffect(() => {
    fetchPersons();
  }, []);

  // Handle form changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPerson({ ...person, [name]: value });
  };

  // Handle form submit to create a new person
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (person.id) {
      await axios.put(`http://localhost:9192/api/employeesBarrilito/update/${person.id}`, person, {headers});
    } else {
      await axios.post('http://localhost:9192/api/employeesBarrilito/create', person, {headers});
    }
    setPerson({ id: '', namePerson: '', lastNamePerson: '',dateBirth:'',jobPosition:'',salary:'' });
    fetchPersons();
  };

  // Handle delete
  const handleDelete = async (id) => {
    await axios.delete(`http://localhost:9192/api/employeesBarrilito/delete/${id}`,{headers});
    fetchPersons();
  };

  return (
    <div className="">
        <br />
      <h2>-Person CRUD</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="namePerson"
          value={person.namePerson}
          onChange={handleInputChange}
          placeholder="Name Person"
        /> <br />
        <input
          type="text"
          name="lastNamePerson"
          value={person.lastNamePerson}
          onChange={handleInputChange}
          placeholder="Last Name Person"
        /> <br />
        <input
          type="text"
          name="dateBirth"
          value={person.dateBirth}
          onChange={handleInputChange}
          placeholder="DATE BITHDAY"
        /> <br />
        <input
          type="text"
          name="jobPosition"
          value={person.jobPosition}
          onChange={handleInputChange}
          placeholder="Job Position"
        /> <br />
        <input
          type="text"
          name="salary"
          value={person.salary}
          onChange={handleInputChange}
          placeholder="Salary"
        /> <br />
        <button type="submit">Save</button>
      </form>


      <h2>-Persons List</h2>
      <ul>
        {persons.map((p) => (
          <li key={p.id}> {p.id} {' '}
            {p.namePerson} {' '} ({p.lastNamePerson}) {' '} {p.dateBirth} {' '}{p.jobPosition} {' '}{p.salary} {' '}
            <button onClick={() => setPerson(p)}>Edit</button>
            <button onClick={() => handleDelete(p.id)}>Delete</button>
          </li>
        ))}
      </ul>
      
    </div>
  );
}

export default FormularioPersons;