import React from "react";
import { Navigate } from "react-router-dom";

// Function to check if the user is authenticated
const isAuthenticated = () => {
  const token = localStorage.getItem("token"); // Or use cookies
  if (!token) return false;

  try {
    const payload = JSON.parse(atob(token.split(".")[1])); // Decode JWT payload
    const isTokenExpired = payload.exp * 1000 < Date.now(); // Check expiration
    return !isTokenExpired;
  } catch (error) {
    return false;
  }
};

const PrivateRoute = ({ children }) => {
  return isAuthenticated() ? children : <Navigate to="/login" />;
};

export default PrivateRoute;
