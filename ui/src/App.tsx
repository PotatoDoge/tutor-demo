import React from 'react';
import Header from './components/Header/Header';
import { Route, Routes } from 'react-router-dom';
import TutorAppointmentView from './components/TutorAppointmentView/TutorAppointmentView';
import StudentAppointmentView from './components/StudentAppointmentView/StudentAppointmentView';
import StudentConfirmAppointmentView from './components/StudentConfirmAppointmentView/StudentConfirmAppointmentView';
import TutorConfirmAppointmentView from './components/TutorConfirmAppointmentView/TutorConfirmAppointmentView';
import LoginView from './components/LoginView/LoginView';

function App() {
  return (
    <>
    <div className='mb-4'>
      <Header />
    </div>
    <Routes>
      <Route path="/tutor" element={<TutorAppointmentView />}/>
      <Route path="/student" element={<StudentAppointmentView />}/>
      <Route path="/tutor/confirm" element={<TutorConfirmAppointmentView />}/>
      <Route path="/student/confirm" element={<StudentConfirmAppointmentView />}/>
      <Route path="/" element={<LoginView />}/>
    </Routes>
    </>
  );
}

export default App;
