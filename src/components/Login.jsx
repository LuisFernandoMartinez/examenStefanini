import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './login.css';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import 'bootstrap/dist/css/bootstrap.min.css';



const Login = () => {
  const [userName, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();


  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:9192/api/authenticate', { userName, password });
      // Assume the response contains the JWT token
      const token = response.data.token;
      console.log(response.data)
      localStorage.setItem('token', token);
      navigate('/dashboard'); // Redirect to a protected route
    } catch (error) {
      console.error('Login failed:', error);
    }
  };


  return ( 
    <>
    <Card className="text-center">
      <Card.Header color='blue'></Card.Header>
      <Card.Body>
        <Card.Title> <h2>Loggin Full Stack App</h2></Card.Title>
        <Card.Text>

        <form onSubmit={handleLogin}>
        <input 
        type="text" 
        placeholder="Username" 
        value={userName} 
        onChange={(e) => setUsername(e.target.value)} 
          /> <br /> <br />
        <input 
        type="password" 
        placeholder="Password" 
        value={password} 
        onChange={(e) => setPassword(e.target.value)} 
        /> <br /> <br />
        <Button variant="primary"  type="submit" size='lg'> Login </Button>
        </form> 

        </Card.Text>
        </Card.Body>
        <br />
      <Card.Footer className="text-muted">Luis Mtz</Card.Footer>
    </Card>

</>
  );
};

export default Login;