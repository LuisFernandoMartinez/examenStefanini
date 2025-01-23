import { BrowserRouter , Route, Routes,Navigate } from 'react-router-dom';
import Login from './components/Login';
import PrivateRoute from './utils/PrivateRoute';
import Dashboard from './components/Dashboard';
import FormularioPersons from './components/FormularioPersons';

function App() {

  return (
    <BrowserRouter>
     <Routes>
      <Route path="/login" element={<Login/>}/>
      <Route from="/" element={<Navigate to="/login" replace />} />
      <Route
          path="/dashboard"
          element={
            <PrivateRoute>
              <FormularioPersons />
            </PrivateRoute>
          }
        /> 
    </Routes>
  </BrowserRouter>
  );
}

export default App;
