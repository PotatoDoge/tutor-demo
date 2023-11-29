import '@mantine/core/styles.css';
import '@mantine/dates/styles.css';

import Header from './components/Header/Header';
import { Route, Routes } from 'react-router-dom';
import TutorAppointmentView from './components/TutorAppointmentView/TutorAppointmentView';
import StudentAppointmentView from './components/StudentAppointmentView/StudentAppointmentView';
import StudentConfirmAppointmentView from './components/StudentConfirmAppointmentView/StudentConfirmAppointmentView';
import TutorConfirmAppointmentView from './components/TutorConfirmAppointmentView/TutorConfirmAppointmentView';
import LoginView from './components/LoginView/LoginView';
import Footer from './components/Footer/Footer';
import DevelopmentView from './components/DevelopmentView/DevelopmentView';

function App() {
  return (
    <div className='flex justify-between flex-col h-screen bg-slate-500'>
      <Header />
      <Routes>
        <Route path="/tutor" element={<TutorAppointmentView />}/>
        <Route path="/student" element={<StudentAppointmentView />}/>
        <Route path="/tutor/confirm" element={<TutorConfirmAppointmentView />}/>
        <Route path="/student/confirm" element={<StudentConfirmAppointmentView />}/>
        <Route path="/dev" element={<DevelopmentView />}/>
        <Route path="/" element={<LoginView />}/>
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
